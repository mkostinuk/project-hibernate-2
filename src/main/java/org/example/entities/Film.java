package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.Rating;
import org.example.RatingConverter;
import org.example.SpecialFeatures;
import org.example.YearConverter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "film", schema = "movie")

public class Film {
    @Setter
    @Getter
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short filmId;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    @Column(columnDefinition = "text")
    @Type(type = "text")
    private String description;
    @Setter
    @Getter
    @Column(name = "release_year", columnDefinition = "year")
    @Convert(converter = YearConverter.class)
    private Year releaseYear;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;
    @Setter
    @Getter
    @Column(name = "rental_duration")
    private Byte rentalDuration;
    @Setter
    @Getter
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    @Setter
    @Getter
    private Short length;
    @Setter
    @Getter
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @Setter
    @Getter
    @Column(columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverter.class)
    private Rating rating;
    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;
    @Setter
    @Getter
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    @Setter
    @Getter
    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors;
    @Setter
    @Getter
    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", columnDefinition = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;

    public void setSpecialFeatures(Set<SpecialFeatures> specialFeatures) {
        specialFeatures.stream().map(SpecialFeatures::getValue).collect(Collectors.joining(","));
    }

    public Set<SpecialFeatures> getSpecialFeatures() {
        if (Objects.isNull(specialFeatures)) {
            return null;
        } else {
            Set<SpecialFeatures> features = new HashSet<>();
            String[] featuresArray = specialFeatures.split(",");
            for (String f : featuresArray) {
                features.add(SpecialFeatures.getFeature(f));
            }
            features.remove(null);
            return features;
        }
    }

}
