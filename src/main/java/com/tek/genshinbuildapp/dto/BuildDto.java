package com.tek.genshinbuildapp.dto;

import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.model.Weapon;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildDto {

    User user;
    Character character;
    Weapon weapon;
    Artifact flower;
    Artifact plume;
    Artifact sands;
    Artifact goblet;
    Artifact circlet;
}
