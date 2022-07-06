window.onload = buildInit;

//collecting dom elements for grabbing stats and updating images
var buildDom = {
    collectDom: function() {
        this.buildCharacter = document.getElementById("build-character");
        this.characterContainer = document.getElementById("selected-character");
        this.buildWeapon = document.getElementById("build-weapon");
        this.weaponContainer = document.getElementById("selected-weapon");
        this.statContainers = document.getElementsByClassName("stat-container");
        this.flowerSlot = document.getElementById("flower-slot");
        this.flowerContainer = document.getElementById("flower-container");
        this.plumeSlot = document.getElementById("plume-slot");
        this.plumeContainer = document.getElementById("plume-container");
        this.sandsSlot = document.getElementById("sands-slot");
        this.sandsContainer = document.getElementById("sands-container");
        this.gobletSlot = document.getElementById("goblet-slot");
        this.gobletContainer = document.getElementById("goblet-container");
        this.circletSlot = document.getElementById("circlet-slot");
        this.circletContainer = document.getElementById("circlet-container");
        this.submit = document.getElementById("form-submit");
    }
}

//variables for storing stat update logic
var sheetStats = {};
var character;
var weapon;
var flower;
var plume;
var sands;
var goblet;
var circlet;
var weaponEquipped = false;
var artifactEquipped = {
    flower: false,
    plume: false,
    sands: false,
    goblet: false,
    circlet: false
};
var artifactStats = {
    bonusHP: 0,
    bonusATK: 0,
    bonusDEF: 0,
    bonusHPPercent: 0,
    bonusATKPercent: 0,
    bonusDEFPercent: 0,
    bonusELEMENTALMASTERY: 0,
    bonusENERGYRECHARGE: 0,
    bonusCRITRATE: 0,
    bonusCRITDMG: 0,
    bonusPHYSICALDMGBONUS: 0,
    bonusELEMENTALDMGBONUS: 0,
    bonusHEALINGBONUS: 0
}

