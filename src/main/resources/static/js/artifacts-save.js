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
        } 
        case "goblet":
        case "circlet":
    }
}