package com.tek.genshinbuildapp.security;

import com.tek.genshinbuildapp.AppCommandLineRunner;
import com.tek.genshinbuildapp.dao.AuthGroupRepository;
import com.tek.genshinbuildapp.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrincipalUserServiceTests {

    private final PrincipalUserService principalUserService;
    private final UserService userService;
    private final AppCommandLineRunner runner;

    private final AuthGroupRepository authGroupRepository;

    @Autowired
    public PrincipalUserServiceTests(PrincipalUserService principalUserService, UserService userService,
                                     AppCommandLineRunner runner, AuthGroupRepository authGroupRepository) {
        this.principalUserService = principalUserService;
        this.userService = userService;
        this.runner = runner;
        this.authGroupRepository = authGroupRepository;
        runner.run();
    }

    @Test
    public void testUserRetrieval() {
        PrincipalUser expected = new PrincipalUser(userService.retrieveUser("Chris"),
                authGroupRepository.findAllByUsername("Chris"));
        Assertions.assertEquals(expected, principalUserService.loadUserByUsername("Chris"));
    }
}
