package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer", schema = "movie")
@Getter
@Setter
@ToString
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short customerId;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean active;
    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
