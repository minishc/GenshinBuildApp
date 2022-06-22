window.onload = init;

var artifactFormDom = {
    collectDom: function() {
        this.artifactSlot = document.getElementById("artifact-slot");
        this.mainstatName = document.getElementById("mainstat-name");
        this.mainstatValue = document.getElementById("mainstat-value");
    }
}

function init() {
    artifactFormDom.collectDom();
    artifactFormDom.artifactSlot.addEventListener("change", updateOptions);
    artifactFormDom.mainstatName.addEventListener("change", updateValue);
    updateOptions();
}

function updateOptions() {
    var nodes = artifactFormDom.mainstatName.childNodes;
    switch(artifactFormDom.artifactSlot.value.toLowerCase()) {
        case "flower": {
            for (element in nodes) {
                if(nodes[element].value == "HP") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "plume": {
            for (element in nodes) {
                if(nodes[element].value == "ATK") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "sands": {
            for (element in nodes) {
                if(nodes[element].value == "ATK%" ||
                        nodes[element].value == "Energy Recharge" || nodes[element].value == "Elemental Mastery" || 
                        nodes[element].value == "DEF%" || nodes[element].value == "HP%") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "goblet": { 
            for (element in nodes) {
                if(nodes[element].value == "ATK%" ||
                        nodes[element].value == "DEF%" || nodes[element].value == "HP%" ||
                        nodes[element].value == "Elemental Mastery" || nodes[element].value == "Elemental DMG Bonus" || 
                        nodes[element].value == "Physical DMG Bonus") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "circlet": {
            for (element in nodes) {
                if(nodes[element].value == "ATK%" || 
                        nodes[element].value == "DEF%" || nodes[element].value == "HP%" ||
                        nodes[element].value == "CRIT Rate" || nodes[element].value == "CRIT DMG" ||
                        nodes[element].value == "Elemental Mastery" || nodes[element].value == "Healing Bonus") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
    }
}

function updateValue() {
    switch(artifactFormDom.mainstatName.value) {
        case "HP": {
            artifactFormDom.mainstatValue.value = 4780;
        } break;
        case "ATK": {
            artifactFormDom.mainstatValue.value = 311;
        } break;
        case "HP%": {
            artifactFormDom.mainstatValue.value = 46.6;
        } break;
        case "ATK%": {
            artifactFormDom.mainstatValue.value = 46.6;
        }
        case "Elemental DMG Bonus": {
            artifactFormDom.mainstatValue.value = 46.6;
        } break;
        case "DEF%": {
            artifactFormDom.mainstatValue.value = 58.3;
        } break;
        case "Physical DMG Bonus": {
            artifactFormDom.mainstatValue.value = 58.3;
        } break;
        case "Energy Recharge": {
            artifactFormDom.mainstatValue.value = 51.8;
        } break;
        case "Elemental Mastery": {
            artifactFormDom.mainstatValue.value = 186.5;
        } break;
        case "CRIT Rate": {
            artifactFormDom.mainstatValue.value = 31.1;
        } break;
        case "CRIT DMG": {
            artifactFormDom.mainstatValue.value = 62.2;
        } break;
        case "Healing Bonus": {
            artifactFormDom.mainstatValue.value = 35.9;
        } break;
    }
}