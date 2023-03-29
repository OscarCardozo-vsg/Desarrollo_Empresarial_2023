package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.seccionalEntity;
import com.usta.empresarialfull.models.dao.seccionalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class seccionalServiceImplement implements IseccionalesService{
    @Autowired
    private seccionalDAO seccionalDAO;

    /**
     * @Desc Este metodo es la implementacion del dao - FillAll CrudRepositorys
     * 1. @Transactional metodo con petición a BD
     * 2. Retornar todos los registros de la BD
     * @CreateAt 05-03-2023
     * @Version 0.0.1
     * @Author Oscar Cardozo
     * @Required Interfaz de Servicio
     * */

    @Override
    @Transactional(readOnly = true)
    public List<seccionalEntity> findAll(){
        return(List<seccionalEntity>) seccionalDAO.findAll();
    }

    /**
     * @Desc Este metodo es la implementacion del dao - save CrudRepositorys
     * 1. @Transactional metodo con petición a BD
     * 2. Realiza INSERT en BD
     * @CreateAt 05-03-2023
     * @Version 0.0.1
     * @Author Oscar Cardozo
     * @Required Interfaz de Servicio
     * */

    @Override
    @Transactional
    public void save(seccionalEntity seccional){
        seccionalDAO.save(seccional);
    }

    /**
     * @Desc Este metodo es la implementacion del dao - delete CrudRepositorys
     * 1. @Transactional metodo con petición a BD
     * 2. Realiza DELETE en BD pasando como parametro el id del registro
     * @CreateAt 05-03-2023
     * @Version 0.0.1
     * @Author Oscar Cardozo
     * @Required Interfaz de Servicio
     * */

    @Override
    @Transactional
    public void remove(Long id ){
        seccionalDAO.deleteById(id);
    }

    /**
     * @Desc Este metodo es la implementacion del dao - update CrudRepositorys
     * 1. @Transactional metodo con petición a BD
     * 2. Realiza UPDATE en BD
     * @CreateAt 05-03-2023
     * @Version 0.0.1
     * @Author Oscar Cardozo
     * @Required Interfaz de Servicio
     * */

    @Override
    @Transactional
    public seccionalEntity updateSeccional(seccionalEntity seccional){
        return seccionalDAO.save(seccional);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        seccionalDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public seccionalEntity findOne(Long id){
        return seccionalDAO.findById(id).orElse(null);
    }
}
