package com.tek.genshinbuildapp;

import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import com.tek.genshinbuildapp.service.CharacterService;
import com.tek.genshinbuildapp.service.WeaponSecondaryStatService;
import com.tek.genshinbuildapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    private final CharacterService characterService;
    private final WeaponSecondaryStatService secondaryStatService;
    private final WeaponService weaponService;

    @Autowired
    public AppCommandLineRunner(CharacterService characterService,
                                WeaponSecondaryStatService secondaryStatService,
                                WeaponService weaponService) {
        this.characterService = characterService;
        this.weaponService = weaponService;
        this.secondaryStatService = secondaryStatService;
    }

    @Override
    public void run(String... args) {
        populateCharacters();
        populateSecondaryStats();
        populateWeapons();
    }

    /**
     * This method will populate the database with the existing characters as of
     * the first event banner of patch 2.8
     */
    private void populateCharacters() {
        List<Character> characters = new ArrayList<>();
        Character albedo = new Character("Albedo", "Sword", 251, 876, 13226, "baseElemDamage", 28.8);
        albedo.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/00/Character_Albedo_Thumb.png");
        characters.add(albedo);

        Character aloy = new Character("Aloy", "Bow", 234, 676, 10899, "baseElemDamage", 28.8);
        aloy.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/6a/Character_Aloy_Thumb.png");
        characters.add(aloy);

        Character amber = new Character("Amber", "Bow", 223, 601, 9461, "baseAttackPercent", 24);
        amber.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/c6/Character_Amber_Thumb.png");
        characters.add(amber);

        Character itto = new Character("Arataki Itto", "Claymore", 227, 959, 12858, "baseCrit", 24.2);
        itto.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/7/79/Character_Arataki_Itto_Thumb.png");
        characters.add(itto);

        Character barbara = new Character("Barbara", "Catalyst", 159, 669, 9787, "baseHPPercent", 24);
        barbara.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/7/72/Character_Barbara_Thumb.png");
        characters.add(barbara);

        Character beidou = new Character("Beidou", "Claymore", 225, 648, 13050, "baseElemDamage", 24);
        beidou.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/61/Character_Beidou_Thumb.png");
        characters.add(beidou);

        Character bennet = new Character("Bennet", "Sword", 191, 771, 12397, "baseEnergyRecharge", 26.7);
        bennet.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/7/7b/Character_Bennett_Thumb.png");
        characters.add(bennet);

        Character chongyun = new Character("Chongyun", "Claymore", 223, 648, 10984, "baseAttackPercent", 24);
        chongyun.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/68/Character_Chongyun_Thumb.png");
        characters.add(chongyun);

        Character diluc = new Character("Diluc", "Claymore", 335, 784, 12981, "baseCrit", 24.2);
        diluc.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/02/Character_Diluc_Thumb.png");
        characters.add(diluc);

        Character diona = new Character("Diona", "Bow", 212, 601, 9570, "baseElemDamage", 24);
        diona.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/b/b9/Character_Diona_Thumb.png");
        characters.add(diona);

        Character eula = new Character("Eula", "Claymore", 342, 751, 13226, "baseCritDamage", 88.4);
        eula.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/d/d3/Character_Eula_Thumb.png");
        characters.add(eula);

        Character fischl = new Character("Fischl", "Bow", 244, 594, 9189, "baseAttackPercent", 24);
        fischl.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/1/14/Character_Fischl_Thumb.png");
        characters.add(fischl);

        Character ganyu = new Character("Ganyu", "Bow", 311, 586, 9108, "baseCritDamage", 88.4);
        ganyu.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/d/d3/Character_Eula_Thumb.png");
        characters.add(ganyu);

        Character gorou = new Character("Gorou", "Bow", 183, 648, 9570, "baseElemDamage", 24);
        gorou.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/56/Character_Gorou_Thumb.png");
        characters.add(gorou);

        Character hutao = new Character("Hu Tao", "Polearm", 106, 876, 15552, "baseCritDamage", 88.4);
        hutao.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a4/Character_Hu_Tao_Thumb.png");
        characters.add(hutao);

        Character jean = new Character("Jean", "Sword", 239, 769, 14695, "baseHealingPercent", 22.2);
        jean.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/89/Character_Jean_Thumb.png");
        characters.add(jean);

        Character kazuha = new Character("Kaedehara Kazuha", "Sword", 239, 807, 13348, "baseElemMastery", 115.2);
        kazuha.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/f/f0/Character_Kaedehara_Kazuha_Thumb.png");
        characters.add(kazuha);

        Character kaeya = new Character("Kaeya", "Sword", 223, 792, 11636, "baseEnergyRecharge", 26.7);
        kaeya.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/3/33/Character_Kaeya_Thumb.png");
        characters.add(kaeya);

        Character ayaka = new Character("Kamisato Ayaka", "Sword", 342, 784, 12858, "baseCritDamage", 88.4);
        ayaka.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/f/fd/Character_Kamisato_Ayaka_Thumb.png");
        characters.add(ayaka);

        Character ayato = new Character("Kamisato Ayato", "Sword", 299, 769, 13715, "baseCritDamage", 88.4);
        ayato.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a2/Character_Kamisato_Ayato_Thumb.png");
        characters.add(ayato);

        Character keqing = new Character("Keqing", "Sword", 323, 799, 13103, "baseCritDamage", 88.4);
        keqing.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/06/Character_Keqing_Thumb.png");
        characters.add(keqing);

        Character klee = new Character("Klee", "Catalyst", 311, 615, 10287, "baseElemDamage", 28.8);
        klee.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/c3/Character_Klee_Thumb.png");
        characters.add(klee);

        Character sara = new Character("Kujou Sara", "Bow", 195, 628, 9570, "baseAttackPercent", 24);
        sara.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/9/96/Character_Kujou_Sara_Thumb.png");
        characters.add(sara);

        Character lisa = new Character("Lisa", "Catalyst", 232, 573, 9570, "baseElemMastery", 96);
        lisa.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/51/Character_Lisa_Thumb.png");
        characters.add(lisa);

        Character mona = new Character("Mona", "Catalyst", 287, 653, 10409, "baseEnergyRecharge", 32);
        mona.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a0/Character_Mona_Thumb.png");
        characters.add(mona);

        Character ningguang = new Character("Ningguang", "Catalyst", 212, 573, 9787, "baseElemDamage", 24);
        ningguang.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/2/2b/Character_Ningguang_Thumb.png");
        characters.add(ningguang);

        Character noelle = new Character("Noelle", "Claymore", 191, 799, 12071, "baseDefensePercent", 30);
        noelle.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/ab/Character_Noelle_Thumb.png");
        characters.add(noelle);

        Character qiqi = new Character("Qiqi", "Sword", 287, 922, 12368, "baseHealingPercent", 22.2);
        qiqi.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/d/d5/Character_Qiqi_Thumb.png");
        characters.add(qiqi);

        Character raiden = new Character("Raiden Shogun", "Polearm", 337, 789, 12907, "baseEnergyRecharge", 32);
        raiden.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/52/Character_Raiden_Shogun_Thumb.png");
        characters.add(raiden);

        Character rosaria = new Character("Rosaria", "Polearm", 240, 710, 12289, "baseAttackPercent", 24);
        rosaria.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/f/f6/Character_Rosaria_Thumb.png");
        characters.add(rosaria);

        Character kokomi = new Character("Sangonomiya Kokomi", "Catalyst", 234, 657, 13471, "baseElemDamage", 28.8);
        kokomi.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/cc/Character_Sangonomiya_Kokomi_Thumb.png");
        characters.add(kokomi);

        Character sayu = new Character("Sayu", "Claymore", 244, 745, 11854, "baseElemMastery", 96);
        sayu.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/e/ec/Character_Sayu_Thumb.png");
        characters.add(sayu);

        Character shenhe = new Character("Shenhe", "Polearm", 304, 830, 12993, "baseAttackPercent", 28.8);
        shenhe.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/58/Character_Shenhe_Thumb.png");
        characters.add(shenhe);

        Character sucrose = new Character("Sucrose", "Catalyst", 170, 703, 9244, "baseElemDamage", 24);
        sucrose.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/61/Character_Sucrose_Thumb.png");
        characters.add(sucrose);

        Character tartaglia = new Character("Tartaglia", "Bow", 301, 815, 13103, "baseElemDamage", 28.8);
        tartaglia.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/53/Character_Tartaglia_Thumb.png");
        characters.add(tartaglia);

        Character thoma = new Character("Thoma", "Polearm", 202, 751, 10331, "baseAttackPercent", 24);
        thoma.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/8a/Character_Thoma_Thumb.png");
        characters.add(thoma);

        Character traveler = new Character("Traveler", "Sword", 212, 683, 10875, "baseAttackPercent", 24);
        traveler.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/8a/Character_Thoma_Thumb.png");
        characters.add(traveler);

        Character venti = new Character("Venti", "Bow", 263, 669, 10531, "baseEnergyRecharge", 32);
        venti.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/8d/Character_Venti_Thumb.png");
        characters.add(venti);

        Character xiangling = new Character("Xiangling", "Polearm", 225, 799, 12071, "baseElemMastery", 96);
        xiangling.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a0/Character_Xiangling_Thumb.png");
        characters.add(xiangling);

        Character xiao = new Character("Xiao", "Polearm", 349, 799, 12736, "baseCrit", 24.2);
        xiao.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/b/b9/Character_Xiao_Thumb.png");
        characters.add(xiao);

        Character xinqiu = new Character("Xinqiu", "Sword", 202, 758, 10222, "baseAttackPercent", 24);
        xinqiu.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/4/4a/Character_Xingqiu_Thumb.png");
        characters.add(xinqiu);

        Character xinyan = new Character("Xinyan", "Claymore", 249, 799, 11201, "baseAttackPercent", 24);
        xinyan.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/9/9d/Character_Xinyan_Thumb.png");
        characters.add(xinyan);

        Character yae = new Character("Yae Miko", "Catalyst", 340, 569, 10372, "baseCrit", 24.2);
        yae.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/57/Character_Yae_Miko_Thumb.png");
        characters.add(yae);

        Character yanfei = new Character("Yanfei", "Catalyst", 240, 587, 9352, "baseElemDamage", 24);
        yanfei.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/1/1f/Character_Yanfei_Thumb.png");
        characters.add(yanfei);

        Character yelan = new Character("Yelan", "Bow", 244, 548, 14450, "baseCrit", 24.2);
        yelan.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a8/Character_Yelan_Thumb.png");
        characters.add(yelan);

        Character yoimiya = new Character("Yoimiya", "Bow", 323, 615, 10164, "baseCrit", 24.2);
        yoimiya.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/05/Character_Yoimiya_Thumb.png");
        characters.add(yoimiya);

        Character yunjin = new Character("Yun Jin", "Polearm", 191, 734, 10657, "baseEnergyRecharge", 26.7);
        yunjin.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/cb/Character_Yun_Jin_Thumb.png");
        characters.add(yunjin);

        Character zhongli = new Character("Zhongli", "Polearm", 251, 738, 14695, "baseElemDamage", 28.8);
        zhongli.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/c2/Character_Zhongli_Thumb.png");
        characters.add(zhongli);

        characterService.saveAll(characters);
    }

    /**
     * This method will populate the database with the existing weapons up to the
     * first event banner of patch 2.8
     * Secondary stats have their own table in the database to reduce redundancy
     */
    private void populateWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Blackcliff Longsword", "Sword", 565,
                                secondaryStatService.findByData("CRIT DMG", 36.8)));
        weapons.add(new Weapon("Favonius Sword", "Sword", 454,
                secondaryStatService.findByData("Energy Recharge", 61.3)));
        weapons.add(new Weapon("Iron Sting", "Sword", 510,
                secondaryStatService.findByData("Elemental Mastery", 165)));
        weapons.add(new Weapon("Lion's Roar", "Sword", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Prototype Rancour", "Sword", 565,
                secondaryStatService.findByData("Physical DMG Bonus", 34.5)));
        weapons.add(new Weapon("Royal Longsword", "Sword", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Sacrificial Sword", "Sword", 454,
                secondaryStatService.findByData("Energy Recharge", 61.3)));
        weapons.add(new Weapon("The Alley Flash", "Sword", 620,
                secondaryStatService.findByData("Elemental Mastery", 55)));
        weapons.add(new Weapon("The Black Sword", "Sword", 510,
                secondaryStatService.findByData("CRIT Rate", 27.6)));
        weapons.add(new Weapon("The Flute", "Sword", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Sword of Descension", "Sword", 440,
                secondaryStatService.findByData("ATK", 35.2)));
        weapons.add(new Weapon("Festering Desire", "Sword", 510,
                secondaryStatService.findByData("Energy Recharge", 45.9)));
        weapons.add(new Weapon("Amenoma Kageuchi", "Sword", 608,
                secondaryStatService.findByData("ATK", 55.1)));
        weapons.add(new Weapon("Cinnabar Spindle", "Sword", 608,
                secondaryStatService.findByData("DEF", 69)));
        weapons.add(new Weapon("Aquila Favonia", "Sword", 674,
                secondaryStatService.findByData("Physical DMG Bonus", 41.3)));
        weapons.add(new Weapon("Skyward Blade", "Sword", 608,
                secondaryStatService.findByData("Energy Recharge", 55.1)));
        weapons.add(new Weapon("Summit Shaper", "Sword", 608,
                secondaryStatService.findByData("ATK", 49.6)));
        weapons.add(new Weapon("Primordial Jade Cutter", "Sword", 542,
                secondaryStatService.findByData("CRIT Rate", 44.1)));
        weapons.add(new Weapon("Freedom-Sworn", "Sword", 608,
                secondaryStatService.findByData("Elemental Mastery", 198)));
        weapons.add(new Weapon("Mistsplitter Reforged", "Sword", 674,
                secondaryStatService.findByData("CRIT DMG", 44.1)));
        weapons.add(new Weapon("Haran Geppaku Futsu", "Sword", 608,
                secondaryStatService.findByData("CRIT Rate", 33.1)));
        weapons.add(new Weapon("Whiteblind", "Claymore", 510,
                secondaryStatService.findByData("DEF", 51.7)));
        weapons.add(new Weapon("The Bell", "Claymore", 510,
                secondaryStatService.findByData("HP", 41.3)));
        weapons.add(new Weapon("Snow-Tombed Starsilver", "Claymore", 565,
                secondaryStatService.findByData("Physical DMG Bonus", 34.5)));
        weapons.add(new Weapon("Serpent Spine", "Claymore", 510,
                secondaryStatService.findByData("CRIT Rate", 27.6)));
        weapons.add(new Weapon("Sacrificial Greatsword", "Claymore", 565,
                secondaryStatService.findByData("Energy Recharge", 30.6)));
        weapons.add(new Weapon("Blackcliff Slasher", "Claymore", 510,
                secondaryStatService.findByData("CRIT DMG", 55.1)));
        weapons.add(new Weapon("Akuoumaru", "Claymore", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Rainslasher", "Claymore", 510,
                secondaryStatService.findByData("Elemental Mastery", 165)));
        weapons.add(new Weapon("Prototype Archaic", "Claymore", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Luxurious Sea-Lord", "Claymore", 454,
                secondaryStatService.findByData("ATK", 55.1)));
        weapons.add(new Weapon("Lithic Blade", "Claymore", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Katsuragikiri Nagamasa", "Claymore", 510,
                secondaryStatService.findByData("Energy Recharge", 45.9)));
        weapons.add(new Weapon("Favonius Greatsword", "Claymore", 454,
                secondaryStatService.findByData("Energy Recharge", 61.3)));
        weapons.add(new Weapon("Royal Greatsword", "Claymore", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Wolf's Gravestone", "Claymore", 608,
                secondaryStatService.findByData("ATK", 49.6)));
        weapons.add(new Weapon("Redhorn Stonethresher", "Claymore", 542,
                secondaryStatService.findByData("CRIT DMG", 88.2)));
        weapons.add(new Weapon("The Unforged", "Claymore", 608,
                secondaryStatService.findByData("ATK", 49.6)));
        weapons.add(new Weapon("Song of Broken Pines", "Claymore", 741,
                secondaryStatService.findByData("Physical DMG Bonus", 20.7)));
        weapons.add(new Weapon("Skyward Pride", "Claymore", 674,
                secondaryStatService.findByData("Energy Recharge", 36.8)));
        weapons.add(new Weapon("Dragonspine Spear", "Polearm", 454,
                secondaryStatService.findByData("Physical DMG Bonus", 69)));
        weapons.add(new Weapon("Dragon's Bane", "Polearm", 454,
                secondaryStatService.findByData("Elemental Mastery", 221)));
        weapons.add(new Weapon("Deathmatch", "Polearm", 454,
                secondaryStatService.findByData("CRIT Rate", 36.8)));
        weapons.add(new Weapon("Prototype Starglitter", "Polearm", 510,
                secondaryStatService.findByData("Energy Recharge", 45.9)));
        weapons.add(new Weapon("\"The Catch\"", "Polearm", 510,
                secondaryStatService.findByData("Energy Recharge", 45.9)));
        weapons.add(new Weapon("Blackcliff Pole", "Polearm", 510,
                secondaryStatService.findByData("CRIT DMG", 55.1)));
        weapons.add(new Weapon("Lithic Spear", "Polearm", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Kitain Cross Spear", "Polearm", 565,
                secondaryStatService.findByData("Elemental Mastery", 110)));
        weapons.add(new Weapon("Favonius Lance", "Polearm", 565,
                secondaryStatService.findByData("Energy Recharge", 30.6)));
        weapons.add(new Weapon("Crescent Pike", "Polearm", 565,
                secondaryStatService.findByData("Physical DMG Bonus", 34.5)));
        weapons.add(new Weapon("Royal Spear", "Polearm", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Wavebreaker's Fin", "Polearm", 620,
                secondaryStatService.findByData("ATK", 13.8)));
        weapons.add(new Weapon("Engulfing Lightning", "Polearm", 608,
                secondaryStatService.findByData("Energy Recharge", 55.1)));
        weapons.add(new Weapon("Staff of Homa", "Polearm", 608,
                secondaryStatService.findByData("CRIT DMG", 66.2)));
        weapons.add(new Weapon("Vortex Vanquisher", "Polearm", 608,
                secondaryStatService.findByData("ATK", 49.6)));
        weapons.add(new Weapon("Skyward Spine", "Polearm", 674,
                secondaryStatService.findByData("Energy Recharge", 36.8)));
        weapons.add(new Weapon("Primordial Jade Winged-Spear", "Polearm", 674,
                secondaryStatService.findByData("CRIT Rate", 22.1)));
        weapons.add(new Weapon("Calamity Queller", "Polearm", 741,
                secondaryStatService.findByData("ATK", 16.5)));
        weapons.add(new Weapon("Alley Hunter", "Bow", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("The Viridescent Hunt", "Bow", 510,
                secondaryStatService.findByData("CRIT Rate", 27.6)));
        weapons.add(new Weapon("The Stringless", "Bow", 510,
                secondaryStatService.findByData("Elemental Mastery", 165)));
        weapons.add(new Weapon("Sacrificial Bow", "Bow", 565,
                secondaryStatService.findByData("Energy Recharge", 30.6)));
        weapons.add(new Weapon("Rust", "Bow", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Royal Bow", "Bow", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Prototype Crescent", "Bow", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Predator", "Bow", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Mouun's Moon", "Bow", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Mitternachts Waltz", "Bow", 510,
                secondaryStatService.findByData("Physical DMG Bonus", 51.7)));
        weapons.add(new Weapon("Hamayumi", "Bow", 454,
                secondaryStatService.findByData("ATK", 55.1)));
        weapons.add(new Weapon("Favonius Warbow", "Bow", 454,
                secondaryStatService.findByData("Energy Recharge", 61.3)));
        weapons.add(new Weapon("Compound bow", "Bow", 454,
                secondaryStatService.findByData("Physical DMG Bonus", 69)));
        weapons.add(new Weapon("Blackcliff Warbow", "Bow", 565,
                secondaryStatService.findByData("CRIT DMG", 36.8)));
        weapons.add(new Weapon("Windblume Ode", "Bow", 510,
                secondaryStatService.findByData("Elemental Mastery", 165)));
        weapons.add(new Weapon("Polar Star", "Bow", 608,
                secondaryStatService.findByData("CRIT Rate", 33.1)));
        weapons.add(new Weapon("Thundering Pulse", "Bow", 608,
                secondaryStatService.findByData("CRIT DMG", 66.2)));
        weapons.add(new Weapon("Elegy for the End", "Bow", 608,
                secondaryStatService.findByData("Energy Recharge", 55.1)));
        weapons.add(new Weapon("Skyward Harp", "Bow", 674,
                secondaryStatService.findByData("CRIT Rate", 22.1)));
        weapons.add(new Weapon("Amos' Bow", "Bow", 608,
                secondaryStatService.findByData("ATK", 49.6)));
        weapons.add(new Weapon("Blackcliff Agate", "Catalyst", 510,
                secondaryStatService.findByData("CRIT DMG", 55.1)));
        weapons.add(new Weapon("The Widsith", "Catalyst", 510,
                secondaryStatService.findByData("CRIT DMG", 55.1)));
        weapons.add(new Weapon("Solar Pearl", "Catalyst", 510,
                secondaryStatService.findByData("CRIT Rate", 27.6)));
        weapons.add(new Weapon("Sacrificial Fragments", "Catalyst", 454,
                secondaryStatService.findByData("Elemental Mastery", 221)));
        weapons.add(new Weapon("Royal Grimoire", "Catalyst", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Prototype Amber", "Catalyst", 510,
                secondaryStatService.findByData("HP", 41.3)));
        weapons.add(new Weapon("Oathsworn Eye", "Catalyst", 565,
                secondaryStatService.findByData("ATK", 27.6)));
        weapons.add(new Weapon("Wine and Song", "Catalyst", 565,
                secondaryStatService.findByData("Elemental Mastery", 110)));
        weapons.add(new Weapon("Hakushin Ring", "Catalyst", 565,
                secondaryStatService.findByData("Energy Recharge", 30.6)));
        weapons.add(new Weapon("Frostbearer", "Catalyst", 510,
                secondaryStatService.findByData("ATK", 41.3)));
        weapons.add(new Weapon("Favonius Codex", "Catalyst", 510,
                secondaryStatService.findByData("Energy Recharge", 45.9)));
        weapons.add(new Weapon("Eye of Perception", "Catalyst", 454,
                secondaryStatService.findByData("ATK", 55.1)));
        weapons.add(new Weapon("Dodoco Tales", "Catalyst", 454,
                secondaryStatService.findByData("ATK", 55.1)));
        weapons.add(new Weapon("Memory of Dust", "Catalyst", 608,
                secondaryStatService.findByData("ATK", 49.6)));
        weapons.add(new Weapon("Everlasting Moonglow", "Catalyst", 608,
                secondaryStatService.findByData("HP", 49.6)));
        weapons.add(new Weapon("Skyward Atlas", "Catalyst", 674,
                secondaryStatService.findByData("ATK", 33.1)));
        weapons.add(new Weapon("Kagura's Verity", "Catalyst", 608,
                secondaryStatService.findByData("CRIT DMG", 66.2)));
        weapons.add(new Weapon("Lost Prayer to the Sacred Winds", "Catalyst", 608,
                secondaryStatService.findByData("CRIT Rate", 33.1)));
    }

    /**
     * This method will populate the database with the existing possible secondary
     * stat name/value combinations that exist as of the first event banner
     * of patch 2.8
     */
    private void populateSecondaryStats() {
        List<WeaponSecondaryStat> stats = new ArrayList<>();
        stats.add(new WeaponSecondaryStat("ATK", 13.8));
        stats.add(new WeaponSecondaryStat("ATK", 16.5));
        stats.add(new WeaponSecondaryStat("ATK", 27.6));
        stats.add(new WeaponSecondaryStat("ATK", 33.1));
        stats.add(new WeaponSecondaryStat("ATK", 35.2));
        stats.add(new WeaponSecondaryStat("ATK", 41.3));
        stats.add(new WeaponSecondaryStat("ATK", 49.6));
        stats.add(new WeaponSecondaryStat("ATK", 55.1));
        stats.add(new WeaponSecondaryStat("CRIT DMG", 36.8));
        stats.add(new WeaponSecondaryStat("CRIT DMG", 44.1));
        stats.add(new WeaponSecondaryStat("CRIT DMG", 55.1));
        stats.add(new WeaponSecondaryStat("CRIT DMG", 66.2));
        stats.add(new WeaponSecondaryStat("CRIT DMG", 88.2));
        stats.add(new WeaponSecondaryStat("CRIT Rate", 22.1));
        stats.add(new WeaponSecondaryStat("CRIT Rate", 27.6));
        stats.add(new WeaponSecondaryStat("CRIT Rate", 33.1));
        stats.add(new WeaponSecondaryStat("CRIT Rate", 36.8));
        stats.add(new WeaponSecondaryStat("CRIT Rate", 44.1));
        stats.add(new WeaponSecondaryStat("DEF", 51.7));
        stats.add(new WeaponSecondaryStat("DEF", 69));
        stats.add(new WeaponSecondaryStat("Elemental Mastery", 55));
        stats.add(new WeaponSecondaryStat("Elemental Mastery", 110));
        stats.add(new WeaponSecondaryStat("Elemental Mastery", 165));
        stats.add(new WeaponSecondaryStat("Elemental Mastery", 198));
        stats.add(new WeaponSecondaryStat("Elemental Mastery", 221));
        stats.add(new WeaponSecondaryStat("Energy Recharge", 30.6));
        stats.add(new WeaponSecondaryStat("Energy Recharge", 36.8));
        stats.add(new WeaponSecondaryStat("Energy Recharge", 45.9));
        stats.add(new WeaponSecondaryStat("Energy Recharge", 55.1));
        stats.add(new WeaponSecondaryStat("Energy Recharge", 61.3));
        stats.add(new WeaponSecondaryStat("HP", 41.3));
        stats.add(new WeaponSecondaryStat("HP", 49.6));
        stats.add(new WeaponSecondaryStat("Physical DMG Bonus", 20.7));
        stats.add(new WeaponSecondaryStat("Physical DMG Bonus", 34.5));
        stats.add(new WeaponSecondaryStat("Physical DMG Bonus", 41.3));
        stats.add(new WeaponSecondaryStat("Physical DMG Bonus", 51.7));
        stats.add(new WeaponSecondaryStat("Physical DMG Bonus", 69));
        secondaryStatService.saveAllStats(stats);
    }
}
