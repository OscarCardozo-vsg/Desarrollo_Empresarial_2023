package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.universidadEntity;

import java.util.List;

public interface IuniversidadService {
    public List<universidadEntity> findAll();
    public void save(universidadEntity universidad);
    public void remove(Long id);
    public universidadEntity updateUniversidad(universidadEntity universidad);
    public void changeState(Long id);
    public universidadEntity findOne(Long id);
    public universidadEntity selectOneUni();
}
