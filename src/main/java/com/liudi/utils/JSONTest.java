package com.liudi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liudi.pojo.Ccdr;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2021/1/4 下午4:37
 */
public class JSONTest {

    public static void main(String[] args) {
        String path = JSONTest.class.getClassLoader().getResource("1443071.json").getPath();
        String s = readJsonFile(path);
        JSONObject jobj = JSON.parseObject(s);
        JSONArray tableStore = jobj.getJSONArray("RECORDS");//构建JSONArray数组
        Ccdr ccdr = new Ccdr();

        for (int i = 0 ; i < tableStore.size();i++) {
            JSONObject key = (JSONObject) tableStore.get(i);
            ccdr.setId((int) key.get("id"));
            ccdr.setSchool_id((String) key.get("school_id"));
            ccdr.setDept_id((String) key.get("dept_id"));
            ccdr.setCc_id((String) key.get("cc_id"));
            ccdr.setCreater_id((String) key.get("creater_id"));
            ccdr.setUser_type((String) key.get("user_type"));
            ccdr.setSTATUS((String) key.get("STATUS"));
            ccdr.setStat_type((String) key.get("stat_type"));
            ccdr.setActive_flag((String) key.get("active_flag"));
            ccdr.setTotal_score((int) key.get("total_score"));
            ccdr.setRes_total((int) key.get("res_total"));
            ccdr.setRes_view_total((int) key.get("res_view_total"));
            ccdr.setRes_video_total((int) key.get("res_video_total"));
            ccdr.setRes_video_total_duration((int) key.get("res_video_total_duration"));
            ccdr.setRes_image_total((int) key.get("res_image_total"));
            ccdr.setRes_url_total((int) key.get("res_url_total"));
            ccdr.setRes_html_total((int) key.get("res_html_total"));
            ccdr.setRes_doc_total((int) key.get("res_doc_total"));
            ccdr.setRes_other_total((int) key.get("res_other_total"));
            ccdr.setAct_quiz_total((int) key.get("act_quiz_total"));
            ccdr.setAct_storm_total((int) key.get("act_storm_total"));
            ccdr.setAct_qa_total((int) key.get("act_qa_total"));
            ccdr.setAct_vote_total((int) key.get("act_vote_total"));
            ccdr.setAct_chk_total((int) key.get("act_chk_total"));
            ccdr.setChk_rate((BigDecimal) key.get("chk_rate"));
            ccdr.setAct_cr_pfm_total((int) key.get("act_cr_pfm_total"));
            ccdr.setAct_hw_total((int) key.get("act_hw_total"));
            ccdr.setAct_quiz_join_total((int) key.get("act_quiz_join_total"));
            ccdr.setAct_vote_join_total((int) key.get("act_vote_join_total"));
            ccdr.setAct_qa_join_total((int) key.get("act_qa_join_total"));
            ccdr.setAct_qa_msg_total((int) key.get("act_qa_msg_total"));
            ccdr.setAct_storm_join_total((int) key.get("act_storm_join_total"));
            ccdr.setAct_cr_pfm_join_total((int) key.get("act_cr_pfm_join_total"));
            ccdr.setAct_hw_join_total((int) key.get("act_hw_join_total"));
            ccdr.setMbr_count_total((int) key.get("mbr_count_total"));
            ccdr.setTeacher_score_total((int) key.get("teacher_score_total"));
            ccdr.setStudent_score_avg((BigDecimal) key.get("student_score_avg"));
            ccdr.setActive_degree((int) key.get("active_degree"));
            ccdr.setReport_date((String) key.get("report_date"));
            ccdr.setRes_audio_total((int) key.get("res_audio_total"));
            ccdr.setRes_audio_total_duration((int) key.get("res_audio_total_duration"));
            ccdr.setQuiz_topic_total((int) key.get("quiz_topic_total"));
            ccdr.setQuiz_course_total((int) key.get("quiz_course_total"));
            ccdr.setDaily_chk_rate((BigDecimal) key.get("daily_chk_rate"));
            ccdr.setDaily_chk_count((int) key.get("daily_chk_count"));
            ccdr.setDaily_chk_rate_50((BigDecimal) key.get("daily_chk_rate_50"));
            ccdr.setDaily_chk_count_50((int) key.get("daily_chk_count_50"));
            ccdr.setDaily_chk_rate_60((BigDecimal) key.get("daily_chk_rate_60"));
            ccdr.setDaily_chk_count_60((int) key.get("daily_chk_count_60"));
            ccdr.setAccess_total((int) key.get("access_total"));
            ccdr.setReport_time((String) key.get("report_time"));


        }
    }

    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
