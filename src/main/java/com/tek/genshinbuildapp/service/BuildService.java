package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.BuildRepository;
import com.tek.genshinbuildapp.model.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildService {

    private final BuildRepository buildRepository;

    @Autowired
    public BuildService(BuildRepository buildRepository) {
        this.buildRepository = buildRepository;
    }

    public void saveBuild(Build build) {
        buildRepository.save(build);
    }
}
