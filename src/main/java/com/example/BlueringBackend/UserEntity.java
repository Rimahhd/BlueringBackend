package com.example.BlueringBackend;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "work")
public class UserEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "fName", nullable = false, length = 255)
    private String FName;

    @Column(name = "phoneNb", nullable = false)
    private Integer phoneNb;

}