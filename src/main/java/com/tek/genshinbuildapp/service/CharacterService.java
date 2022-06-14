package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.dao.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void saveCharacter(Character character, String iconImage) {
        character.setIconImage(iconImage);
        characterRepository.save(character);
    }

    public void saveAll(List<Character> characters) {
        characterRepository.saveAll(characters);
    }
}
