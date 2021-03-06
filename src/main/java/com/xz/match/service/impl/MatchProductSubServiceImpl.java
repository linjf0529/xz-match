package com.xz.match.service.impl;

import com.xz.match.entity.MatchProductSub;
import com.xz.match.entity.MatchProductSubExample;
import com.xz.match.entity.vo.MatchProductSubVO;
import com.xz.match.mapper.MatchProductSubMapper;
import com.xz.match.service.MatchProductSubService;
import com.xz.match.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
public class MatchProductSubServiceImpl implements MatchProductSubService{

    @Resource
    private MatchProductSubMapper matchProductSubMapper;

    @Resource
    private MatchProductSubMapper matchProductSubDao;

    @Override
    public long countByExample(MatchProductSubExample example) {
        return matchProductSubMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchProductSubExample example) {
        return matchProductSubMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchProductSubMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchProductSub record) {
        return matchProductSubMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchProductSub record) {
        return matchProductSubMapper.insertSelective(record);
    }

    @Override
    public List<MatchProductSub> selectByExample(MatchProductSubExample example) {
        return matchProductSubMapper.selectByExample(example);
    }

    @Override
    public MatchProductSub selectByPrimaryKey(Long id) {
        return matchProductSubMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchProductSub record,MatchProductSubExample example) {
        return matchProductSubMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchProductSub record,MatchProductSubExample example) {
        return matchProductSubMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchProductSub record) {
        return matchProductSubMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchProductSub record) {
        return matchProductSubMapper.updateByPrimaryKey(record);
    }



    /**
     * 根据产品id查询物资子项
     *
     * @param productId id
     * @return {@link ResponseResult}
     */
    @Override
    public List<MatchProductSub> findMatchProductSubByProductId(Long productId) {
        return matchProductSubDao.selectMatchProductSubByProductId(productId);
    }

    /**
     * 找到匹配的产品子通过id
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult findMatchProductSubById(Long id) {
        return ResponseResult.ok().setData(this.selectByPrimaryKey(id));
    }

    /**
     * 修改物资子项
     *
     * @param matchProductSubVO 物资子项VO
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult modifyMatchProductSub(MatchProductSubVO matchProductSubVO) {
        MatchProductSub matchProductSub = new MatchProductSub();
        BeanUtils.copyProperties(matchProductSubVO, matchProductSub);
        this.updateByPrimaryKeySelective(matchProductSub);
        return ResponseResult.ok().setData(matchProductSub);
    }

    /**
     * 删除物资子项
     *
     * @param id id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult removeMatchProductSub(Long id) {
        this.deleteByPrimaryKey(id);
        return ResponseResult.ok();
    }
}
