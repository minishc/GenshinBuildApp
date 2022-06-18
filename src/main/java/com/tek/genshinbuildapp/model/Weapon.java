package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Weapon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
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

    @OneToMany(mappedBy = "weapon", orphanRemoval = true)
    private Set<Build> builds = new LinkedHashSet<>();

}
