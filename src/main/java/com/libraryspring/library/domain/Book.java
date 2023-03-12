package com.libraryspring.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 80, message = "Your name '${validatedValue}' must be between {min} and {max} chars long")
    private String name;


    @Column(length = 17, nullable = false)
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d")
    private String isbn;

    private Integer pageCount;

    @Column(nullable = false)
    private Long authorId;

    @Column(nullable = false)
    private Long publisherId;

    @Column(length = 4)
    private Integer publishDate;

    @Column(nullable = false)
    private Long categoryId;

    // private ImageData image;

    @Column(nullable = false)
    private boolean loanable=true;

    @Column(length = 6, nullable = false)
    @Pattern(regexp = "[A-Z]{2}-\\\\d{3}")
    private String shelfCode;

    private boolean active;

    private boolean featured;

    @NotNull
    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();

    private boolean builtIn;

}
