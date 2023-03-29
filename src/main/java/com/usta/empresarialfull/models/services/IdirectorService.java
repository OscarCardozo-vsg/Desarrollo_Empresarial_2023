package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.directorEntity;

import java.util.List;

public interface IdirectorService {
    public List<directorEntity> findAll();
    public void save(directorEntity director);
    public void remove(Long id);
    public directorEntity updateDirector(directorEntity director);
    public void changeState(Long id);
    public directorEntity findOne(Long id);
}
