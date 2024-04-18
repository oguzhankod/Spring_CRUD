package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "kullanicilar")
@Data
public class User extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName",nullable = false,length = 50)
    private String firstName;
    @Column(name = "lastName",nullable = false,length = 50)
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName = lastName;
    }
}
