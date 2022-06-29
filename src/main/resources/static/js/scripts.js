"use strict";

window.onload = init;

function init() {
    if(artifactSets != undefined && artifactSets != null) {
        console.log("Main script file loaded");
        var names = document.getElementsByClassName('artifact-name');
        var flavorTexts = document.getElementsByClassName('flavor-text-box');
        var images = document.getElementsByClassName('artifact-image');
        for(var index in artifactSets) {
            let set = artifactSets[index].toLowerCase().split(" ")[0];
            let slot = artifactSlots[index].toLowerCase().split(" ")[0];
            if(set.includes("’")) {
                var firstWord = set.substring(0, set.indexOf("’")).toLowerCase();
                
            }
            else if(set.includes("-")) {
                var firstWord = set.substring(0, set.indexOf("-").toLowerCase());
            }
            else {
                var firstWord = set;
            }
            names[index].innerHTML = artifactMetaData[firstWord][slot].name;
            flavorTexts[index].innerHTML = `<p class="flavor-text">${artifactMetaData[firstWord][slot].flavor}</p>`
            images[index].src = artifactMetaData[firstWord][slot].img;
        }
    }
}

function verifyPassword() {
    var password = document.getElementById("password").value;
    var confirm = document.getElementById("confirm-password").value;
    var button = document.getElementById("register-button");
    var message = document.getElementById("password-message");
    if(password != confirm && (password.length < 8 || confirm.length < 8)) {
        button.disabled = true;
        message.hidden = false;
        message.innerHTML = "Please enter a password of at least 8 characters. <br> Passwords do not match.";
    }
    else if(password != confirm) {
        message.innerHTML = "Passwords do not match."
        message.hidden = false;
        button.disabled = true;
    }
    else if(password.length < 8 || confirm.length < 8) {
        message.innerHTML = "Please enter a password of at least 8 characters.";
        message.hidden = false;
        button.disabled = true;
    }
    else {
        button.disabled = false;
        message.hidden = true;
    }
}

