package com.xz.match.controller;

import com.alibaba.fastjson.JSONObject;
import com.xz.match.entity.MatchScore;
import com.xz.match.entity.MatchScoreConfig;
import com.xz.match.entity.MatchSubject;
import com.xz.match.entity.SignRecord;
import com.xz.match.service.MatchScoreConfigService;
import com.xz.match.service.MatchScoreService;
import com.xz.match.service.MatchSubjectService;
import com.xz.match.service.SignRecordService;
import com.xz.match.utils.ResponseResult;
import com.xz.match.utils.ValidateUtils;
import com.xz.match.utils.aop.AllowAnonymous;
import com.xz.match.utils.enums.MatchScoreDefaultConfig;
import com.xz.match.utils.excel.ExcelUtils;
import com.xz.match.utils.excel.Tuple;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.xmlbeans.impl.regex.Match;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @program: xz-match
 * @description: 赛事成绩
 * @author: Linjf
 * @create date: 2020-11-17 11:24
 **/
@RestController
@RequestMapping("/matchs/score")
public class MatchScoreController extends BaseController{
    @Resource
    private MatchScoreService matchScoreService;
    @Resource
    private SignRecordService signRecordService;
    @Resource
    private MatchSubjectService matchSubjectService;
    @Resource
    private MatchScoreConfigService matchScoreConfigService;
    @AllowAnonymous
    @GetMapping("/record")
    public ResponseResult findSignRecordScore(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        return matchScoreService.findSignRecordScore(getPageParam(request),param);
    }
    @AllowAnonymous
    @GetMapping
    public ResponseResult getScore(HttpServletRequest request){
        JSONObject param = getJSONObject(request);
        ValidateUtils.notNull(param.getString("subjectId"),"科目id不能为空");
        ValidateUtils.notNull(param.getString("recordId"),"报名记录不能为空");
        List<MatchScore> matchScores=matchScoreService.getMatchScoreList(param);
        return ResponseResult.ok().setData(matchScores);
    }

