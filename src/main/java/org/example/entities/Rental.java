package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental", schema = "movie")
@Getter
@Setter
@ToString
public class Rental {
    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentalId;
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
