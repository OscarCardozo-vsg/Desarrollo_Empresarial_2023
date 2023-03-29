package com.usta.empresarialfull.models.dao;

import com.usta.empresarialfull.entities.directorEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface directorDAO extends CrudRepository<directorEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE directorEntity SET estado = false WHERE idDirector = ?1")
    public void changeState(Long id);
}