const artifactMetaData = {
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
        },
        plume: {
            name: "Bard's Arrow Feather",
            flavor: "An azure arrow fletching that has neither faded nor splintered with the passage of time. The sound of running water seems to linger around it.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/4e/Item_Bard%27s_Arrow_Feather.png"
        },
        sands: {
            name: "Concert's Final Hour",
            flavor: "An hourglass used to keep time during a band performance. It once made a crisp sound, but their performance has since ended.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/9e/Item_Concert%27s_Final_Hour.png"
        },
        goblet: {
            name: "Wanderer's String-Kettle",
            flavor: "An ancient, strangely-shaped canteen. The interior is fitted with harp strings, which plays a wondrous tune as the water flows out.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/06/Item_Wanderer%27s_String-Kettle.png"
        },
        circlet: {
            name: "Circlet of Logos",
            flavor: "A top hat that has managed to retain its radiance despite braving the elements for time untold. An ancient tune still resonates within.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/81/Item_Conductor%27s_Top_Hat.png"
        }
    },
    noblesse: {
        flower: {
            name: "Royal Flora",
            flavor: "A satin flower with a glossy finish, fit for an elegant gathering. It still looks as distinguished as it did on the day it was cast aside.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/7/71/Item_Royal_Flora.png"
        },
        plume: {
            name: "Royal Plume",
            flavor: "A feathered hat accessory worn by the old aristocrats of Mondstadt on hunts. It still stands proudly as if no time has passed.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/ee/Item_Royal_Plume.png"
        },
        sands: {
            name: "Royal Pocket Watch",
            flavor: "A pocket watch that once belonged to the old aristocrats of Mondstadt. Passed down from generation to generation, it has witnessed many years of history.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/1a/Item_Royal_Pocket_Watch.png"
        },
        goblet: {
            name: "Royal Silver Urn",
            flavor: "An ornamental urn that once belonged to the old aristocrats of Mondstadt. Mournful winds seem to echo within its empty interior.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/9c/Item_Royal_Silver_Urn.png"
        },
        circlet: {
            name: "Royal Masque",
            flavor: "A masquerade mask worn by the old aristocrats of Mondstadt. Its hollow eyes are fixated on the golden days of the past.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/eb/Item_Royal_Masque.png"
        }
    },
    bloodstained: {
        flower: {
            name: "Bloodstained Flower of Iron",
            flavor: "A dried flower stained black with blood and now as hard as steel. Probably some sort of a memento for its former master.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/5b/Item_Bloodstained_Flower_of_Iron.png"
        },
        plume: {
            name: "Bloodstained Black Plume",
            flavor: "A raven feather pinned to a knight's cape. Countless bloodstains have dyed it pitch black.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/5c/Item_Bloodstained_Black_Plume.png"
        },
        sands: {
            name: "Bloodstained Final Hour",
            flavor: "A timepiece once used by a knight. The liquid inside has dried up, rendering it useless.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/8c/Item_Bloodstained_Final_Hour.png"
        },
        goblet: {
            name: "Bloodstained Chevalier's Goblet",
            flavor: "The dark metallic vessel owned by the Bloodstained Knight. Its exterior has been stained as black as the night by smoke and coagulated blood.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/4f/Item_Bloodstained_Chevalier%27s_Goblet.png"
        },
        circlet: {
            name: "Bloodstained Iron Mask",
            flavor: "The iron mask the knight used to conceal their identity. Many have speculated about the face behind the mask.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/0c/Item_Bloodstained_Iron_Mask.png"
        }
    },
    maiden: {
        flower: {
            name: "Maiden's Distant Love",
            flavor: "A fragrant flower that will bloom for all eternity and never wither.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/d/dc/Item_Maiden%27s_Distant_Love.png"
        },
        plume: {
            name: "Maiden's Heart-Stricken Infatuation",
            flavor: "A feathered accessory that carries the longing for a certain someone, like a migratory bird on the wind.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/7/7b/Item_Maiden%27s_Heart-Stricken_Infatuation.png"
        },
        sands: {
            name: "Maiden's Passing Youth",
            flavor: "The hands of time will never come to an end, but the same cannot be said for those cherished years of the young maiden's life when she was doted upon.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/93/Item_Maiden%27s_Passing_Youth.png"
        },
        goblet: {
            name: "Maiden's Fleeting Leisure",
            flavor: "A vessel made with sweet black tea in mind rather than bitter liquor.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/2/23/Item_Maiden%27s_Fleeting_Leisure.png"
        },
        circlet: {
            name: "Maiden's Fading Beauty",
            flavor: "A meticulously well-maintained woman's hat that keeps wrinkles safely out of sight.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/82/Item_Maiden%27s_Fading_Beauty.png"
        }
    },
    viridescent: {
        flower: {
            name: "In Remembrance of Viridescent Fields",
            flavor: "A wild flower that was once a ubiquitous sight in its homeland. It was picked by a hunter who wore it on their chest.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/90/Item_In_Remembrance_of_Viridescent_Fields.png"
        },
        plume: {
            name: "Viridescent Arrow Feather",
            flavor: "The fletching of an arrow that once pierced right through its prey, but somehow still remains spotless.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/41/Item_Viridescent_Arrow_Feather.png"
        },
        sands: {
            name: "Viridescent Venerer's Determination",
            flavor: "A wondrous instrument that a hunter once wore. It forever points towards their prey.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/8f/Item_Viridescent_Venerer%27s_Determination.png"
        },
        goblet: {
            name: "Viridescent Venerer's Vessel",
            flavor: "A water pouch used by the Viridescent Venerer. Its capacity is much greater than one would expect.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/f/ff/Item_Viridescent_Venerer%27s_Vessel.png"
        },
        circlet: {
            name: "Viridescent Venerer's Diadem",
            flavor: "A proud crown that once belonged to the Viridescent Venerer. It is as lush and green as the breezes of the wild.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/8b/Item_Viridescent_Venerer%27s_Diadem.png"
        }
    },
    archaic: {
        flower: {
            name: "Flower of Creviced Cliff",
            flavor: "A flower born of the minerals and rocks of cliffside cracks. The way its petals blow in the wind makes it seem alive.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/9f/Item_Flower_of_Creviced_Cliff.png"
        },
        plume: {
            name: "Feather of Jagged Peaks",
            flavor: "A hard feather from a large seacliff hawk. The basalt tip of the feather sometimes glistens with a cool dew.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/a/a5/Item_Feather_of_Jagged_Peaks.png"
        },
        sands: {
            name: "Sundial of Enduring Jade",
            flavor: "A sundial carved from a single, large piece of jade. It's lined with a pattern that silently records the passage of time.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/1d/Item_Sundial_of_Enduring_Jade.png"
        },
        goblet: {
            name: "Goblet of Chiseled Crag",
            flavor: "A resplendent yet dignified wine goblet, once filled to the brim in an era long gone.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/02/Item_Goblet_of_Chiseled_Crag.png"
        },
        circlet: {
            name: "Mask of Solitude Basalt",
            flavor: "A solemn mask exquisitely carved from basalt. Its hollow eyes stare ahead expressionless and cold.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/09/Item_Mask_of_Solitude_Basalt.png"
        }
    },
    retracing: {
        flower: {
            name: "Summer Night's Bloom",
            flavor: "A man-made flower in eternal bloom. Who knows if there truly is life in there?",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/a/a6/Item_Summer_Night%27s_Bloom.png"
        },
        plume: {
            name: "Summer Night's Finale",
            flavor: "A well-crafted wooden dart. It will only stop once it has reached its destination.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/ec/Item_Summer_Night%27s_Finale.png"
        },
        sands: {
            name: "Summer Night's Moment",
            flavor: "A pocketwatch that has stopped at a certain point in time.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/3/34/Item_Summer_Night%27s_Moment.png"
        },
        goblet: {
            name: "Summer Night's Waterballoon",
            flavor: "Water balloons can be seen everywhere during the summer festival, but none are as finely-wrought as this one.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/10/Item_Summer_Night%27s_Waterballoon.png"
        },
        circlet: {
            name: "Summer Night's Mask",
            flavor: "A popular mask cast in the image of a deity, as described in the legends.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/8a/Item_Summer_Night%27s_Mask.png"
        }
    },
    thundersoother: {
        flower: {
            name: "Thundersoother's Heart",
            flavor: "A flower that blooms even amidst ferocious thunder and lightning. To this day, it still grants courage to travelers in thunderstorms.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/ef/Item_Thundersoother%27s_Heart.png"
        },
        plume: {
            name: "Thundersoother's Plume",
            flavor: "The feather of a predatory bird that soars through lightning storms. It was said to have been adopted as an insignia by the legendary hero who pacified thunder and lightning.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/c/cb/Item_Thundersoother%27s_Plume.png"
        },
        sands: {
            name: "Hour of Soothing Thunder",
            flavor: "A timepiece kept by hero who conquered thunder and lightning. The tiny shard of Electro crystal within flow back and forth with the passing of time.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/b/b7/Item_Hour_of_Soothing_Thunder.png"
        },
        goblet: {
            name: "Thundersoother's Goblet",
            flavor: "The wine goblet from which the Thundersoother, who defeated the Beast of Thunder, once drank violet lightning.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/87/Item_Thundersoother%27s_Goblet.png"
        },
        circlet: {
            name: "Thundersoother's Diadem",
            flavor: "The crown given to the Thundersoother for defeating the Beast of Thunder that had been wreaking havoc upon the land.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/14/Item_Thundersoother%27s_Diadem.png"
        }
    },
    thundering: {
        flower: {
            name: "Thunderbird's Mercy",
            flavor: "A lightning-infused flower, somehow spared the fate of being trodden underfoot or reduced to ash by the furious purple fire, making it the sole survivor on the day of disaster.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/57/Item_Thunderbird%27s_Mercy.png"
        },
        plume: {
            name: "Survivor of Catastrophe",
            flavor: "A lightning-charged feather that still flickers with the wrath of the Thunderbird's cruel retribution.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/e9/Item_Survivor_of_Catastrophe.png"
        },
        sands: {
            name: "Hourglass of Thunder",
            flavor: "The hourglass used to foretell the coming of the Thunderbird by the tribe that worshiped it. It has fallen into eternal silence now that the tribe is no more.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/94/Item_Hourglass_of_Thunder.png"
        },
        goblet: {
            name: "Omen of Thunderstorm",
            flavor: "A ceremonial cup that holds the blood of the innocent. It is brimming with the thundering fury of the prayers that echo within.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/c/cd/Item_Omen_of_Thunderstorm.png"
        },
        circlet: {
            name: "Thunder Summoner's Crown",
            flavor: "A crown once worn by an ancient shaman who worshiped the Thunderbird. The capricious beast remained unmoved by the shaman's devotion.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/a/a5/Item_Thunder_Summoner%27s_Crown.png"
        }
    },
    lavawalker: {
        flower: {
            name: "Lavawalker's Resolution",
            flavor: "A flower that blooms amidst burning flames. It is said that long ago, a sage once wore it as he walked into a sea of fire.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/b/b5/Item_Lavawalker%27s_Resolution.png"
        },
        plume: {
            name: "Lavawalker's Salvation",
            flavor: "The feather of a proud phoenix. You can almost hear the sound of its wings flapping in the scorching flames.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/0a/Item_Lavawalker%27s_Salvation.png"
        },
        sands: {
            name: "Lavawalker's Torment",
            flavor: "Burning sand flows within this hourglass. Despite the intense heat, the sand leave no mark upon the vessel that houses it.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/3/3f/Item_Lavawalker%27s_Torment.png"
        },
        goblet: {
            name: "Lavawalker's Epiphany",
            flavor: "A legendary goblet that can withstand extremely high temperatures. It still retains a degree of warmth even though it is now empty.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/1b/Item_Lavawalker%27s_Epiphany.png"
        },
        circlet: {
            name: "Lavawalker's Wisdom",
            flavor: "The circlet of a sage who traversed a sea of fire. It once shone brightly from their ancient silhouette as they stood strong amidst the flames.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/63/Item_Lavawalker%27s_Wisdom.png"
        }
    },
    crimson: {
        flower: {
            name: "Witch's Flower of Blaze",
            flavor: "A flower touched by the witch who once dreamt of burning away all the demons in the world. The anonymous flames affectionately caress the hands of those who touch it.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/0f/Item_Witch%27s_Flower_of_Blaze.png"
        },
        plume: {
            name: "Witch's Ever-Burning Plume",
            flavor: "A bird feather touched by the witch who once dreamt of burning away all the demons in the world. Its eternal flame burns hot.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/b/b3/Item_Witch%27s_Ever-Burning_Plume.png"
        },
        sands: {
            name: "Witch's End Time",
            flavor: "A timepiece worn by the witch who dreamt of burning away all the demons in the world. The years the witch dedicated to the flames flow within.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/14/Item_Witch%27s_End_Time.png"
        },
        goblet: {
            name: "Witch's Heart Flames",
            flavor: "A flame-spitting urn left behind by the Crimson Witch of Flames, who once dreamt of burning away all the demons in the world. The fire in the urn burns eternally, as did its former master.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/b/ba/Item_Witch%27s_Heart_Flames.png"
        },
        circlet: {
            name: "Witch's Scorching Hat",
            flavor: "A hat once worn by the witch who dreamt of burning away all the demons in the world. The large brim blocked her sight.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/ea/Item_Witch%27s_Scorching_Hat.png"
        }
    },
    blizzard: {
        flower: {
            name: "Snowswept Memory",
            flavor: "A long-extinct flower, covered in beads of frost, that once grew on the glaciers. There was a time when even the proudest and most arrogant warriors bowed before it.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/69/Item_Snowswept_Memory.png"
        },
        plume: {
            name: "Icebreaker's Resolve",
            flavor: "A feather that exudes a chilly aura. One can almost feel the turbulent winds that brought it here, wailing over snow-covered plains and between frosty peaks.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/d/d6/Item_Icebreaker%27s_Resolve.png"
        },
        sands: {
            name: "Frozen Homeland's Demise",
            flavor: "A timepiece from a nation of old that waited for their warriors' return. What flows inside is not sand, but bits of ice that never melt.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/58/Item_Frozen_Homeland%27s_Demise.png"
        },
        goblet: {
            name: "Frost-Weaved Dignity",
            flavor: "A cup carved out of ice that is as chilly and biting as winter. Its former master would drink an unfreezable liquor from it.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/6a/Item_Frost-Weaved_Dignity.png"
        },
        circlet: {
            name: "Broken Rime's Echo",
            flavor: "The crown of an ancient hero who dreamt of conquering the cold. It is proof of its former master's bravery in facing the bone-chilling cold of winter.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/d/df/Item_Broken_Rime%27s_Echo.png"
        }
    },
    heart: {
        flower: {
            name: "Gilded Corsage",
            flavor: "A mantle brooch that has lost its luster. The gold plating that once adorned it was ground away by the wind and the waves long ago.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/40/Item_Gilded_Corsage.png"
        },
        plume: {
            name: "Gust of Nostalgia",
            flavor: "A feather carried over by whimpering sea winds and crimson waves. The passage of time has changed its shape and color.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/92/Item_Gust_of_Nostalgia.png"
        },
        sands: {
            name: "Copper Compass",
            flavor: "An ancient bronze compass. Its needle points towards some ever-distant shore, to a non-existent harbor.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/83/Item_Copper_Compass.png"
        },
        goblet: {
            name: "Goblet of Thundering Deep",
            flavor: "A faded wine cup that was unintentionally dredged up from the sea. Its dull exterior tells of the days it has spent beneath the waves.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/9c/Item_Goblet_of_Thundering_Deep.png"
        },
        circlet: {
            name: "Wine-Stained Tricorne",
            flavor: "An ancient, wine-stained sea hat that still reeks of alcohol even now.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/a/a6/Item_Wine-Stained_Tricorne.png"
        }
    },
    tenacity: {
        flower: {
            name: "Flower of Accolades",
            flavor: "A flower made from gold leaf. It represents the glories and honors attained by its wearer",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/51/Item_Flower_of_Accolades.png"
        },
        plume: {
            name: "Ceremonial War-Plume",
            flavor: "A falcon feather worn on ceremonial occasions. It displays the dignity and resolve of Liyue Harbor to the outside world.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/86/Item_Ceremonial_War-Plume.png"
        },
        sands: {
            name: "Orichalceous Time-Dial",
            flavor: "A simple device for telling time. This was once standard-issue for the Millelith during times of war.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/92/Item_Orichalceous_Time-Dial.png"
        },
        goblet: {
            name: "Noble's Pledging Vessel",
            flavor: "A golden cup used by the Millelith to take their oaths. Still bears the lovely scent of wine.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/f/f4/Item_Noble%27s_Pledging_Vessel.png"
        },
        circlet: {
            name: "General's Ancient Helm",
            flavor: "A splendorous helmet from ages past. Clean the dust away and it will look brand-new once more.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/b/b9/Item_General%27s_Ancient_Helm.png"
        }
    },
    pale: {
        flower: {
            name: "Stainless Bloom",
            flavor: "A hard, blue artificial flower. Its petals shall never wither, nor shall its colors fade.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/e7/Item_Stainless_Bloom.png"
        },
        plume: {
            name: "Wise Doctor's Pinion",
            flavor: "An ominous pinion with edges of unsurpassed keenness. Perhaps it represents an unnaturally uninhibited nature.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/e8/Item_Wise_Doctor%27s_Pinion.png"
        },
        sands: {
            name: "Moment of Cessation",
            flavor: "A pocket watch with a cover that cannot be opened. Yet it ticks and tocks away, following the inexorable flow of time.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/85/Item_Moment_of_Cessation.png"
        },
        goblet: {
            name: "Surpassing Cup",
            flavor: "An intricately-made cup. Its appearance betrays nothing of its age to an observer.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/4b/Item_Surpassing_Cup.png"
        },
        circlet: {
            name: "Mocking Mask",
            flavor: "A mask that covers the face, hiding one's expression from others.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/2/23/Item_Mocking_Mask.png"
        }
    },
    shimenawa: {
        flower: {
            name: "Entangling Bloom",
            flavor: "A lovely amulet made from twisted paper cord. It is said to hold the power to make wishes come true.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/c/c2/Item_Entangling_Bloom.png"
        },
        plume: {
            name: "Shaft of Remembrance",
            flavor: "A demon-slaying arrow of a rather ancient make. It seems to have been preserved with great care by someone, even until the present day.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/41/Item_Shaft_of_Remembrance.png"
        },
        sands: {
            name: "Morning Dew's Moment",
            flavor: "A bronze pocket watch adorned with twisted paper cord and a bell. Its hands are forever frozen at the dawn of a certain autumn day.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/92/Item_Morning_Dew%27s_Moment.png"
        },
        goblet: {
            name: "Hopeful Heart",
            flavor: "A special fortune-telling cylindrical object. The mechanism at the bottom allows one to easily remove all unwanted wish sticks.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/86/Item_Hopeful_Heart.png"
        },
        circlet: {
            name: "Capricious Visage",
            flavor: "A well-preserved ceremonial fox mask. A small, enigmatic smile ever graces its lips.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/8f/Item_Capricious_Visage.png"
        }
    },
    emblem: {
        flower: {
            name: "Magnificent Tsuba",
            flavor: "Legends has it that this ornate hand guard was once fitted upon a sword gifted to the oni who betrayed the Shogun.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/53/Item_Magnificent_Tsuba.png"
        },
        plume: {
            name: "Sundered Feather",
            flavor: "This was once the black feather of a certain tengu warrior, and was the treasured souvenir of an ancient swordsman.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/d/d6/Item_Sundered_Feather.png"
        },
        sands: {
            name: "Storm Cage",
            flavor: "An exquisite seal cage patterned with pansies painted upon a black backdrop, decorated with shining inlaid seashells and intricate gold-work.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/e5/Item_Storm_Cage.png"
        },
        goblet: {
            name: "Scarlet Vessel",
            flavor: "An intricately-designed wine vessel that a world-famous martial artist once drank from.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/00/Item_Scarlet_Vessel.png"
        },
        circlet: {
            name: "Ornate Kabuto",
            flavor: "A sturdy and hard helmet worn as armor by a noble samurai.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/04/Item_Ornate_Kabuto.png"
        }
    },
    husk: {
        flower: {
            name: "Bloom Times",
            flavor: "A small golden ornament with six petals that shall never wilt. It symbolizes the transience of mortal glories.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/2/2b/Item_Bloom_Times.png"
        },
        plume: {
            name: "Plume of Luxury",
            flavor: "A feather-shaped token that was brought forth from a secluded hall. The compassion of its creator led to it being left within that mansion along with a certain slumbering form.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/2/2d/Item_Plume_of_Luxury.png"
        },
        sands: {
            name: "Song of Life",
            flavor: "As far as Inazuma is concerned, this is some small object from overseas. The heart of this mechanism has been removed, and its hands no longer turn.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/4/4f/Item_Song_of_Life.png"
        },
        goblet: {
            name: "Calabash of Awakening",
            flavor: "A gourd that has been adorned with powdered gold and black paint. Its original color can no longer be discerned, but its main use seems to be as a performance prop.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/63/Item_Calabash_of_Awakening.png"
        },
        circlet: {
            name: "Skeletal Hat",
            flavor: "A hat that once shielded a wanderer from sun and rain. It eventually became a convenient tool with which faces might be hidden and expressions obscured.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/84/Item_Skeletal_Hat.png"
        }
    },
    ocean: {
        flower: {
            name: "Sea-Dyed Blossom",
            flavor: "A soft flower that has taken on the many shades of the capricious ocean. It shines with wondrous colors under the moon's silver light.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/58/Item_Sea-Dyed_Blossom.png"
        },
        plume: {
            name: "Deep Palace's Plume",
            flavor: "A down feather with the same hue as coral, said to come from a shrine maiden's ceremonial garment.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/3/33/Item_Deep_Palace%27s_Plume.png"
        },
        sands: {
            name: "Cowry of Parting",
            flavor: "A clean, flawless shell that comes from the bottomless ocean.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/e/ed/Item_Cowry_of_Parting.png"
        },
        goblet: {
            name: "Pearl Cage",
            flavor: "The shining pearls that the shrine maidens of Watatsumi Island offer up shine eternally and never dim.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/f/fc/Item_Pearl_Cage.png"
        },
        circlet: {
            name: "Crown of Watatsumi",
            flavor: "An ancient, intricate crown that was once used by a forgotten clergy member. Today, this relic has been enshrined with great ceremony by the people of Watatsumi.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/60/Item_Crown_of_Watatsumi.png"
        }
    },
    vermillion: {
        flower: {
            name: "Flowering Life",
            flavor: "An ancient memento. It still looks as alive as the being that preserved it several centuries ago.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/11/Item_Flowering_Life.png"
        },
        plume: {
            name: "Feather of Nascent Light",
            flavor: "A dimly lustrous pinion steeped in strong memories.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/a/a7/Item_Feather_of_Nascent_Light.png"
        },
        sands: {
            name: "Solar Relic",
            flavor: "An ancient timepiece with a mighty solid look. Its luster is produced by sand crystal.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/1/12/Item_Solar_Relic.png"
        },
        goblet: {
            name: "Moment of the Pact",
            flavor: "An old cup made of sand crystal. Its luster is somehow undimmed by age.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/7/77/Item_Moment_of_the_Pact.png"
        },
        circlet: {
            name: "Thundering Poise",
            flavor: "This mask is said to have been made by the mountain people for a Yaksha. It is of simple make, but its surface still shines brightly nonetheless.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/0e/Item_Thundering_Poise.png"
        }
    },
    echoes: {
        flower: {
            name: "Soulscent Bloom",
            flavor: "A jade carved into the shape of a flower. A phantom scent, here one instant and gone the next, swirls around it.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/6/64/Item_Soulscent_Bloom.png"
        },
        plume: {
            name: "Jade Leaf",
            flavor: "A jade ornament shaped like a leaf. It seems to have once had deep meaning between specific friends.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/9/97/Item_Jade_Leaf.png"
        },
        sands: {
            name: "Symbol of Felicitation",
            flavor: "A circular jade ornament. Legend has it that it was once used somewhere as a symbol for rituals to begin.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/0/03/Item_Symbol_of_Felicitation.png"
        },
        goblet: {
            name: "Chalice of the Font",
            flavor: "This teacup forever overflows with fresh water. Perhaps it was a gift from an adeptus, one of their relics, or just something they left behind.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/8/89/Item_Chalice_of_the_Font.png"
        },
        circlet: {
            name: "Flowing Rings",
            flavor: "A pair of earrings made from a single piece of jade. It has a most gentle texture.",
            img: "https://static.wikia.nocookie.net/gensin-impact/images/5/53/Item_Flowing_Rings.png"
        }
    }
}