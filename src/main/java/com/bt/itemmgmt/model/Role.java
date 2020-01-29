package com.bt.itemmgmt.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String role;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;
}