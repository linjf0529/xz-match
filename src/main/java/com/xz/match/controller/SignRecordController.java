package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.SubjectSignField;
import com.xz.match.service.MatchSubjectService;
import com.xz.match.service.SignRecordFieldTableService;
import com.xz.match.service.SignRecordService;
import com.xz.match.service.SubjectSignFieldService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.SignRecordFieldUtils;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import com.xz.match.utils.excel.ExcelUtils;
import com.xz.match.utils.excel.Tuple;
import com.xz.match.utils.exception.CommonException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author chenwf
 * @date 2020/11/17
 */
@RestController
@RequestMapping("/match/sign/record")
public class SignRecordController extends BaseController {
    @Resource
    private MatchSubjectService matchSubjectService;
    @Resource
    private SignRecordFieldTableService signRecordFieldTableService;
    @Resource
    private SubjectSignFieldService subjectSignFieldService;
    @Resource
    private SignRecordService signRecordService;


    /**
     * 参赛人员列表
     * @return
     */
    @GetMapping
    public ResponseResult getRecordInfos(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return signRecordService.getRecordInfos(getPageParam(request),param);
    }

    /**
     * 导入赛事科目模板
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/subjectTemplate/importExcel")
    @AllowAnonymous
    public ResponseResult importExcel(MultipartHttpServletRequest file, HttpServletRequest request) throws Exception {
        ValidateUtils.notNull(file, 500,"导入文件不能为空");
        JSONObject param = getJSONObject(request);
        Long subjectId = param.getLong("subjectId");// 科目ID
        ValidateUtils.notNull(subjectId, 500,"科目id不能为空");
        MatchSubject matchSubject = matchSubjectService.selectByPrimaryKey(subjectId);
        ValidateUtils.notNull(matchSubject, "赛事科目不存在");
        // 科目报名字段
        Map<Tuple<String, String>, Integer> relation = new HashMap<>();

        relation.put(new Tuple<>("sf958293272", "科目ID"), 2);
//        if (matchSubject.getType() == SubjectType.TEAM.getType()) { // 科目是团体
//            relation.put(new Tuple<>("sf769633464", "成员类型"), 2);
//            relation.put(new Tuple<>("sf700241856", "团队名称"), 2);
//        }

        Map<String, Object> signFieldParam = new HashMap<>();
        signFieldParam.put("subjectId", subjectId);
        signFieldParam.put("stateList", Arrays.asList(1,2));
        List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(signFieldParam);
        subjectSignFields.forEach(new Consumer<SubjectSignField>() {
            @Override
            public void accept(SubjectSignField subjectSignField) {
                // 如果 状态为显示
                Integer state = subjectSignField.getState();
                if (state != 0) {
                    if(subjectSignField.getType() == 4){//文件
                        state = 1;
                    }
                    relation.put(new Tuple<>(subjectSignField.getControlKey(), subjectSignField.getComment()), state);
                }
            }
        });

        Tuple<List<JSONObject>, List<String>> result = ExcelUtils.resolveExcelMatch(file.getFile("file"), -1, relation,true);
        if (result.value.size() > 0) {
            throw new CommonException(JSONObject.toJSONString(result.value));
        }
        String imSubectId = result.key.get(0).getString(SignRecordFieldUtils.subjectIdControlKey);
        if(subjectId != Integer.parseInt(imSubectId)){
            throw new CommonException("导入的模板有误");
        }
        signRecordService.importMacthSignRecord(matchSubject, result,relation,param);

        return ResponseResult.ok();
    }


    /**
     * 物资领取完，签字
     * @param json  base64
     * @return
     */
    @PostMapping("/uploadSignPic")
    public ResponseResult uploadSignPic(@RequestBody JSONObject json){
        return signRecordService.uploadSignPic(json.getLong("recordId"),json.getString("picData"));
    }
}
