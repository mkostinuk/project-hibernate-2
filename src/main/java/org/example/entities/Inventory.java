package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory", schema = "movie")
@Getter
@Setter
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;


}
