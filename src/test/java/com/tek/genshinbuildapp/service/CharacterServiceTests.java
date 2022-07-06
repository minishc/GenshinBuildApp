package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.CharacterRepository;
import com.tek.genshinbuildapp.model.Character;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CharacterServiceTests {

    @Mock
    static CharacterRepository characterRepository;

    @InjectMocks
    static CharacterService characterService;

    static Character character;

    @BeforeAll
    static void setup() {
        character = new Character("Kuki Shinobu", "Sword", 200, 750, 15000, "baseHPPercent", 39);
        character.setId(1);
    }

    @Test
    void saveCharacter() {
        characterService.saveCharacter(character, "addToBuild.png");
        character.setIconImage("addToBuild.png");
        verify(characterRepository).save(character);
    }

    //for some reason this test only passes if it is run by itself
    @Test
    void findCharacterById() {
        Optional<Character> expected = Optional.of(character);
        when(characterRepository.findById(character.getId())).thenReturn(expected);
        Assertions.assertThat(characterService.findCharacterById(character.getId()))
                .isNotNull().isEqualTo(character);
        verify(characterRepository).findById(character.getId());
    }
}