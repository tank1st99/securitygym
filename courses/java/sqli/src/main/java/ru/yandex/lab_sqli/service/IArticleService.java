package ru.yandex.lab_sqli.service;

import ru.yandex.lab_sqli.entity.Article;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();
    Article getArticleById(String id);
}
