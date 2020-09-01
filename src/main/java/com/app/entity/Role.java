package com.app.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    private String role;
}
