package com.tek.genshinbuildapp.dto;

import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.Build;
import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.Weapon;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    @NonNull
    long id;
    String username;
    String password;
    Set<Character> characters;
    Set<Weapon> weapons;
    Set<Artifact> artifacts;
    Set<Build> builds;
    Set<Character> removeCharacter;
    Set<Weapon> removeWeapon;
}
