package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.seccionalEntity;

import java.util.List;

public interface IseccionalesService {
    public List<seccionalEntity> findAll();
    public void save(seccionalEntity seccional);
    public void remove(Long id);
    public seccionalEntity updateSeccional(seccionalEntity seccional);
    public void changeState(Long id);
    public seccionalEntity findOne(Long id);
}
