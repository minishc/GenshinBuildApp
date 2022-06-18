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
@Table(name = "genshin_character")
public class Character {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String weaponType;
    String iconImage;
    String characterDemoUrl;
    @Column(nullable = false)
    int baseAttack;
    @Column(nullable = false)
    int baseDefense;
    @Column(nullable = false)
    int baseHP;
    double baseAttackPercent;
    double baseDefensePercent;
    double baseHPPercent;
    double baseElemMastery;
    double baseCrit;
    double baseCritDamage;
    double basePhysDamage;
    double baseElemDamage;
    double baseEnergyRecharge;
    double baseHealingPercent;

    public Character(String name, String weaponType, int baseAttack, int baseDefense,
                     int baseHP, String scaleStat, double maxValue) {
        this.name = name;
        this.weaponType = weaponType;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseHP = baseHP;
        this.baseCrit = 5.0;
        this.baseCritDamage = 50.0;
        switch(scaleStat) {
            case "baseAttackPercent": this.baseAttackPercent = maxValue; break;
            case "baseDefensePercent": this.baseDefensePercent = maxValue; break;
            case "baseHPPercent": this.baseHPPercent = maxValue; break;
            case "baseElemMastery": this.baseElemMastery = maxValue; break;
            case "baseCrit": this.baseCrit = maxValue; break;
            case "baseCritDamage": this.baseCritDamage = maxValue; break;
            case "basePhysDamage": this.basePhysDamage = maxValue; break;
            case "baseElemDamage": this.baseElemDamage = maxValue; break;
            case "baseEnergyRecharge": this.baseEnergyRecharge = maxValue; break;
            case "baseHealingPercent": this.baseHealingPercent = maxValue; break;

            default: throw new IllegalArgumentException("Provided scaleStat was invalid - check spelling");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (getId() != character.getId()) return false;
        if (!getName().equals(character.getName())) return false;
        return getWeaponType().equals(character.getWeaponType());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getWeaponType().hashCode();
        return result;
    }
}
