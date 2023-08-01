package com.example.social_network.model.user;

import lombok.*;

import javax.persistence.*;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

}