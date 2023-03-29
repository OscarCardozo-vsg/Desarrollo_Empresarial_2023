package com.usta.empresarialfull.models.dao;

import com.usta.empresarialfull.entities.directorEntity;
import com.usta.empresarialfull.entities.universidadEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface universidadDAO extends CrudRepository<universidadEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE universidadEntity SET estado = false WHERE idUniversidad = ?1")
    public void changeState(Long id);

    @Transactional
    @Modifying
    @Query("SELECT uni FROM universidadEntity uni WHERE uni.idUniversidad NOT IN (SELECT dir.idUniversidad.idUniversidad FROM directorEntity dir)")
    public List<universidadEntity> selectOneUni();
}