/*
    buildInit function adds event listeners to the relevant DOM elements
*/
function buildInit() {
    init();
    console.log("Build script loaded");
    buildDom.collectDom();

    //updates stat values/image when the character is changed checks for weapon compatibility
    buildDom.buildCharacter.addEventListener("click", () => {
        character = buildDom.buildCharacter.value;
        character = parse(character);
        statUpdate("character");
        buildDom.characterContainer.removeChild(buildDom.characterContainer.firstElementChild);
        var newImage = document.createElement("img");
        newImage.src = character.iconImage;
        newImage.alt = character.name;
        buildDom.characterContainer.insertBefore(newImage, buildDom.characterContainer.firstChild);
        // verifyCompatibility();
    });

    //updates stat variables/image when the weapon is changed
    buildDom.buildWeapon.addEventListener("click", () => {
        if(weapon != undefined) {
            sheetStats.baseAttack -= parseInt(weapon.baseAttack);
        }
        weapon = buildDom.buildWeapon.value;
        weapon = parse(weapon);
        if(character == undefined || character.weaponType == weapon.weaponType) {
            statUpdate("weapon");
            buildDom.weaponContainer.removeChild(buildDom.weaponContainer.firstElementChild);
            var newImage = document.createElement("img");
            newImage.src = weapon.weaponImage;
            newImage.alt = weapon.name;
            buildDom.weaponContainer.insertBefore(newImage, buildDom.weaponContainer.firstChild);
        }
        else {
            weapon = undefined;
            if(character != undefined) {
                sheetStats.baseAttack = parseInt(character.baseAttack);
            }
        }
    });

    //updates stats/image when the flower artifact is set or changed
    buildDom.flowerSlot.addEventListener("click", () => {
        if(artifactEquipped.flower) {
            unequip(flower);
        }
        flower = buildDom.flowerSlot.value;
        flower = parseArtifact(flower);
        equip(flower);
        if(flower != undefined) {
            if(flower.artifactSet.includes("’")) {
                createArtifactDom("flower", flower.artifactSet.substring(0, flower.artifactSet.indexOf("’")).toLowerCase(), flower);
            }
            else if(flower.artifactSet.includes(" ")){
                createArtifactDom("flower", flower.artifactSet.substring(0, flower.artifactSet.indexOf(" ")).toLowerCase(), flower);
            }
            else {
                createArtifactDom("flower", flower.artifactSet.toLowerCase(), flower);
            }
        }
        statUpdate("artifact");
    });

    //updates stats/image when the plume artifact is set or changed
    buildDom.plumeSlot.addEventListener("click", () => {
        if(artifactEquipped.plume) {
            unequip(plume);
        }
        plume = buildDom.plumeSlot.value;
        plume = parseArtifact(plume);
        equip(plume);
        if(plume != undefined) {
            if(plume.artifactSet.includes("’")) {
                createArtifactDom("plume", plume.artifactSet.substring(0, plume.artifactSet.indexOf("’")).toLowerCase(), plume);
            }
            else if(plume.artifactSet.includes(" ")) {
                createArtifactDom("plume", plume.artifactSet.substring(0, plume.artifactSet.indexOf(" ")).toLowerCase(), plume);
            }
            else {
                createArtifactDom("plume", plume.artifactSet.toLowerCase(), plume);
            }
        }
        statUpdate("artifact");
    });

    //updates stats/image when the sands artifact is changed
    buildDom.sandsSlot.addEventListener("click", () => {
        if(artifactEquipped.sands) {
            unequip(sands);
        }
        sands = buildDom.sandsSlot.value;
        sands = parseArtifact(sands);
        equip(sands);
        if(sands != undefined) {
            if(sands.artifactSet.includes("’")) {
                createArtifactDom("sands", sands.artifactSet.substring(0, sands.artifactSet.indexOf("’")).toLowerCase(), sands);
            }
            else if(sands.artifactSet.includes(" ")) {
                createArtifactDom("sands", sands.artifactSet.substring(0, sands.artifactSet.indexOf(" ")).toLowerCase(), sands);
            }
            else {
                createArtifactDom("sands", sands.artifactSet.toLowerCase(), sands);
            }
        }
        statUpdate("artifact");
    });

    //updates stats/images when the goblet artifact is changed
    buildDom.gobletSlot.addEventListener("click", () => {
        if(artifactEquipped.goblet) {
            unequip(goblet);
        }
        goblet = buildDom.gobletSlot.value;
        goblet = parseArtifact(goblet);
        equip(goblet);
        if(goblet != undefined) {
            if(goblet.artifactSet.includes("’")) {
                createArtifactDom("goblet", goblet.artifactSet.substring(0, goblet.artifactSet.indexOf("’")).toLowerCase(), goblet);
            }
            else if(goblet.artifactSet.includes(" ")) {
                createArtifactDom("goblet", goblet.artifactSet.substring(0, goblet.artifactSet.indexOf(" ")).toLowerCase(), goblet);
            }
            else {
                createArtifactDom("goblet", goblet.artifactSet.toLowerCase(), goblet);
            }
        }
        statUpdate("artifact");
    });

    //updates stats/image when the circlet artifact is set or changed
    buildDom.circletSlot.addEventListener("click", () => {
        if(artifactEquipped.circlet) {
            unequip(circlet);
        }
        circlet = buildDom.circletSlot.value;
        circlet = parseArtifact(circlet);
        equip(circlet);
        if(circlet != undefined) {
            if(circlet.artifactSet.includes("’")) {
                createArtifactDom("circlet", circlet.artifactSet.substring(0, circlet.artifactSet.indexOf("’")).toLowerCase(), circlet);
            }
            else if(circlet.artifactSet.includes(" ")) {
                createArtifactDom("circlet", circlet.artifactSet.substring(0, circlet.artifactSet.indexOf(" ")).toLowerCase(), circlet);
            }
            else {
                createArtifactDom("circlet", circlet.artifactSet.toLowerCase(), circlet);
            }
        }
        statUpdate("artifact");
    });

    buildDom.submit.addEventListener("click", () => {
        buildDom.buildCharacter[buildDom.buildCharacter.selectedIndex].value = character.id;
        buildDom.buildWeapon[buildDom.buildWeapon.selectedIndex].value = weapon.id;
        buildDom.flowerSlot[buildDom.flowerSlot.selectedIndex].value = flower.id;
        buildDom.plumeSlot[buildDom.plumeSlot.selectedIndex].value = plume.id;
        buildDom.sandsSlot[buildDom.sandsSlot.selectedIndex].value = sands.id;
        buildDom.gobletSlot[buildDom.gobletSlot.selectedIndex].value = goblet.id;
        buildDom.circletSlot[buildDom.circletSlot.selectedIndex].value = circlet.id;
    });


    window.onload = init;
}

