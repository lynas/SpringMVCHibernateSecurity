package com.lynas.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by sazzad on 9/7/15
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public @Data class AppUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;// ● user role id I P
    @Column(nullable = false, unique = true)
    private String roleName;// ● role id [static class]
}
