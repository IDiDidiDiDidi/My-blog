package com.liudi.excel;

import com.alibaba.excel.EasyExcel;
import com.liudi.pojo.Article;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2021/1/4 下午12:02
 */
@Controller
public class EasyExcelController {
    private static final Logger log = LoggerFactory.getLogger(EasyExcelController.class);

    @Autowired
    private ArticleDao articleDao;

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("文章下载", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Article.class).sheet("文章").doWrite(articleDao.list());
    }

    @GetMapping("tempalte")
    public void tempalte(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("文章模板", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Article.class).sheet("模板").doWrite(new ArrayList());
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Article.class, new ArticleReadListener(articleDao)).sheet().doRead();
        return "success";
    }
}
