package com.libraryspring.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "t_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 80, message = "Your name '${validatedValue}' must be between {min} and {max} chars long")
    private String name;

    @Column(nullable = false)
    private Boolean builtIn=false;

    @Column(nullable = false)
    private Integer sequence ;

}
