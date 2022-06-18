package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.ArtifactMainstatRepository;
import com.tek.genshinbuildapp.dao.ArtifactRepository;
import com.tek.genshinbuildapp.dao.ArtifactSubstatRepository;
import com.tek.genshinbuildapp.dao.UserRepository;
import com.tek.genshinbuildapp.dto.ArtifactDto;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtifactService {

    private ArtifactRepository artifactRepository;
    private ArtifactMainstatRepository mainstatRepository;
    private ArtifactSubstatRepository substatRepository;
    private UserService userService;

    @Autowired
    public ArtifactService(ArtifactRepository artifactRepository,
                           ArtifactMainstatRepository mainstatRepository,
                           ArtifactSubstatRepository substatRepository,
                           UserService userService) {
        this.artifactRepository = artifactRepository;
        this.mainstatRepository = mainstatRepository;
        this.substatRepository = substatRepository;
        this.userService = userService;
    }

    public List<Artifact> retrieveArtifacts(User user) {
        return artifactRepository.findAllByUserId(user.getId());
    }
}
