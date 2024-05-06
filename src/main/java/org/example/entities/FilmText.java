package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "film_text", schema = "movie")
@Getter
@Setter
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
}
