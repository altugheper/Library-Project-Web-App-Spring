package com.libraryspring.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_book")
public class Book {

    private Long id;

    private String name;

    private String isbn;

    private int pageCount;

    private Long authorId;

    private Long publisherId;

    private int publishDate;

    private Long categoryId;

    // private ImageData image;

    private boolean loanable;

    private String shelfCode;

    private boolean active;

    private boolean featured;

    private LocalDateTime createDate;

    private boolean builtIn;

}
