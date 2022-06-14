package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Build {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    Character character;
    @ManyToOne
    Weapon weapon;
    @ManyToMany
    Artifact artifact;
    @ManyToOne
    User user;
    @Override
    public String toString() {
        return character.getName() + " build " + id;
    }
}