/*
    Creates a way of displaying the artifact in the DOM when it is set,
    shows an image of the artifact and stats.
    There is an object used here that can be found in /resources/static/js/scripts.js
*/
function createArtifactDom(slot, set, artifact) {
    var image = document.createElement("img");
    var mainstat = document.createElement("p");
    var substat1 = document.createElement("p");
    var substat2 = document.createElement("p");
    var substat3 = document.createElement("p");
    var substat4 = document.createElement("p");
    image.src = artifactMetaData[set][slot].img;
    image.style.width = "50px";
    image.alt = set + slot;
    mainstat.innerHTML = artifact.mainstat.statName + "+" + artifact.mainstat.statValue;
    mainstat.style.fontSize = "10px";
    substat1.innerHTML = artifact.substat[0].statName + "+" + artifact.substat[0].statValue;
    substat1.style.fontSize = "10px";
    substat2.innerHTML = artifact.substat[1].statName + "+" + artifact.substat[1].statValue;
    substat2.style.fontSize = "10px";
    substat3.innerHTML = artifact.substat[2].statName + "+" + artifact.substat[2].statValue;
    substat3.style.fontSize = "10px";
    substat4.innerHTML = artifact.substat[3].statName + "+" + artifact.substat[3].statValue;
    substat4.style.fontSize = "10px";
    while(buildDom[slot+"Container"].firstElementChild.localName != "select") {
        buildDom[slot+"Container"].removeChild(buildDom[slot+"Container"].firstElementChild);
    }
    buildDom[slot+"Container"].insertBefore(image, buildDom[slot+"Container"].firstElementChild);
    buildDom[slot+"Container"].insertBefore(mainstat, buildDom[slot+"Container"].lastElementChild);
    buildDom[slot+"Container"].insertBefore(substat1, buildDom[slot+"Container"].lastElementChild);
    buildDom[slot+"Container"].insertBefore(substat2, buildDom[slot+"Container"].lastElementChild);
    buildDom[slot+"Container"].insertBefore(substat3, buildDom[slot+"Container"].lastElementChild);
    buildDom[slot+"Container"].insertBefore(substat4, buildDom[slot+"Container"].lastElementChild);
}

/*
    Parses a string obtained by thymeleaf binding into a js object
*/
function parse(item) {
    var firstKey = item.indexOf("(") + 1;
    var lastValue = item.indexOf(")");
    var keyValuePairs = item.substring(firstKey, lastValue).split(", ");
    var keysAndValues = [];
    for(var i = 0; i <  keyValuePairs.length; i++) {
        keysAndValues.push(keyValuePairs[i].split("="));
    }
    var result = {};
    for(var i = 0; i < keysAndValues.length; i++) {
        if(!(keysAndValues[i][0] == "secondaryStat")) {
            result[keysAndValues[i][0]] = keysAndValues[i][1];
        }
    }
    return result;
}

