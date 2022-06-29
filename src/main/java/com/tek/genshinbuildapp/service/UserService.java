package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.UserRepository;
import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User retrieveUser(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        else {
            throw new EntityNotFoundException("No user with id: " + id);
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void removeAllCharacters(User user, Set<Character> characters) {
        Set<Character> original = user.getCharacters();
        characters.forEach(original::remove);
        user.setCharacters(original);
        userRepository.save(user);
    }
}
