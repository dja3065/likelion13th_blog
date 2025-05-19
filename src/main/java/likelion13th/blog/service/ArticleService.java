package likelion13th.blog.service;


import likelion13th.blog.domain.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final List<Article> articleDB = new ArrayList<>(); //데이터를 저장할 임시DB
    private  Long nextId = 1L; //고유번호 업데이트

    public Article addArticle(Article article){
        //Article 객체 생성

        if(article.getContent()==null
        || article.getTitle()==null
        || article.getAuthor()==null
        || article.getPassword()==null){
            throw new IllegalArgumentException("제목, 내용, 작성자, 비밀번호는 필수 입력 사항입니다.");
        }
        Article newArticle = new Article(
                article.getContent(),
                nextId++,
                article.getTitle(),
                article.getAuthor(),
                article.getPassword()
        );
        //DB에 객체 저장
        articleDB.add(newArticle);

        return newArticle;
    }

    public List<Article> findAll(){
        return articleDB;
    }
}
