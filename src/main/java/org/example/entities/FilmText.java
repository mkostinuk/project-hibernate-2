package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;//todo
    private String title;
    @Column(columnDefinition = "text")
    private String description;
}
