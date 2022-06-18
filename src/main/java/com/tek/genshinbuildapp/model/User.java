package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(unique = true, length = 20)
    String username;
    @Column(length = 32)
    String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Build> builds = new LinkedHashSet<>();

}
