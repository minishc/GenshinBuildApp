package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Character {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String weaponType;
    String iconImage;
    int baseAttack;
    int baseDefense;
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
    
    public Character(String name, String weaponType, String iconImage, int baseAttack,
                     int baseDefense, int baseHP, String scaleStat, double maxValue) {
        this.name = name;
        this.weaponType = weaponType;
        this.iconImage = iconImage;
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
}
