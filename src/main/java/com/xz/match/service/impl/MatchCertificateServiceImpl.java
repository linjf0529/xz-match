package com.xz.match.service.impl;

import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.file.FSConstants;
import com.xz.match.service.WsossService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xz.match.entity.MatchCertificateExample;
import java.util.List;
import com.xz.match.mapper.MatchCertificateMapper;
import com.xz.match.entity.MatchCertificate;
import com.xz.match.service.MatchCertificateService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chenwf
 * @date 2020/11/16
 */  
@Service
@Transactional
public class MatchCertificateServiceImpl implements MatchCertificateService{

    @Resource
    private MatchCertificateMapper matchCertificateMapper;

    @Resource
    private WsossService wsossService;
    @Override
    public long countByExample(MatchCertificateExample example) {
        return matchCertificateMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MatchCertificateExample example) {
        return matchCertificateMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return matchCertificateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MatchCertificate record) {
        return matchCertificateMapper.insert(record);
    }

    @Override
    public int insertSelective(MatchCertificate record) {
        return matchCertificateMapper.insertSelective(record);
    }

    @Override
    public List<MatchCertificate> selectByExample(MatchCertificateExample example) {
        return matchCertificateMapper.selectByExample(example);
    }

    @Override
    public MatchCertificate selectByPrimaryKey(Long id) {
        return matchCertificateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MatchCertificate record,MatchCertificateExample example) {
        return matchCertificateMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MatchCertificate record,MatchCertificateExample example) {
        return matchCertificateMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MatchCertificate record) {
        return matchCertificateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MatchCertificate record) {
        return matchCertificateMapper.updateByPrimaryKey(record);
    }

    @Override
    public MatchCertificate getCertificateBySubjectId(Long subjectId) {
        return matchCertificateMapper.getCertificateBySubjectId(subjectId);
    }

    @Override
    public ResponseResult uploadImage(byte[] imageContent) {
        String imageName = StringUtils.getUUID() + ".png";
        // 指定上传文件夹
        String fileKeyWithFolder = "match/"+imageName;
        return wsossService.uploadImage(imageContent,imageName, FSConstants.WSOSS_BUCKET_NAME_DEFAULT, fileKeyWithFolder);
    }

}
