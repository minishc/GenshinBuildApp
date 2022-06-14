package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Weapon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String weaponType;
    int baseAttack;

    @ManyToOne
    WeaponSecondaryStat secondaryStat;
}
