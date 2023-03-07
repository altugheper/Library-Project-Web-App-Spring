package com.libraryspring.library.domain;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "This space cannot be null")
    @Size(min = 2, max = 80,message = "Your name '${validatedValue}' must be between {min} and {max} characters long")
    private String name;

    @NotNull(message = "This space cannot be null")
    @Column(length = 17)
    @NumberFormat(pattern = "###-##-#####-##-#")
    private String isbn;

    private Integer pageCount;

    @NotNull(message = "This space cannot be null")
    private Long authorId;

    @NotNull(message = "This space cannot be null")
    private Long publisherId;

    @NumberFormat(pattern = "####")
    private Integer publishDate;

    @NotNull(message = "This space cannot be null")
    private Long categoryId;

    @NotNull
    @Column(nullable = true)
    private boolean loanable;

    private String shelfCode;

    private boolean active;

    private boolean featured;

    private LocalDateTime createDate;

//    private File image;
//
//    private boolean builtIn;



}
