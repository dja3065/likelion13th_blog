package likelion13th.blog.dto.response;

import lombok.*;
import likelion13th.blog.domain.Article;
import java.time.LocalDateTime;

@AllArgsConstructor @Builder
@Getter
public class ArticleResponse {
    private final Long id;
    private final String title;
    private final String content; // <--- 이 필드 추가
    private final String author;
    private final LocalDateTime createdAt;

    public static ArticleResponse of(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .author(article.getAuthor())
                .createdAt(article.getCreatedAt())
                .build();
    }
}
