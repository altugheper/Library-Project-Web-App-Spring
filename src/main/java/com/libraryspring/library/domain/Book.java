package com.libraryspring.library.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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

    private Integer pageCount;

    private Long authorId;

    private Long publisherId;

    private Integer publishDate;

    private Long categoryId;

    // private ImageData image;

    private boolean loanable;

    private String shelfCode;

    private boolean active;

    private boolean featured;

    @NotNull
    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();

    private boolean builtIn;

}
