package com.vlc2.academy.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "editor_name")
    private String name;

    @Column(name = "average_time_delivering")
    private BigDecimal averageTimeDelivering;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "editor")
    private List<Book> books;

    public Editor(String name, String email) {
        this.name = name;
        this.email = email;
        books = new ArrayList<>();
    }

}