"use strict";

window.onload = init;

function init() {
    if(artifactSets != null && artifactSets != undefined) {
        var names = document.getElementsByClassName('artifact-name');
        var flavorTexts = document.getElementsByClassName('flavor-text-box');
        var images = document.getElementsByClassName('artifact-image');
        for(var index in artifactSets) {
            let set = artifactSets[index].toLowerCase();
            let slot = artifactSlots[index].toLowerCase();
            if(set.includes("’")) {
                var firstWord = set.substring(0, set.indexOf("’")).toLowerCase();
                console.log(firstWord);
                if(firstWord == "wanderer") {
                    console.log(artifactMetaData[firstWord][slot].flavor);
                    names[index].innerHTML = artifactMetaData[firstWord][slot].name;
                    flavorTexts[index].innerHTML = `<p class="flavor-text">${artifactMetaData[firstWord][slot].flavor}</p>`
                    images[index].src = artifactMetaData[firstWord][slot].img;
                }
            }
            //inject flavor text
            //set image source
        }
    }
}

const artifactMetaData = {
    set: {
        flower: {
            flavor: 'example',
            img: 'text'
        }
    },
    gladiator: {
        flower: {
            name: "Gladiator's Nostalgia",
            flavor: "No one knows why the legendary gladiator wore this flower on his chest. It was the brutal warrior's only weakness.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/b/b1/Item_Gladiator%27s_Nostalgia.png"
        },
        plume: {
            name: "Gladiator's Destiny",
            flavor: "A feather of dreams that soars free like an eagle. At the end of the gladiator's legendary life, this parting gift was left upon his chest by a bird that knew true freedom.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/94/Item_Gladiator%27s_Destiny.png"
        },
        sands: {
            name: "Gladiator's Longing",
            flavor: "A timepiece that recorded the gladiator's days in the bloodstained Colosseum. To him, it counted down the days on his long road to freedom.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/0c/Item_Gladiator%27s_Longing.png"
        },
        goblet: {
            name: "Gladiator's Intoxication",
            flavor: "The golden cup a champion gladiator drank from in ancient times. It brimmed with his glory for years until the fateful day of his fall.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/6d/Item_Gladiator%27s_Intoxication.png"
        },
        circlet: {
            name: "Gladiator's Triumphus",
            flavor: "The helmet of a legendary gladiator from ancient times, who would proudly stretch out his bloodied arms to welcome the thunderous applause of his audience.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/9b/Item_Gladiator%27s_Triumphus.png"
        }
    },
    wanderer: {
        flower: {
            name: "Troupe's Dawnlight",
            flavor: "A small flower-shaped insignia. If you listen carefully, you can almost hear a flute playing and voices singing.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/a/ad/Item_Troupe%27s_Dawnlight.png"
        }
    }
}