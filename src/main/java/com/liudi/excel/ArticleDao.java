package com.liudi.excel;

import com.liudi.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author liudi
 * @version 2021/1/4 下午12:17
 */
@Service
public class ArticleDao {
    private List<Article> articles = new ArrayList<>();

    public void save(List<Article> raws) {
        articles = raws;
    }

    public List<Article> list() {
        return articles;
    }
}
