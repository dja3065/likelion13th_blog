package likelion13th.blog.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//import java.time.LocalDateTime;
//
//public class Article {
//
//    private Long id; //고유 번호
//    private String title; //제목
//    private String content; //게시글
//    private String author; //작성자
//    private String password; //비밀번호
//    private LocalDateTime createdAt; //생성일
//
//    public Article(String content, Long id, String title, String author,String password) {
//        this.content = content;
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.password = password;
//        this.createdAt = LocalDateTime.now();
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public Long getId() {return id; }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public String getPassword() {return password;}
//}
//
@Entity
@Getter
@Builder @AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int commentCount;


    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }

    public void increaseCommentCount() {
        commentCount++;
    }

    public void decreaseCommentCount() {
        if(commentCount>0) commentCount--;
    }
}

