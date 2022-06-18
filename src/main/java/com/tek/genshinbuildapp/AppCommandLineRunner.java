package com.tek.genshinbuildapp;

import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import com.tek.genshinbuildapp.service.CharacterService;
import com.tek.genshinbuildapp.service.WeaponSecondaryStatService;
import com.tek.genshinbuildapp.service.WeaponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AppCommandLineRunner implements CommandLineRunner {

    private final CharacterService characterService;
    private final WeaponSecondaryStatService secondaryStatService;
    private final WeaponService weaponService;


    private static final String SWORD = "Sword";
    private static final String BOW = "Bow";
    private static final String CLAYMORE = "Claymore";
    private static final String POLEARM = "Polearm";
    private static final String CATALYST = "Catalyst";
    private static final String BASE_ELEM_DAMAGE = "baseElemDamage";
    private static final String BASE_ATTACK_PERCENT = "baseAttackPercent";
    private static final String BASE_CRIT = "baseCrit";
    private static final String BASE_HP_PERCENT = "baseHPPercent";
    private static final String BASE_ENERGY_RECHARGE = "baseEnergyRecharge";
    private static final String BASE_CRIT_DAMAGE = "baseCritDamage";
    private static final String BASE_HEALING_PERCENT = "baseHealingPercent";
    private static final String BASE_ELEM_MASTERY = "baseElemMastery";
    private static final String BASE_DEFENSE_PERCENT = "baseDefensePercent";
    private static final String ENERGY_RECHARGE = "Energy Recharge";
    private static final String CRIT_DMG = "CRIT DMG";
    private static final String ELEMENTAL_MASTERY = "Elemental Mastery";
    private static final String PHYSICAL_DMG_BONUS = "Physical DMG Bonus";
    private static final String CRIT_RATE = "CRIT Rate";
    private static final String ATK = "ATK";
    private static final String DEF = "DEF";
    private static final String HP = "HP";

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
        Character albedo = new Character("Albedo", SWORD, 251, 876, 13226, BASE_ELEM_DAMAGE, 28.8);
        albedo.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/00/Character_Albedo_Thumb.png");
        characters.add(albedo);

        Character aloy = new Character("Aloy", BOW, 234, 676, 10899, BASE_ELEM_DAMAGE, 28.8);
        aloy.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/6a/Character_Aloy_Thumb.png");
        characters.add(aloy);

        Character amber = new Character("Amber", BOW, 223, 601, 9461, BASE_ATTACK_PERCENT, 24);
        amber.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/c6/Character_Amber_Thumb.png");
        characters.add(amber);

        Character itto = new Character("Arataki Itto", CLAYMORE, 227, 959, 12858, BASE_CRIT, 24.2);
        itto.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/7/79/Character_Arataki_Itto_Thumb.png");
        characters.add(itto);

        Character barbara = new Character("Barbara", CATALYST, 159, 669, 9787, BASE_HP_PERCENT, 24);
        barbara.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/7/72/Character_Barbara_Thumb.png");
        characters.add(barbara);

        Character beidou = new Character("Beidou", CLAYMORE, 225, 648, 13050, BASE_ELEM_DAMAGE, 24);
        beidou.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/61/Character_Beidou_Thumb.png");
        characters.add(beidou);

        Character bennet = new Character("Bennet", SWORD, 191, 771, 12397, BASE_ENERGY_RECHARGE, 26.7);
        bennet.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/7/7b/Character_Bennett_Thumb.png");
        characters.add(bennet);

        Character chongyun = new Character("Chongyun", CLAYMORE, 223, 648, 10984, BASE_ATTACK_PERCENT, 24);
        chongyun.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/68/Character_Chongyun_Thumb.png");
        characters.add(chongyun);

        Character diluc = new Character("Diluc", CLAYMORE, 335, 784, 12981, BASE_CRIT, 24.2);
        diluc.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/02/Character_Diluc_Thumb.png");
        characters.add(diluc);

        Character diona = new Character("Diona", BOW, 212, 601, 9570, BASE_ELEM_DAMAGE, 24);
        diona.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/b/b9/Character_Diona_Thumb.png");
        characters.add(diona);

        Character eula = new Character("Eula", CLAYMORE, 342, 751, 13226, BASE_CRIT_DAMAGE, 88.4);
        eula.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/d/d3/Character_Eula_Thumb.png");
        characters.add(eula);

        Character fischl = new Character("Fischl", BOW, 244, 594, 9189, BASE_ATTACK_PERCENT, 24);
        fischl.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/1/14/Character_Fischl_Thumb.png");
        characters.add(fischl);

        Character ganyu = new Character("Ganyu", BOW, 311, 586, 9108, BASE_CRIT_DAMAGE, 88.4);
        ganyu.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/d/d3/Character_Eula_Thumb.png");
        characters.add(ganyu);

        Character gorou = new Character("Gorou", BOW, 183, 648, 9570, BASE_ELEM_DAMAGE, 24);
        gorou.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/56/Character_Gorou_Thumb.png");
        characters.add(gorou);

        Character hutao = new Character("Hu Tao", POLEARM, 106, 876, 15552, BASE_CRIT_DAMAGE, 88.4);
        hutao.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a4/Character_Hu_Tao_Thumb.png");
        characters.add(hutao);

        Character jean = new Character("Jean", SWORD, 239, 769, 14695, BASE_HEALING_PERCENT, 22.2);
        jean.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/89/Character_Jean_Thumb.png");
        characters.add(jean);

        Character kazuha = new Character("Kaedehara Kazuha", SWORD, 239, 807, 13348, BASE_ELEM_MASTERY, 115.2);
        kazuha.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/f/f0/Character_Kaedehara_Kazuha_Thumb.png");
        characters.add(kazuha);

        Character kaeya = new Character("Kaeya", SWORD, 223, 792, 11636, BASE_ENERGY_RECHARGE, 26.7);
        kaeya.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/3/33/Character_Kaeya_Thumb.png");
        characters.add(kaeya);

        Character ayaka = new Character("Kamisato Ayaka", SWORD, 342, 784, 12858, BASE_CRIT_DAMAGE, 88.4);
        ayaka.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/f/fd/Character_Kamisato_Ayaka_Thumb.png");
        characters.add(ayaka);

        Character ayato = new Character("Kamisato Ayato", SWORD, 299, 769, 13715, BASE_CRIT_DAMAGE, 88.4);
        ayato.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a2/Character_Kamisato_Ayato_Thumb.png");
        characters.add(ayato);

        Character keqing = new Character("Keqing", SWORD, 323, 799, 13103, BASE_CRIT_DAMAGE, 88.4);
        keqing.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/06/Character_Keqing_Thumb.png");
        characters.add(keqing);

        Character klee = new Character("Klee", CATALYST, 311, 615, 10287, BASE_ELEM_DAMAGE, 28.8);
        klee.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/c3/Character_Klee_Thumb.png");
        characters.add(klee);

        Character sara = new Character("Kujou Sara", BOW, 195, 628, 9570, BASE_ATTACK_PERCENT, 24);
        sara.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/9/96/Character_Kujou_Sara_Thumb.png");
        characters.add(sara);

        Character lisa = new Character("Lisa", CATALYST, 232, 573, 9570, BASE_ELEM_MASTERY, 96);
        lisa.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/51/Character_Lisa_Thumb.png");
        characters.add(lisa);

        Character mona = new Character("Mona", CATALYST, 287, 653, 10409, BASE_ENERGY_RECHARGE, 32);
        mona.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a0/Character_Mona_Thumb.png");
        characters.add(mona);

        Character ningguang = new Character("Ningguang", CATALYST, 212, 573, 9787, BASE_ELEM_DAMAGE, 24);
        ningguang.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/2/2b/Character_Ningguang_Thumb.png");
        characters.add(ningguang);

        Character noelle = new Character("Noelle", CLAYMORE, 191, 799, 12071, BASE_DEFENSE_PERCENT, 30);
        noelle.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/ab/Character_Noelle_Thumb.png");
        characters.add(noelle);

        Character qiqi = new Character("Qiqi", SWORD, 287, 922, 12368, BASE_HEALING_PERCENT, 22.2);
        qiqi.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/d/d5/Character_Qiqi_Thumb.png");
        characters.add(qiqi);

        Character raiden = new Character("Raiden Shogun", POLEARM, 337, 789, 12907, BASE_ENERGY_RECHARGE, 32);
        raiden.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/52/Character_Raiden_Shogun_Thumb.png");
        characters.add(raiden);

        Character rosaria = new Character("Rosaria", POLEARM, 240, 710, 12289, BASE_ATTACK_PERCENT, 24);
        rosaria.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/f/f6/Character_Rosaria_Thumb.png");
        characters.add(rosaria);

        Character kokomi = new Character("Sangonomiya Kokomi", CATALYST, 234, 657, 13471, BASE_ELEM_DAMAGE, 28.8);
        kokomi.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/cc/Character_Sangonomiya_Kokomi_Thumb.png");
        characters.add(kokomi);

        Character sayu = new Character("Sayu", CLAYMORE, 244, 745, 11854, BASE_ELEM_MASTERY, 96);
        sayu.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/e/ec/Character_Sayu_Thumb.png");
        characters.add(sayu);

        Character shenhe = new Character("Shenhe", POLEARM, 304, 830, 12993, BASE_ATTACK_PERCENT, 28.8);
        shenhe.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/58/Character_Shenhe_Thumb.png");
        characters.add(shenhe);

        Character sucrose = new Character("Sucrose", CATALYST, 170, 703, 9244, BASE_ELEM_DAMAGE, 24);
        sucrose.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/6/61/Character_Sucrose_Thumb.png");
        characters.add(sucrose);

        Character tartaglia = new Character("Tartaglia", BOW, 301, 815, 13103, BASE_ELEM_DAMAGE, 28.8);
        tartaglia.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/53/Character_Tartaglia_Thumb.png");
        characters.add(tartaglia);

        Character thoma = new Character("Thoma", POLEARM, 202, 751, 10331, BASE_ATTACK_PERCENT, 24);
        thoma.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/8a/Character_Thoma_Thumb.png");
        characters.add(thoma);

        Character traveler = new Character("Traveler", SWORD, 212, 683, 10875, BASE_ATTACK_PERCENT, 24);
        traveler.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/8a/Character_Thoma_Thumb.png");
        characters.add(traveler);

        Character venti = new Character("Venti", BOW, 263, 669, 10531, BASE_ENERGY_RECHARGE, 32);
        venti.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/8/8d/Character_Venti_Thumb.png");
        characters.add(venti);

        Character xiangling = new Character("Xiangling", POLEARM, 225, 799, 12071, BASE_ELEM_MASTERY, 96);
        xiangling.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a0/Character_Xiangling_Thumb.png");
        characters.add(xiangling);

        Character xiao = new Character("Xiao", POLEARM, 349, 799, 12736, BASE_CRIT, 24.2);
        xiao.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/b/b9/Character_Xiao_Thumb.png");
        characters.add(xiao);

        Character xinqiu = new Character("Xinqiu", SWORD, 202, 758, 10222, BASE_ATTACK_PERCENT, 24);
        xinqiu.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/4/4a/Character_Xingqiu_Thumb.png");
        characters.add(xinqiu);

        Character xinyan = new Character("Xinyan", CLAYMORE, 249, 799, 11201, BASE_ATTACK_PERCENT, 24);
        xinyan.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/9/9d/Character_Xinyan_Thumb.png");
        characters.add(xinyan);

        Character yae = new Character("Yae Miko", CATALYST, 340, 569, 10372, BASE_CRIT, 24.2);
        yae.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/5/57/Character_Yae_Miko_Thumb.png");
        characters.add(yae);

        Character yanfei = new Character("Yanfei", CATALYST, 240, 587, 9352, BASE_ELEM_DAMAGE, 24);
        yanfei.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/1/1f/Character_Yanfei_Thumb.png");
        characters.add(yanfei);

        Character yelan = new Character("Yelan", BOW, 244, 548, 14450, BASE_CRIT, 24.2);
        yelan.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/a/a8/Character_Yelan_Thumb.png");
        characters.add(yelan);

        Character yoimiya = new Character("Yoimiya", BOW, 323, 615, 10164, BASE_CRIT, 24.2);
        yoimiya.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/0/05/Character_Yoimiya_Thumb.png");
        characters.add(yoimiya);

        Character yunjin = new Character("Yun Jin", POLEARM, 191, 734, 10657, BASE_ENERGY_RECHARGE, 26.7);
        yunjin.setIconImage("https://static.wikia.nocookie.net/gensin-impact/images/c/cb/Character_Yun_Jin_Thumb.png");
        characters.add(yunjin);

        Character zhongli = new Character("Zhongli", POLEARM, 251, 738, 14695, BASE_ELEM_DAMAGE, 28.8);
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
        weapons.add(new Weapon("Blackcliff Longsword", SWORD, 565,
                secondaryStatService.findByData(CRIT_DMG, 36.8)));
        weapons.add(new Weapon("Favonius Sword", SWORD, 454,
                secondaryStatService.findByData(ENERGY_RECHARGE, 61.3)));
        weapons.add(new Weapon("Iron Sting", SWORD, 510,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 165)));
        weapons.add(new Weapon("Lion's Roar", SWORD, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Prototype Rancour", SWORD, 565,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 34.5)));
        weapons.add(new Weapon("Royal Longsword", SWORD, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Sacrificial Sword", SWORD, 454,
                secondaryStatService.findByData(ENERGY_RECHARGE, 61.3)));
        weapons.add(new Weapon("The Alley Flash", SWORD, 620,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 55)));
        weapons.add(new Weapon("The Black Sword", SWORD, 510,
                secondaryStatService.findByData(CRIT_RATE, 27.6)));
        weapons.add(new Weapon("The Flute", SWORD, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Sword of Descension", SWORD, 440,
                secondaryStatService.findByData(ATK, 35.2)));
        weapons.add(new Weapon("Festering Desire", SWORD, 510,
                secondaryStatService.findByData(ENERGY_RECHARGE, 45.9)));
        weapons.add(new Weapon("Amenoma Kageuchi", SWORD, 608,
                secondaryStatService.findByData(ATK, 55.1)));
        weapons.add(new Weapon("Cinnabar Spindle", SWORD, 608,
                secondaryStatService.findByData(DEF, 69)));
        weapons.add(new Weapon("Aquila Favonia", SWORD, 674,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 41.3)));
        weapons.add(new Weapon("Skyward Blade", SWORD, 608,
                secondaryStatService.findByData(ENERGY_RECHARGE, 55.1)));
        weapons.add(new Weapon("Summit Shaper", SWORD, 608,
                secondaryStatService.findByData(ATK, 49.6)));
        weapons.add(new Weapon("Primordial Jade Cutter", SWORD, 542,
                secondaryStatService.findByData(CRIT_RATE, 44.1)));
        weapons.add(new Weapon("Freedom-Sworn", SWORD, 608,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 198)));
        weapons.add(new Weapon("Mistsplitter Reforged", SWORD, 674,
                secondaryStatService.findByData(CRIT_DMG, 44.1)));
        weapons.add(new Weapon("Haran Geppaku Futsu", SWORD, 608,
                secondaryStatService.findByData(CRIT_RATE, 33.1)));
        weapons.add(new Weapon("Whiteblind", CLAYMORE, 510,
                secondaryStatService.findByData(DEF, 51.7)));
        weapons.add(new Weapon("The Bell", CLAYMORE, 510,
                secondaryStatService.findByData(HP, 41.3)));
        weapons.add(new Weapon("Snow-Tombed Starsilver", CLAYMORE, 565,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 34.5)));
        weapons.add(new Weapon("Serpent Spine", CLAYMORE, 510,
                secondaryStatService.findByData(CRIT_RATE, 27.6)));
        weapons.add(new Weapon("Sacrificial Greatsword", CLAYMORE, 565,
                secondaryStatService.findByData(ENERGY_RECHARGE, 30.6)));
        weapons.add(new Weapon("Blackcliff Slasher", CLAYMORE, 510,
                secondaryStatService.findByData(CRIT_DMG, 55.1)));
        weapons.add(new Weapon("Akuoumaru", CLAYMORE, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Rainslasher", CLAYMORE, 510,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 165)));
        weapons.add(new Weapon("Prototype Archaic", CLAYMORE, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Luxurious Sea-Lord", CLAYMORE, 454,
                secondaryStatService.findByData(ATK, 55.1)));
        weapons.add(new Weapon("Lithic Blade", CLAYMORE, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Katsuragikiri Nagamasa", CLAYMORE, 510,
                secondaryStatService.findByData(ENERGY_RECHARGE, 45.9)));
        weapons.add(new Weapon("Favonius Greatsword", CLAYMORE, 454,
                secondaryStatService.findByData(ENERGY_RECHARGE, 61.3)));
        weapons.add(new Weapon("Royal Greatsword", CLAYMORE, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Wolf's Gravestone", CLAYMORE, 608,
                secondaryStatService.findByData(ATK, 49.6)));
        weapons.add(new Weapon("Redhorn Stonethresher", CLAYMORE, 542,
                secondaryStatService.findByData(CRIT_DMG, 88.2)));
        weapons.add(new Weapon("The Unforged", CLAYMORE, 608,
                secondaryStatService.findByData(ATK, 49.6)));
        weapons.add(new Weapon("Song of Broken Pines", CLAYMORE, 741,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 20.7)));
        weapons.add(new Weapon("Skyward Pride", CLAYMORE, 674,
                secondaryStatService.findByData(ENERGY_RECHARGE, 36.8)));
        weapons.add(new Weapon("Dragonspine Spear", POLEARM, 454,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 69)));
        weapons.add(new Weapon("Dragon's Bane", POLEARM, 454,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 221)));
        weapons.add(new Weapon("Deathmatch", POLEARM, 454,
                secondaryStatService.findByData(CRIT_RATE, 36.8)));
        weapons.add(new Weapon("Prototype Starglitter", POLEARM, 510,
                secondaryStatService.findByData(ENERGY_RECHARGE, 45.9)));
        weapons.add(new Weapon("\"The Catch\"", POLEARM, 510,
                secondaryStatService.findByData(ENERGY_RECHARGE, 45.9)));
        weapons.add(new Weapon("Blackcliff Pole", POLEARM, 510,
                secondaryStatService.findByData(CRIT_DMG, 55.1)));
        weapons.add(new Weapon("Lithic Spear", POLEARM, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Kitain Cross Spear", POLEARM, 565,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 110)));
        weapons.add(new Weapon("Favonius Lance", POLEARM, 565,
                secondaryStatService.findByData(ENERGY_RECHARGE, 30.6)));
        weapons.add(new Weapon("Crescent Pike", POLEARM, 565,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 34.5)));
        weapons.add(new Weapon("Royal Spear", POLEARM, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Wavebreaker's Fin", POLEARM, 620,
                secondaryStatService.findByData(ATK, 13.8)));
        weapons.add(new Weapon("Engulfing Lightning", POLEARM, 608,
                secondaryStatService.findByData(ENERGY_RECHARGE, 55.1)));
        weapons.add(new Weapon("Staff of Homa", POLEARM, 608,
                secondaryStatService.findByData(CRIT_DMG, 66.2)));
        weapons.add(new Weapon("Vortex Vanquisher", POLEARM, 608,
                secondaryStatService.findByData(ATK, 49.6)));
        weapons.add(new Weapon("Skyward Spine", POLEARM, 674,
                secondaryStatService.findByData(ENERGY_RECHARGE, 36.8)));
        weapons.add(new Weapon("Primordial Jade Winged-Spear", POLEARM, 674,
                secondaryStatService.findByData(CRIT_RATE, 22.1)));
        weapons.add(new Weapon("Calamity Queller", POLEARM, 741,
                secondaryStatService.findByData(ATK, 16.5)));
        weapons.add(new Weapon("Alley Hunter", BOW, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("The Viridescent Hunt", BOW, 510,
                secondaryStatService.findByData(CRIT_RATE, 27.6)));
        weapons.add(new Weapon("The Stringless", BOW, 510,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 165)));
        weapons.add(new Weapon("Sacrificial Bow", BOW, 565,
                secondaryStatService.findByData(ENERGY_RECHARGE, 30.6)));
        weapons.add(new Weapon("Rust", BOW, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Royal Bow", BOW, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Prototype Crescent", BOW, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Predator", BOW, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Mouun's Moon", BOW, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Mitternachts Waltz", BOW, 510,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 51.7)));
        weapons.add(new Weapon("Hamayumi", BOW, 454,
                secondaryStatService.findByData(ATK, 55.1)));
        weapons.add(new Weapon("Favonius Warbow", BOW, 454,
                secondaryStatService.findByData(ENERGY_RECHARGE, 61.3)));
        weapons.add(new Weapon("Compound bow", BOW, 454,
                secondaryStatService.findByData(PHYSICAL_DMG_BONUS, 69)));
        weapons.add(new Weapon("Blackcliff Warbow", BOW, 565,
                secondaryStatService.findByData(CRIT_DMG, 36.8)));
        weapons.add(new Weapon("Windblume Ode", BOW, 510,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 165)));
        weapons.add(new Weapon("Polar Star", BOW, 608,
                secondaryStatService.findByData(CRIT_RATE, 33.1)));
        weapons.add(new Weapon("Thundering Pulse", BOW, 608,
                secondaryStatService.findByData(CRIT_DMG, 66.2)));
        weapons.add(new Weapon("Elegy for the End", BOW, 608,
                secondaryStatService.findByData(ENERGY_RECHARGE, 55.1)));
        weapons.add(new Weapon("Skyward Harp", BOW, 674,
                secondaryStatService.findByData(CRIT_RATE, 22.1)));
        weapons.add(new Weapon("Amos' Bow", BOW, 608,
                secondaryStatService.findByData(ATK, 49.6)));
        weapons.add(new Weapon("Blackcliff Agate", CATALYST, 510,
                secondaryStatService.findByData(CRIT_DMG, 55.1)));
        weapons.add(new Weapon("The Widsith", CATALYST, 510,
                secondaryStatService.findByData(CRIT_DMG, 55.1)));
        weapons.add(new Weapon("Solar Pearl", CATALYST, 510,
                secondaryStatService.findByData(CRIT_RATE, 27.6)));
        weapons.add(new Weapon("Sacrificial Fragments", CATALYST, 454,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 221)));
        weapons.add(new Weapon("Royal Grimoire", CATALYST, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Prototype Amber", CATALYST, 510,
                secondaryStatService.findByData(HP, 41.3)));
        weapons.add(new Weapon("Oathsworn Eye", CATALYST, 565,
                secondaryStatService.findByData(ATK, 27.6)));
        weapons.add(new Weapon("Wine and Song", CATALYST, 565,
                secondaryStatService.findByData(ELEMENTAL_MASTERY, 110)));
        weapons.add(new Weapon("Hakushin Ring", CATALYST, 565,
                secondaryStatService.findByData(ENERGY_RECHARGE, 30.6)));
        weapons.add(new Weapon("Frostbearer", CATALYST, 510,
                secondaryStatService.findByData(ATK, 41.3)));
        weapons.add(new Weapon("Favonius Codex", CATALYST, 510,
                secondaryStatService.findByData(ENERGY_RECHARGE, 45.9)));
        weapons.add(new Weapon("Eye of Perception", CATALYST, 454,
                secondaryStatService.findByData(ATK, 55.1)));
        weapons.add(new Weapon("Dodoco Tales", CATALYST, 454,
                secondaryStatService.findByData(ATK, 55.1)));
        weapons.add(new Weapon("Memory of Dust", CATALYST, 608,
                secondaryStatService.findByData(ATK, 49.6)));
        weapons.add(new Weapon("Everlasting Moonglow", CATALYST, 608,
                secondaryStatService.findByData(HP, 49.6)));
        weapons.add(new Weapon("Skyward Atlas", CATALYST, 674,
                secondaryStatService.findByData(ATK, 33.1)));
        weapons.add(new Weapon("Kagura's Verity", CATALYST, 608,
                secondaryStatService.findByData(CRIT_DMG, 66.2)));
        weapons.add(new Weapon("Lost Prayer to the Sacred Winds", CATALYST, 608,
                secondaryStatService.findByData(CRIT_RATE, 33.1)));

        weaponService.saveAll(weapons);
    }

    /**
     * This method will populate the database with the existing possible secondary
     * stat name/value combinations that exist as of the first event banner
     * of patch 2.8
     */
    private void populateSecondaryStats() {
        List<WeaponSecondaryStat> stats = new ArrayList<>();
        stats.add(new WeaponSecondaryStat(ATK, 13.8));
        stats.add(new WeaponSecondaryStat(ATK, 16.5));
        stats.add(new WeaponSecondaryStat(ATK, 27.6));
        stats.add(new WeaponSecondaryStat(ATK, 33.1));
        stats.add(new WeaponSecondaryStat(ATK, 35.2));
        stats.add(new WeaponSecondaryStat(ATK, 41.3));
        stats.add(new WeaponSecondaryStat(ATK, 49.6));
        stats.add(new WeaponSecondaryStat(ATK, 55.1));
        stats.add(new WeaponSecondaryStat(CRIT_DMG, 36.8));
        stats.add(new WeaponSecondaryStat(CRIT_DMG, 44.1));
        stats.add(new WeaponSecondaryStat(CRIT_DMG, 55.1));
        stats.add(new WeaponSecondaryStat(CRIT_DMG, 66.2));
        stats.add(new WeaponSecondaryStat(CRIT_DMG, 88.2));
        stats.add(new WeaponSecondaryStat(CRIT_RATE, 22.1));
        stats.add(new WeaponSecondaryStat(CRIT_RATE, 27.6));
        stats.add(new WeaponSecondaryStat(CRIT_RATE, 33.1));
        stats.add(new WeaponSecondaryStat(CRIT_RATE, 36.8));
        stats.add(new WeaponSecondaryStat(CRIT_RATE, 44.1));
        stats.add(new WeaponSecondaryStat(DEF, 51.7));
        stats.add(new WeaponSecondaryStat(DEF, 69));
        stats.add(new WeaponSecondaryStat(ELEMENTAL_MASTERY, 55));
        stats.add(new WeaponSecondaryStat(ELEMENTAL_MASTERY, 110));
        stats.add(new WeaponSecondaryStat(ELEMENTAL_MASTERY, 165));
        stats.add(new WeaponSecondaryStat(ELEMENTAL_MASTERY, 198));
        stats.add(new WeaponSecondaryStat(ELEMENTAL_MASTERY, 221));
        stats.add(new WeaponSecondaryStat(ENERGY_RECHARGE, 30.6));
        stats.add(new WeaponSecondaryStat(ENERGY_RECHARGE, 36.8));
        stats.add(new WeaponSecondaryStat(ENERGY_RECHARGE, 45.9));
        stats.add(new WeaponSecondaryStat(ENERGY_RECHARGE, 55.1));
        stats.add(new WeaponSecondaryStat(ENERGY_RECHARGE, 61.3));
        stats.add(new WeaponSecondaryStat(HP, 41.3));
        stats.add(new WeaponSecondaryStat(HP, 49.6));
        stats.add(new WeaponSecondaryStat(PHYSICAL_DMG_BONUS, 20.7));
        stats.add(new WeaponSecondaryStat(PHYSICAL_DMG_BONUS, 34.5));
        stats.add(new WeaponSecondaryStat(PHYSICAL_DMG_BONUS, 41.3));
        stats.add(new WeaponSecondaryStat(PHYSICAL_DMG_BONUS, 51.7));
        stats.add(new WeaponSecondaryStat(PHYSICAL_DMG_BONUS, 69));
        secondaryStatService.saveAllStats(stats);
    }
}
