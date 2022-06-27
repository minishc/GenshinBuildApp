package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.UserRepository;
import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    public List<Weapon> retrieveWeapons(long id) {
        return userRepository.findAllWeaponsById(id);
    }

    public List<Character> retrieveCharacters(long id) {
        return userRepository.findAllCharactersById(id);
    }
}
