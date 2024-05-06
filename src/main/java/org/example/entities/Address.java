package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "movie")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short addressId;
    private String address;
    private String address2;
    private String district;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
