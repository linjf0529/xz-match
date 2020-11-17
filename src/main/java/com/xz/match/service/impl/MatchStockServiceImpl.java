package com.xz.match.service.impl;

import com.xz.match.entity.MatchProduct;
import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.vo.MatchStockVO;
import com.xz.match.mapper.MatchProductMapper;
import com.xz.match.mapper.MatchProductSubMapper;
import com.xz.match.service.MatchProductService;
import com.xz.match.service.MatchProductSubService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.enums.StockOperation;
import com.xz.match.utils.exception.CommonException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.MatchStockExample;

import java.util.ArrayList;
import java.util.List;
import com.xz.match.entity.MatchStock;
import com.xz.match.mapper.MatchStockMapper;
import com.xz.match.service.MatchStockService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
public class MatchStockServiceImpl implements MatchStockService{

    @Resource
    private MatchStockMapper matchStockMapper;
    @Resource
    private MatchProductMapper matchProductMapper;
    @Resource
    private MatchProductSubMapper matchProductSubMapper;
    @Resource
    private MatchProductService matchProductService;
    @Resource
    private MatchProductSubService matchProductSubService;

    @Override
    public long countByExample(MatchStockExample example) {
        return matchStockMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchStockExample example) {
        return matchStockMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchStockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchStock record) {
        return matchStockMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchStock record) {
        return matchStockMapper.insertSelective(record);
    }

    @Override
    public List<MatchStock> selectByExample(MatchStockExample example) {
        return matchStockMapper.selectByExample(example);
    }

    @Override
    public MatchStock selectByPrimaryKey(Long id) {
        return matchStockMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchStock record,MatchStockExample example) {
        return matchStockMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchStock record,MatchStockExample example) {
        return matchStockMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchStock record) {
        return matchStockMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchStock record) {
        return matchStockMapper.updateByPrimaryKey(record);
    }

    /**
     * 添加库存
     *
     * @param matchStockVO 库存VO
     * @return {@link ResponseResult}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult addMatchStock(MatchStockVO matchStockVO) {
        //  添加库存
        MatchStock matchStock =new MatchStock();
        BeanUtils.copyProperties(matchStockVO, matchStock);

        if(!matchStockVO.getMatchProductSubs().isEmpty()){
            // 场景：未存在子项库存的情况
            // 添加库存记录
            this.insertSelective(matchStock);
            // 加库存
            if(StockOperation.ADD.getCode().equals(matchStockVO.getStockOperation())){
                matchProductMapper.updateToAddMatchStockByProductId(matchStockVO);
            }else {
                // 减库存
                int stockNumber = matchProductMapper.updateToMinusMatchStockByProductId(matchStockVO);
                if(stockNumber == 0){
                    throw new CommonException(matchStockVO.getProductName()+"扣减库存不足");
                }
            }
            return ResponseResult.ok().setData(matchStock);
        }

        // 场景：存在子项库存的情况，更新子项库存
        for(MatchProductSub matchProductSub:matchStockVO.getMatchProductSubs()){
            ValidateUtils.notNull(matchProductSub.getId(), "子库存ID不能为空");
            // 物资子项id
            matchStock.setProductSubId(matchProductSub.getId());
            matchStock.setProductSubName(matchProductSub.getProductSubName());
            matchStock.setStockNumber(matchProductSub.getStockNumber());
            // 添加库存记录
            this.insertSelective(matchStock);
            // 加子库存
            if(StockOperation.ADD.getCode().equals(matchStockVO.getStockOperation())){
                matchProductSubMapper.updateToAddMatchStockByProductSubId(matchProductSub);
            }else {
                // 减子库存
                int stockNumber = matchProductSubMapper.updateToMinusMatchStockByProductSubId(matchProductSub);
                // 同时扣减子项库存，须同时满足扣减
                if(stockNumber == 0){
                    throw new CommonException(matchStock.getProductName() +"："+matchProductSub.getProductSubName()+"扣减库存不足");
                }
            }
        }
        return ResponseResult.ok().setData(matchStock);
    }

    /**
     * 根据产品id查询物资库存
     *
     * @param productId 产品id
     * @return {@link ResponseResult}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseResult findMatchStock(Long productId) {
        // 查找物资
        MatchStockVO matchStockVO = new MatchStockVO();
        MatchProduct matchProduct = matchProductService.selectByPrimaryKey(productId);
        ValidateUtils.notNull(matchProduct, "物资ID不存在");
        BeanUtils.copyProperties(matchProduct, matchStockVO);

        // 库存列表
        List<MatchStock> MatchStockes = matchStockMapper.selectMatchStockByProductId(productId);
        matchStockVO.setMatchStockes(MatchStockes);

        // 物资子项
        List<MatchProductSub> matchProductSubList = matchProductSubService.findMatchProductSubByProductId(productId);
        if(!matchProductSubList.isEmpty()) {
            List<MatchProductSub> matchProductSubs = new ArrayList<>();
            for (MatchProductSub matchProductSub : matchProductSubList) {
                matchProductSubs.add(matchProductSub);
            }
            matchStockVO.setMatchProductSubs(matchProductSubs);
        }else{
            matchStockVO.setMatchProductSubs(new ArrayList<>());
        }
        return ResponseResult.ok().setData(matchStockVO);
    }
}
