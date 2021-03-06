package com.xz.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductExample;
import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.vo.MatchProductVO;
import com.xz.match.mapper.MatchProductMapper;
import com.xz.match.service.MatchProductService;
import com.xz.match.service.MatchProductSubService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenwf
 * @date 2020/11/16
 */
@Service
@Transactional
public class MatchProductServiceImpl implements MatchProductService {

    @Resource
    private MatchProductMapper matchProductMapper;

    @Resource
    private SignRecordService signRecordService;

    @Override
    public long countByExample(MatchProductExample example) {
        return matchProductMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductExample example) {
        return matchProductMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProduct record) {
        return matchProductMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProduct record) {
        return matchProductMapper.insertSelective(record);
    }

    @Override
    public List<MatchProduct> selectByExample(MatchProductExample example) {
        return matchProductMapper.selectByExample(example);
    }

    @Override
    public MatchProduct selectByPrimaryKey(Long id) {
        return matchProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProduct record, MatchProductExample example) {
        return matchProductMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MatchProduct record, MatchProductExample example) {
        return matchProductMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProduct record) {
        return matchProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProduct record) {
        return matchProductMapper.updateByPrimaryKey(record);
    }

    @Autowired
    private MatchProductSubService matchProductSubService;

    /**
     * 添加物资
     *
     * @param matchProductVO 物资VO
     * @return {@link MatchProductVO}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult addMatchProduct(MatchProductVO matchProductVO) {
        MatchProduct matchProduct = new MatchProduct();
        BeanUtils.copyProperties(matchProductVO, matchProduct);
        matchProduct.setCreatedTime(System.currentTimeMillis());
        // 添加物资
        this.insertSelective(matchProduct);

        // 添加新物资时需要更新参赛人员的发放情况状态，即：把全部发放改为部分发放
        ValidateUtils.notNull(matchProductVO.getMatchId(), "matchId不能为空");
        ValidateUtils.notNull(matchProductVO.getSubjectId(), "subjectId不能为空");
        Map param = new HashMap<String, Object>();
        param.put("matchId", matchProductVO.getMatchId());
        param.put("subjectId", matchProductVO.getSubjectId());
        param.put("status", 1);// 2-部分发放，1-已发放，0-未发放
        signRecordService.modifyMacthSignRecordByMatchIdAndSubjectId(param);// 更新报名信息，物资发放的状态

        // 新增物资子项
        if (matchProductVO.getMatchProductSubs() != null && matchProductVO.getMatchProductSubs().size() > 0) {
            for (MatchProductSub matchProductSub : matchProductVO.getMatchProductSubs()) {
                matchProductSub.setProductId(matchProduct.getId());
                if(matchProductSub.getId() == null) {
                    matchProductSubService.insertSelective(matchProductSub);
                }else{
                    matchProductSubService.updateByPrimaryKeySelective(matchProductSub);
                }
            }
        }
        return ResponseResult.ok().setData(matchProduct);
    }

    /**
     * 分页查找物资
     *
     * @param params    参数个数
     * @param pageParam 页面参数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductsByPage(PageParam pageParam, Map<String, Object> params) {
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
        List<MatchProduct> matchProducts = matchProductMapper.findBy(params);
        return ResponseResult.ok().setData(new PageInfo<>(matchProducts));
    }

    /**
     * 查找物资
     *
     * @param params    参数个数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProducts(Map<String, Object> params) {
        return ResponseResult.ok().setData(matchProductMapper.findBy(params));
    }

    /**
     * 查找物资报表信息
     *
     * @param pageParam 页面参数
     * @param params    参数个数
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductsReport(PageParam pageParam, Map<String, Object> params) {
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
        List<MatchProductVO> matchProducts = matchProductMapper.selectMatchProductsReport(params);
        return ResponseResult.ok().setData(new PageInfo<>(matchProducts));
    }
    /**
     * 根据id查询物资id
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductById(Long id) {
        // 查找物资
        MatchProduct matchProduct = this.selectByPrimaryKey(id);
        MatchProductVO matchProductVO = null;
        if (matchProduct != null) {
            matchProductVO = new MatchProductVO();
            ValidateUtils.notNull(matchProduct, "请求参数错误");
            BeanUtils.copyProperties(matchProduct, matchProductVO);

            // 查询是否有物资子项
            List<MatchProductSub> matchProductSubList = matchProductSubService.findMatchProductSubByProductId(id);
            if (!matchProductSubList.isEmpty()) {
                List<MatchProductSub> matchProductSubs = new ArrayList<>();
                for (MatchProductSub matchProductSub : matchProductSubList) {
                    matchProductSubs.add(matchProductSub);
                }
                matchProductVO.setMatchProductSubs(matchProductSubs);
            } else {
                matchProductVO.setMatchProductSubs(new ArrayList<>());
            }
            return ResponseResult.ok().setData(matchProductVO);
        } else {
            return ResponseResult.ok().setData(new MatchProductVO());
        }
    }

    /**
     * 修改物资
     *
     * @param matchProductVO 物资VO
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult modifyMatchProduct(MatchProductVO matchProductVO) {
        MatchProduct matchProduct = new MatchProduct();
        BeanUtils.copyProperties(matchProductVO, matchProduct);
        // 修改物资
        this.updateByPrimaryKeySelective(matchProduct);
        // 新增物资子项
        if (!matchProductVO.getMatchProductSubs().isEmpty()) {
            for (MatchProductSub matchProductSub : matchProductVO.getMatchProductSubs()) {
                if (matchProductSub.getId() == null) {
                    matchProductSub.setProductId(matchProduct.getId());
                    this.matchProductSubService.insertSelective(matchProductSub);
                } else {
                    this.matchProductSubService.updateByPrimaryKeySelective(matchProductSub);
                }

            }
        }
        return ResponseResult.ok().setData(matchProduct);
    }

    /**
     * 删除物资
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult removeMatchProduct(Long id) {
        // 删除物资
        this.deleteByPrimaryKey(id);
        // 同时删除物资子项
        List<MatchProductSub> matchProductSubList = matchProductSubService.findMatchProductSubByProductId(id);
        if (!matchProductSubList.isEmpty()) {
            for (MatchProductSub matchProductSub : matchProductSubList) {
                matchProductSubService.removeMatchProductSub(matchProductSub.getId());
            }
        }
        return ResponseResult.ok();
    }

    @Override
    public List<MatchProduct> findBy(Map param) {
        return matchProductMapper.findBy(param);
    }
}


