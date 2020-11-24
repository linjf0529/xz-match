package com.xz.match.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.SignRecord;
import com.xz.match.entity.SignRecordExample;
import com.xz.match.entity.SignRecordFieldTable;
import com.xz.match.entity.UserInfo;
import com.xz.match.mapper.SignRecordMapper;
import com.xz.match.service.SignRecordFieldTableService;
import com.xz.match.service.SignRecordService;
import com.xz.match.service.UserInfoService;
import com.xz.match.service.WsossService;
import com.xz.match.utils.PageParam;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.SignRecordFieldUtils;
import com.xz.match.utils.StringUtils;
import com.xz.match.utils.enums.OrderChannel;
import com.xz.match.utils.enums.Sex;
import com.xz.match.utils.excel.Tuple;
import com.xz.match.utils.exception.CommonException;
import com.xz.match.utils.file.FSConstants;
import com.xz.match.utils.file.Image;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * @author chenwf
 * @date 2020/11/16
 */
@Service
@Transactional
public class SignRecordServiceImpl implements SignRecordService {

    @Resource
    private SignRecordMapper signRecordMapper;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SignRecordFieldTableService signRecordFieldTableService;
    @Resource
    private WsossService wsossService;

    @Override
    public long countByExample(SignRecordExample example) {
        return signRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SignRecordExample example) {
        return signRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return signRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SignRecord record) {
        return signRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(SignRecord record) {
        return signRecordMapper.insertSelective(record);
    }

    @Override
    public List<SignRecord> selectByExample(SignRecordExample example) {
        return signRecordMapper.selectByExample(example);
    }

    @Override
    public SignRecord selectByPrimaryKey(Long id) {
        return signRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SignRecord record, SignRecordExample example) {
        return signRecordMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SignRecord record, SignRecordExample example) {
        return signRecordMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SignRecord record) {
        return signRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SignRecord record) {
        return signRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> countSignRecordDispatchInfo(Map<String, Object> param) {
        return signRecordMapper.countSignRecordDispatchInfo(param);
    }

    @Override
    public List<SignRecord> findBy(JSONObject param) {
        return signRecordMapper.findBy(param);
    }

    /**
     * 参赛人员列表
     *
     * @param pageParam
     * @param param
     * @return
     */
    @Override
    public ResponseResult getRecordInfos(PageParam pageParam, JSONObject param) {
        PageHelper.startPage(pageParam.getPageNo(),pageParam.getPageSize());
        List<SignRecord> signRecords = this.findBy(param);
        PageInfo<SignRecord> pageInfo = new PageInfo<>(signRecords);
        List<SignRecord> list = pageInfo.getList();
        if(!list.isEmpty()){
            List<Long> recordIds = list.stream().map(s -> s.getId()).collect(Collectors.toList());
            JSONObject fileParam = new JSONObject();
            fileParam.put("recordIds",recordIds);
            List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(fileParam);
            Map<Long,List<SignRecordFieldTable>> map = signRecordFieldTables.stream().collect(Collectors.groupingBy(SignRecordFieldTable::getRecordId));
            for (SignRecord signRecord : pageInfo.getList()) {
                signRecord.setSignRecordInfo(map.get(signRecord.getId()));
            }
        }
        return ResponseResult.ok().setData(pageInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importMacthSignRecord(MatchSubject matchSubject, Tuple<List<JSONObject>, List<String>> result, Map<Tuple<String, String>, Integer> relation, JSONObject param) {
        addSignRecord(result.key, relation, null, matchSubject, param);
//        if (matchSubject.getType() == SubjectType.SINGLE.getType()) {// 个人赛需要校验导入人数
//            signRecordApiService.checkLimit(matchSubject, result.key.size(), null);
//
//
//            // 已报名人数
//            signRecordApiService.resetSignCount(matchSubject, null);
//        }else if(matchSubject.getType() == SubjectType.TEAM.getType()){
//            Map<String, List<JSONObject>> collect = result.key.stream().collect(Collectors.groupingBy(jsonObject -> jsonObject.getString(SignRecordFieldUtils.teamNameControlKey)));
//            for(Map.Entry<String,  List<JSONObject>> entry : collect.entrySet()){
//                String orderNo = autoOrderId();
//                addSignRecord(entry.getValue(),relation,orderNo, matchSubject, param);
//                // 已报名人数
//                signRecordApiService.resetSignCount(matchSubject, null);
//            }
//        }
    }

    /**
     * 导入赛事报名记录，添加赛事记录
     *
     * @param key
     * @param relation
     * @param orderNo
     * @param matchSubject
     * @param param
     */
    private void addSignRecord(List<JSONObject> key, Map<Tuple<String, String>, Integer> relation, String orderNo, MatchSubject matchSubject, JSONObject param) {
        UserInfo user = null;
        for (JSONObject jsonObject : key) {
            String name = jsonObject.getString(SignRecordFieldUtils.nameControlKey);
            String phone = jsonObject.getString(SignRecordFieldUtils.phone2ControlKey);
            String certificateNo = jsonObject.getString(SignRecordFieldUtils.cerControlKey);
            String matchNo = jsonObject.getString(SignRecordFieldUtils.matchNoControlKey);
            Integer gradeNo = jsonObject.getInteger(SignRecordFieldUtils.gradeNoControlKey);
            String sex = jsonObject.getString(SignRecordFieldUtils.sexControlKey);
            String memberType = jsonObject.getString(SignRecordFieldUtils.memberTypeControlKey);
            String teamName = jsonObject.getString(SignRecordFieldUtils.teamNameControlKey);
            String teamNum = "1";
            SignRecord signRecord = new SignRecord();
            signRecord.setMatchId(matchSubject.getMatchId());//赛事Id
            signRecord.setMatchName(matchSubject.getMatchName());//赛事名称
            signRecord.setSubjectId(matchSubject.getId());//科目ID
            signRecord.setSubjectName(matchSubject.getSubjectName());//科目名称
            signRecord.setName(name);                                    // 姓名
            signRecord.setSex(Sex.WOMAN.getText().equals(sex) ? 0 : 1);  // 性别
            signRecord.setPhone(phone);                                  // 手机号
            signRecord.setCertificateNo(certificateNo);                  // 证件号码
            signRecord.setMatchNo(matchNo);                                 // 参赛号码
            signRecord.setGradeNo(gradeNo);                                 // 排序
            signRecord.setChannel(OrderChannel.XM_IMPORT.getStatus() + "");
            signRecord.setReview(0);                                     //
            signRecord.setAvailable(1);                                  // 是否可用
            signRecord.setExpenses(0L);
            user = userInfoService.saveUser(signRecord.getPhone(), signRecord.getCertificateNo(), signRecord.getName(),2);
            signRecord.setMemberType(0);
            signRecord.setOrderId(autoOrderId());
            signRecord.setOrderNo(signRecord.getOrderId());
            // 校验重复报名
            checkDuplicate(matchSubject, signRecord, null);
            signRecord.setUserId(user.getId());
            insertSelective(signRecord);

            // 添加每条报名记录的自定义报名字段
            List<String> teamNames = new ArrayList<>();//赛事导入的时候可能存在多个团队名称，过滤掉一个
            relation.forEach(new BiConsumer<Tuple<String, String>, Integer>() {
                @Override
                public void accept(Tuple<String, String> tuple, Integer integer) {
                    if (!SignRecordFieldUtils.subjectIdControlKey.equals(tuple.key) && !teamNames.contains(tuple.key)) {
                        SignRecordFieldTable table = new SignRecordFieldTable();
                        table.setRecordId(signRecord.getId());
                        table.setComment(tuple.value);
                        table.setControlKey(tuple.key);
                        table.setValue(jsonObject.getString(tuple.key));

                        signRecordFieldTableService.insertSelective(table);
                        teamNames.add(tuple.key);
                    }
                }
            });
        }
    }

    private void checkDuplicate(MatchSubject matchSubject, SignRecord signRecord, Object o) {
        JSONObject param = new JSONObject();
        param.put("certificateNoStr", signRecord.getCertificateNo());
        param.put("phoneStr", signRecord.getPhone());
        param.put("certificateNoAndPhone", 1);
        param.put("subjectId", signRecord.getSubjectId());
        List<SignRecord> signRecords = findBy(param);
        if (!signRecords.isEmpty()) {
            throw new CommonException("相同的证件号码已报名该赛事:" + signRecord.getCertificateNo());
        }
    }

    /**
     * 生成订单编号  时间戳+3位整数
     *
     * @return
     */
    @Override
    public String autoOrderId() {
        Random rand = new Random();
        //[900]：900个    100：从100
        int x = (rand.nextInt(900) + 100);
        return DateUtil.format(new Date(), "yyMMddHHmmssSSS") + x;
    }

    /**
     * 物资领取完，签字
     *  @param recordId
     * @param picData
     */
    @Override
    public ResponseResult uploadSignPic(Long recordId, String picData) {
        SignRecord signRecord = this.selectByPrimaryKey(recordId);
        if(signRecord == null){
            throw new CommonException("未找到该选手");
        }
        if(signRecord.getStatus() != 1){
            throw new CommonException("物资未全部领取");
        }
        if(StringUtils.isNotEmpty(signRecord.getSignPic())){
            throw new CommonException("您已签字");
        }
        String imageName = StringUtils.getUUID() + ".png";
        // 指定上传文件夹
        String fileKeyWithFolder = "xz-match/"+imageName;
        ResponseResult responseResult = wsossService.uploadImage(Base64.decode(picData), imageName, FSConstants.WSOSS_BUCKET_NAME_DEFAULT, fileKeyWithFolder);
        if(responseResult.isSuccess()){
            Image image = JSONObject.parseObject(JSONObject.toJSONString(responseResult.getData()),Image.class);
            if(image != null){
                SignRecord update = new SignRecord();
                update.setId(recordId);
                update.setSignPic(image.getImageUrl());
                this.updateByPrimaryKeySelective(update);
                return ResponseResult.ok();
            }
        }
        return ResponseResult.fail("上传失败");
    }

    @Override
    public ResponseResult deleteRecord(String ids) {
        List<Long> idList = Arrays.asList(ids.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        if(!idList.isEmpty()){
            signRecordMapper.deleteRecord(idList);
        }
        return ResponseResult.ok();
    }

    /**
     * 批量更新参赛人员的发放情况状态
     *
     * @param param 参数
     * @return int
     */
    @Override
    public int modifyMacthSignRecordByMatchIdAndSubjectId(Map<String, Object> param) {
        return signRecordMapper.updateMacthSignRecordByMatchIdAndSubjectId(param);
    }
}






