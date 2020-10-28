package ru.yandex.lab_sqli.service;

import ru.yandex.lab_sqli.dao.IArticleDAO;
import ru.yandex.lab_sqli.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    private IArticleDAO articleDAO;


    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllAtricles();
    }

    @Override
    public Article getArticleById(String id) {
        return articleDAO.getArticleById(id);
    }
}
