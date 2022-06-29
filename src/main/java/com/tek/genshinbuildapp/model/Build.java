package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Build implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "build_artifacts",
            joinColumns = @JoinColumn(name = "build_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artifacts_id", referencedColumnName = "id"))
    private Set<Artifact> artifacts = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "weapon_id", nullable = false)
    private Weapon weapon;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String toString() {
        return character.getName() + " build " + id;
    }
}