    /**
     * 修改或保存成绩
     * @param matchScores
     * @return
     */
    @PostMapping
    public ResponseResult create(@RequestBody List<MatchScore> matchScores)  {
        ValidateUtils.notNull(matchScores, "参数异常");
        //原本的成绩保存
        SignRecord signRecord=signRecordService.selectByPrimaryKey(matchScores.get(0).getRecordId());
        ValidateUtils.notNull(signRecord, "无效的报名记录");
        for(MatchScore matchScore:matchScores){
            if(matchScore.getShowState()==2){
                //默认值赋值
                if(MatchScoreDefaultConfig.MATCH_NAME.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getMatchName().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getMatchName());
                    }
                }else if (MatchScoreDefaultConfig.SUBJECT_NAME.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getSubjectName().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getSubjectName());
                    }
                }else if (MatchScoreDefaultConfig.NAME.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getName().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getName());
                    }
                }else if (MatchScoreDefaultConfig.MATCH_NO.getCode().equals(matchScore.getScoreId())){
                    if(signRecord.getMatchNo().equals(matchScore.getScore())){
                        continue;
                    }else {
                        matchScore.setScore(signRecord.getMatchNo());
                    }
                }
            }
            if(matchScore.getId()!=null){
                matchScoreService.updateByPrimaryKeySelective(matchScore);
            }else {
                matchScoreService.insert(matchScore);
            }
        }
        return ResponseResult.ok();
    }
    /**
     * 导出赛事科目模板
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/scoreTemplate/exportExcel")
    @AllowAnonymous
    public ResponseResult scoreTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject param = getJSONObject(request);
        String fileName = "";
        Long subjectId=param.getLong("subjectId");
        ValidateUtils.notNull(subjectId, "请选择需要下载的科目模板");
        MatchSubject subject=matchSubjectService.selectByPrimaryKey(param.getLong("subjectId"));
        Map<String,Object> params = new HashMap<>();
        params.put("subjectId",subjectId);
        List<MatchScoreConfig> matchScoreConfigList=matchScoreConfigService.findBy(params);
        int size = matchScoreConfigList.size();
        fileName = subject.getSubjectName() + "成绩模板";
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //设置标题风格
        HSSFCellStyle style1 = hssfWorkbook.createCellStyle();
        style1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        style1.setWrapText(true);
        //设置字体格式
        HSSFFont font1 = hssfWorkbook.createFont();
        font1.setColor(IndexedColors.RED.getIndex());
        font1.setBold(true);
        style1.setFont(font1);

        HSSFSheet sheet = hssfWorkbook.createSheet(fileName);
        CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 99);
        sheet.addMergedRegion(region1);
        sheet.setDefaultColumnWidth(17);

        HSSFRow row01 = sheet.createRow(0);
        row01.setHeight((short) 1250);
        //在row01上创建单元格
        HSSFCell cell_row01 = row01.createCell(0);
        cell_row01.setCellStyle(style1);
        StringBuffer sb = new StringBuffer();
        sb.append("1.报名项中若存在图片上传项，这里不做展示和录入操作，请在表格导入后手工录入\n");
        sb.append("2.日期格式：2020-1-1\n");
        sb.append("3.省份格式：福建省\n");
        sb.append("4.城市格式：厦门市");
        cell_row01.setCellValue(sb.toString());

        //在row02上创建单元格
        HSSFRow row02 = sheet.createRow(1);
        sheet.setColumnWidth(0,8100);
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        HSSFDataFormat dataFormat = hssfWorkbook.createDataFormat();
        cellStyle.setDataFormat(dataFormat.getFormat("@"));
        int j = 1;
        for (int i = 0; i < j; i++) {
            HSSFCell cell = row02.createCell(i);
            if(i == 0){
                cell.setCellValue("科目ID");
                ExcelUtils.setHSSFValidation(sheet,new String[]{String.valueOf(subject.getId())},2,99,i,i);
            }
        }
        for (int i = j; i < size + j; i++) {
            MatchScoreConfig matchScoreConfig=matchScoreConfigList.get(i-j);
            if(MatchScoreDefaultConfig.MATCH_NAME.getCode().equals(matchScoreConfig.getId())){
                HSSFCell cell = row02.createCell(i);
                cell.setCellValue("身份证号");
            }else if(MatchScoreDefaultConfig.SUBJECT_NAME.getCode().equals(matchScoreConfig.getId())){
                HSSFCell cell = row02.createCell(i);
                cell.setCellValue("手机号");
            }else {
                HSSFCell cell = row02.createCell(i);
                cell.setCellValue(matchScoreConfig.getScoreParameter());
            }
        }

        response.setContentType("application/vnd.ms-excel");
        fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + fileName + ".xls");// 告诉浏览器已下载的形式打开文件
        OutputStream fileOut = null;
        try {
            fileOut = response.getOutputStream();
            hssfWorkbook.write(fileOut);
        } catch (Exception e) {
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.flush();
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                hssfWorkbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseResult.ok();
    }

    /**
     * 导入赛事科目模板
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/scoreTemplate/importExcel")
    @AllowAnonymous
    public ResponseResult importExcel(MultipartHttpServletRequest file, HttpServletRequest request) throws Exception {
        ValidateUtils.notNull(file, "文件不能为空");
        JSONObject param = getJSONObject(request);
        Long subjectId = param.getLong("subjectId");// 科目ID
        ValidateUtils.notNull(subjectId,"项目id不能为空");
        MatchSubject matchSubject = matchSubjectService.selectByPrimaryKey(subjectId);
        ValidateUtils.notNull(matchSubject, "项目不存在");
        // 科目报名字段
        Map<Tuple<String, String>, Integer> relation = new HashMap<>();

        relation.put(new Tuple<>("subjectId", "科目ID"), 2);
        relation.put(new Tuple<>("certificateNo", "身份证号"), 2);
        relation.put(new Tuple<>("phone", "手机号"), 2);
        Map<String,Object> params = new HashMap<>();
        params.put("subjectId",subjectId);
        List<MatchScoreConfig> matchScoreConfigList=matchScoreConfigService.findBy(params);
        matchScoreConfigList.forEach(new Consumer<MatchScoreConfig>() {
            @Override
            public void accept(MatchScoreConfig matchScoreConfig) {
                // 如果 状态为显示
//                Integer state = subjectSignField.getState();
//                if (state != 0) {
//                    if(subjectSignField.getType() == 4){//文件
//                        state = 1;
//                    }
                    relation.put(new Tuple<>(String.valueOf(matchScoreConfig.getId()), matchScoreConfig.getScoreParameter()), 1);
//                }
            }
        });

        Tuple<List<JSONObject>, List<String>> result = ExcelUtils.resolveExcelMatch(file.getFile("file"), -1, relation,true);
        if (result.value.size() > 0) {
            return ResponseResult.getResponse(0);
        }
        matchScoreService.importScore(result.key,matchScoreConfigList);

//        signRecordService.importMacthSignRecord(matchSubject, result,relation,param);

        return ResponseResult.ok();
    }
}
