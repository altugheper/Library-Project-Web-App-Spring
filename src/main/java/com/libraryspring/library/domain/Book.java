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
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 80, message = "Your name '${validatedValue}' must be between {min} and {max} chars long")
    private String name;


    @Column(length = 17, nullable = false)
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d", message = "ISBN number must be in the format 999-99-99999-99-9")
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
    @Pattern(regexp = "[a-zA-Z]{2}-\\\\d{3}", message = "Shelf Code number must be in the format AA-999")
    private String shelfCode;

    @Column(nullable = false)
    private boolean active=true;

    @Column(nullable = false)
    private boolean featured=false;

    @Column(nullable = false)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean builtIn=false;

}
