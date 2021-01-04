package com.liudi.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.liudi.pojo.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2021/1/4 下午12:13
 */
public class ArticleReadListener extends AnalysisEventListener<Article> {
    private ArticleDao articleDao;

    public ArticleReadListener(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    private static final Logger logger = LoggerFactory.getLogger(ArticleReadListener.class);
    private List<Article> raws = new ArrayList<>();

    @Override
    public void invoke(Article data, AnalysisContext context) {
        logger.info("开始读取文章:{}", JSON.toJSONString(data));
        raws.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        logger.info("一共读取了{}篇文章，标题分别是:{}", raws.size(), raws.stream().map(Article::getTitle).collect(Collectors.toList()));
        articleDao.save(raws);
    }
}
