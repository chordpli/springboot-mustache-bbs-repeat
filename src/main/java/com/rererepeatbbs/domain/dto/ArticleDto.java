package com.rererepeatbbs.domain.dto;

import com.rererepeatbbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(this.id, this.title, this.content);
    }
}
