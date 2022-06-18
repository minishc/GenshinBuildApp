package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.dao.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    public List<Character> retrieveCharacters() {
        return characterRepository.findAll();
    }

    public Character findCharacterById(int id) {
        Character character;
        Optional<Character> result = characterRepository.findById(id);
        if(result.isPresent()) {
            character = result.get();
        }
        else {
            throw new EntityNotFoundException("No character found with id: " + id);
        }
        return character;
    }
}
