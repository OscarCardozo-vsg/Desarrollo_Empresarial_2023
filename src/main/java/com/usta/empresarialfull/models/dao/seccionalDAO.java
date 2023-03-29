package com.usta.empresarialfull.models.dao;

import com.usta.empresarialfull.entities.seccionalEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface seccionalDAO extends CrudRepository<seccionalEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE seccionalEntity SET estado = false WHERE id_seccional = ?1")
    public void changeState(Long id);
}
