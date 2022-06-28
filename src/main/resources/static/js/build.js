window.onload = buildInit;

var buildDom = {
    collectDom: function() {
        this.buildCharacter = document.getElementById("build-character");
        this.characterContainer = document.getElementById("selected-character");
        this.buildWeapon = document.getElementById("build-weapon");
        this.weaponContainer = document.getElementById("selected-weapon");
        this.statContainers = document.getElementsByClassName("stat-container");
        this.flowerImage = document.getElementById("flower-slot");
    }
}

var sheetStats = {};
var character;
var weapon;

function buildInit() {
    init();
    console.log("Build script loaded");
    buildDom.collectDom();

    buildDom.buildCharacter.addEventListener("click", () => {
        character = buildDom.buildCharacter.value;
        character = parse(character);
        statUpdate("character");
        buildDom.characterContainer.removeChild(buildDom.characterContainer.firstElementChild);
        var newImage = document.createElement("img");
        newImage.src = character.iconImage;
        newImage.alt = character.name;
        buildDom.characterContainer.insertBefore(newImage, buildDom.characterContainer.firstChild);
        verifyCompatibility();
    });

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
    })
}

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
            }
        }
    }
    else if(selector == "weapon") {
        if(sheetStats.baseAttack == undefined) {
            sheetStats.baseAttack = 0;
        }
        sheetStats.baseAttack += parseInt(weapon.baseAttack);
        sheetStats["bonus"+String(weapon.statName).replace(" ", "").toLowerCase()] = parseFloat(weapon.statValue);
    }
    if(character != undefined) {
        for(var key in buildDom.statContainers) {
            if(buildDom.statContainers[key].localName == "span") {
                var statName = buildDom.statContainers[key].firstElementChild.textContent;
                var value = buildDom.statContainers[key].lastElementChild;
                switch(statName.toLowerCase()) {
                    case "hp": {
                        var base = sheetStats.baseHP;
                        var percent = sheetStats.baseHPPercent;
                        var flat;
                        if(percent == 0) {
                            value.innerHTML = sheetStats.baseHP;
                        }
                        else {
                            value.innerHTML = base + (base * percent) + "(+" + String(base * percent) + ")";
                        }
                    } break;
                    case "attack": {
                        var base = sheetStats.baseAttack;
                        var percent = sheetStats.baseAttackPercent;
                        var flat;
                        if(percent == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = base + (percent * base) + "(+" + String(base * percent) + ")";
                        }
                    } break;

                    case "defense": {
                        var base = sheetStats.baseDefense;
                        var percent = sheetStats.baseDefensePercent;
                        var flat;
                        if(percent == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = base + (percent * base) + "(+" + String(base * percent) + ")";
                        }
                    } break;

                    case "elemental mastery": {
                        var base = sheetStats.baseElemMastery;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "hp percent": {
                        var percent = sheetStats.baseHPPercent;
                        value.innerHTML = percent;
                    } break;

                    case "attack percent": {
                        var percent = sheetStats.baseHPPercent;
                        value.innerHTML = percent;
                    } break;

                    case "defense percent": {
                        var percent = sheetStats.baseHPPercent;
                        value.innerHTML = percent;
                    } break;

                    case "energy recharge": {
                        var base = sheetStats.baseEnergyRecharge;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "crit": {
                        var base = sheetStats.baseCrit;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "crit damage": {
                        var base = sheetStats.baseCritDamage;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    }

                    case "physical damage bonus": {
                        var base = sheetStats.basePhysDamage;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "elemental damage bonus": {
                        var base = sheetStats.baseElemDamage;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;

                    case "healing bonus": {
                        var base = sheetStats.baseHealingPercent;
                        var flat = 0;
                        if(flat == 0) {
                            value.innerHTML = base;
                        }
                        else {
                            value.innerHTML = (base + flat) + "(+" + String(flat) + ")";
                        }
                    } break;
                }
            }
        }
    }
}