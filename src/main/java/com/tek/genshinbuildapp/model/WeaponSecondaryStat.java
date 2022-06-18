package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class WeaponSecondaryStat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String statName;
    @NonNull
    double statValue;

    @ToString.Exclude
    @OneToMany(targetEntity = WeaponSecondaryStat.class)
    List<Weapon> weapons;
}
