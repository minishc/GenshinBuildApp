package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = WeaponSecondaryStat.class)
    @JoinColumn
    WeaponSecondaryStat secondaryStat;
}
