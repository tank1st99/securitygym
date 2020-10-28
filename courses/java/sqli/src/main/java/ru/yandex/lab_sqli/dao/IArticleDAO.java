package ru.yandex.lab_sqli.dao;

import ru.yandex.lab_sqli.entity.Article;

import java.util.List;

public interface IArticleDAO {
    List<Article> getAllAtricles();
    Article getArticleById(String id);
}