/*
    Similar to the above but specifically for artifacts
*/
function parseArtifact(artifact) {
    var firstKey = artifact.indexOf("(") + 1;
    var lastValue = artifact.lastIndexOf(")");
    var keyValuePairs = artifact.substring(firstKey, lastValue).split(", ");
    var result = {
        mainstat: {
            statName: "",
            statValue: 0.0
        },
        substat: {
            0: {
                statName: "",
                statValue: 0.0
            },
            1: {
                statName: "",
                statValue: 0.0
            },
            2: {
                statName: "",
                statValue: 0.0
            },
            3: {
                statName: "",
                statValue: 0.0
            }
        }
    };
    for(var i = 0; i < keyValuePairs.length;) {
        if(keyValuePairs[i].includes("main") || keyValuePairs[i].includes("substat")) {
            if(keyValuePairs[i].includes("main")) {
                result.mainstat.statName = keyValuePairs[i+1].split("=")[1];
                result.mainstat.statNameFixed = result.mainstat.statName.toUpperCase();
                result.mainstat.statNameFixed = result.mainstat.statNameFixed.replace("%", "Percent");
                result.mainstat.statNameFixed = result.mainstat.statNameFixed.replace(/ /g, "");
                result.mainstat.statValue = parseFloat(keyValuePairs[i+2].split("=")[1]);
                i += 3;
            }
            else {
                for(var index = 0; index < 4; index++) {
                    result.substat[index].statName = keyValuePairs[++i].split("=")[1];
                    result.substat[index].statNameFixed = result.substat[index].statName.toUpperCase();
                    result.substat[index].statNameFixed = result.substat[index].statNameFixed.replace("%", "Percent");
                    result.substat[index].statNameFixed = result.substat[index].statNameFixed.replace(/ /g, "");
                    result.substat[index].statValue = parseFloat(keyValuePairs[++i].split("=")[1]);
                    i++;
                }
                break;
            }
        }
        else {
            keyAndValue = keyValuePairs[i].split("=");
            result[keyAndValue[0]] = keyAndValue[1];
            i++;
        }
    }
    return result;
}

//verifies a character can equip a certain weapon
function verifyCompatibility() {
    if(character != undefined && weapon != undefined) {
        if(character.weaponType != weapon.weaponType) {
            alert("Character and weapon mismatch, make sure to equip the right weapon type.");
            buildDom.weaponContainer.removeChild(buildDom.weaponContainer.firstElementChild);
            var newImage = document.createElement("img");
            newImage.src = "images/addToBuild.png";
            newImage.alt = weapon.name;
            buildDom.weaponContainer.insertBefore(newImage, buildDom.weaponContainer.firstChild);
        }
    }
}

//changes the stats for an artifact
function unequip(artifact) {
    artifactStats["bonus"+artifact.mainstat.statNameFixed] -= artifact.mainstat.statValue;
    for(var i = 0; i < 4; i++) {
        artifactStats["bonus"+artifact.substat[i].statNameFixed] -= artifact.substat[i].statValue;
    }
}

//changes the stats for an artifact
function equip(artifact) {
    artifactStats["bonus"+artifact.mainstat.statNameFixed] += artifact.mainstat.statValue;
    for(var i = 0; i < 4; i++) {
        artifactStats["bonus"+artifact.substat[i].statNameFixed] += artifact.substat[i].statValue;
    }
    artifactEquipped[artifact.slot.substring(0, artifact.slot.indexOf(" ")).toLowerCase()] = true;
}

