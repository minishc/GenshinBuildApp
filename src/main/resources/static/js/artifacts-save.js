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
                if(nodes[element].value == "hp") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "plume": {
            for (element in nodes) {
                if(nodes[element].value == "atk") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "sands": {
            for (element in nodes) {
                if(nodes[element].value == "atk-percent" ||
                        nodes[element].value == "er" || nodes[element].value == "em" || 
                        nodes[element].value == "def-percent" || nodes[element].value == "hp-percent") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "goblet": { 
            for (element in nodes) {
                if(nodes[element].value == "atk-percent" ||
                        nodes[element].value == "def-percent" || nodes[element].value == "hp-percent" ||
                        nodes[element].value == "em" || nodes[element].value == "elemental-dmg-bonus" || 
                        nodes[element].value == "phys-dmg") {
                    nodes[element].disabled = false;
                }
                else {
                    nodes[element].disabled = true;
                }
            }
        } break;
        case "circlet": {
            for (element in nodes) {
                if(nodes[element].value == "atk-percent" || 
                        nodes[element].value == "def-percent" || nodes[element].value == "hp-percent" ||
                        nodes[element].value == "crit" || nodes[element].value == "crit-dmg" ||
                        nodes[element].value == "em" || nodes[element].value == "heal-bonus") {
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
        case "hp": {
            artifactFormDom.mainstatValue.value = 4780;
        } break;
        case "atk": {
            artifactFormDom.mainstatValue.value = 311;
        } break;
        case "hp-percent": {
            artifactFormDom.mainstatValue.value = 46.6;
        } break;
        case "atk-percent": {
            artifactFormDom.mainstatValue.value = 46.6;
        }
        case "elemental-dmg": {
            artifactFormDom.mainstatValue.value = 46.6;
        } break;
        case "def-percent": {
            artifactFormDom.mainstatValue.value = 58.3;
        } break;
        case "phys-dmg": {
            artifactFormDom.mainstatValue.value = 58.3;
        } break;
        case "er": {
            artifactFormDom.mainstatValue.value = 51.8;
        } break;
        case "em": {
            artifactFormDom.mainstatValue.value = 186.5;
        } break;
        case "crit": {
            artifactFormDom.mainstatValue.value = 31.1;
        } break;
        case "crit-dmg": {
            artifactFormDom.mainstatValue.value = 62.2;
        } break;
        case "heal-bonus": {
            artifactFormDom.mainstatValue.value = 35.9;
        } break;
    }
}