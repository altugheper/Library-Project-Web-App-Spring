package com.libraryspring.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Size(min = 2, max = 50, message = "Your name '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide your name")
    @Column(length = 50, nullable = false)
    private String name;

    @Size(min = 5, max = 50, message = "Your subject '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide subject")
    @Column(length = 50, nullable = false)
    private String subject;

    @Size(min = 20, max = 50, message = "Your name '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide body")
    @Column(length = 50, nullable = false)
    private String body;

    @Email(message = "Please provide e-mail")
    @Column(length = 50, nullable = false)
    private String email;
}