/*
    Updates all of the stats on the build page stat sheet based on what equipment
    has been selected
*/
function statUpdate(selector) {
    if(selector == "character") {
        for(var key in character) {
            if(sheetStats[key] == undefined) {
                if(String(key).includes("base")) {
                    if(String(key).toLowerCase().includes("percent")) {
                        sheetStats[key] = parseFloat(character[key]);
                    }
                    else {
                        sheetStats[key] = parseInt(character[key]);
                    }
                }
            }
            else {
                if(String(key) == "baseAttack") {
                    if(weapon != undefined) {
                        sheetStats[key] = parseInt(character.baseAttack) + parseInt(weapon.baseAttack);
                    }   
                }
                else {
                    sheetStats[key] = parseFloat(character[key])
                }
            }
        }
    }
    else if(selector == "weapon") {
        if(sheetStats.baseAttack == undefined) {
            sheetStats.baseAttack = 0;
        }
        sheetStats.baseAttack += parseInt(weapon.baseAttack);
        if(weaponEquipped) {
            artifactStats["bonus"+String(weapon.statName).replace(" ", "").toUpperCase()] -= parseFloat(weapon.statValue);
        }
        weaponEquipped = true;
        artifactStats["bonus"+String(weapon.statName).replace(" ", "").toUpperCase()] += parseFloat(weapon.statValue);
    }
    if(character != undefined) {
        for(var key in buildDom.statContainers) {
            if(buildDom.statContainers[key].localName == "span") {
                var statName = buildDom.statContainers[key].firstElementChild.textContent;
                var value = buildDom.statContainers[key].lastElementChild;
                switch(statName.toLowerCase()) {
                    case "hp": {
                        var base = sheetStats.baseHP;
                        var percent = (sheetStats.baseHPPercent + artifactStats.bonusHPPercent) / 100.0;
                        var flat = parseInt(artifactStats.bonusHP);
                        if(percent == 0) {
                            value.innerHTML = sheetStats.baseHP + flat + "(+" + String(flat) + ")";
                        }
                        else {
                            value.innerHTML = base + flat + Math.round(base * percent) + "(+" + String(Math.round(base * percent) + flat) + ")";
                        }
                    } break;
                    case "attack": {
                        var base = sheetStats.baseAttack;
                        var percent = (sheetStats.baseAttackPercent + artifactStats.bonusATKPercent) / 100.0;
                        var flat = parseInt(artifactStats.bonusATK);
                        if(percent == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = base + flat + Math.round(percent * base) + "(+" + String(Math.round(base * percent) + flat) + ")";
                        }
                    } break;

                    case "defense": {
                        var base = sheetStats.baseDefense;
                        var percent = (sheetStats.baseDefensePercent + artifactStats.bonusDEFPercent) / 100.0;
                        var flat = parseInt(artifactStats.bonusDEF);
                        if(percent == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = base + flat + Math.round(percent * base) + "(+" + String(Math.round(base * percent) + flat) + ")";
                        }
                    } break;

                    case "elemental mastery": {
                        var base = sheetStats.baseElemMastery;
                        var flat = parseInt(artifactStats.bonusELEMENTALMASTERY);
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "hp percent": {
                        var percent = Math.round((sheetStats.baseHPPercent + artifactStats.bonusHPPercent) * 10) / 10;
                        value.innerHTML = percent;
                    } break;

                    case "attack percent": {
                        var percent = Math.round((sheetStats.baseAttackPercent + artifactStats.bonusATKPercent) * 10) / 10;
                        value.innerHTML = percent;
                    } break;

                    case "defense percent": {
                        var percent = Math.round((sheetStats.baseDefensePercent + artifactStats.bonusDEFPercent) * 10) / 10;
                        value.innerHTML = percent;
                    } break;

                    case "energy recharge": {
                        var base = sheetStats.baseEnergyRecharge;
                        var flat = Math.round(artifactStats.bonusENERGYRECHARGE * 10) / 10;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = Math.round((base + flat) * 10) / 10 + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "crit": {
                        var base = sheetStats.baseCrit;
                        var flat = Math.round(artifactStats.bonusCRITRATE * 10) / 10;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = Math.round((base + flat) * 10) / 10 + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "crit damage": {
                        var base = sheetStats.baseCritDamage;
                        var flat = Math.round(artifactStats.bonusCRITDMG * 10) / 10;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = Math.round((base + flat) * 10) / 10 + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "physical damage bonus": {
                        var base = sheetStats.basePhysDamage;
                        var flat = artifactStats.bonusPHYSICALDMGBONUS;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = Math.round((base + flat) * 10) / 10 + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "elemental damage bonus": {
                        var base = sheetStats.baseElemDamage;
                        var flat = artifactStats.bonusELEMENTALDMGBONUS;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = Math.round((base + flat) * 10) / 10 + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "healing bonus": {
                        var base = sheetStats.baseHealingPercent;
                        var flat = artifactStats.bonusHEALINGBONUS;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = Math.round((base + flat) * 10) / 10 + "(+" + String(flat) + ")";
                        }
                    } break;
                }
            }
        }
    }
}