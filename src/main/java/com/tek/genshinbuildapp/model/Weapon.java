package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Weapon implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String name;
    @NonNull
    String weaponType;
    @NonNull
    int baseAttack;
    @NonNull
    String weaponImage;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, targetEntity = WeaponSecondaryStat.class)
    @JoinColumn
    WeaponSecondaryStat secondaryStat;

    @ToString.Exclude
    @OneToMany(mappedBy = "weapon", orphanRemoval = true)
    private Set<Build> builds = new LinkedHashSet<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "weapons")
    private Set<User> users = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(id, weapon.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
