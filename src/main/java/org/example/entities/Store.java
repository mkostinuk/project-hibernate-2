package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "store", schema = "movie")
@Getter
@Setter
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte languageId;
    @JoinColumn(name = "manager_staff_id")
    @OneToOne
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

}
