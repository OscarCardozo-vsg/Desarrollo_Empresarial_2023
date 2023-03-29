package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.directorEntity;
import com.usta.empresarialfull.models.dao.directorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class directorServiceImplement implements IdirectorService{
    @Autowired
    private directorDAO directorDAO;

    /**
     * @Desc Este metodo es la implementacion del dao - FillAll CrudRepositorys
     * 1. @Transactional metodo con petición a BD
     * 2. Retornar todos los registros de la BD
     * @CreateAt 05-03-2023
     * @Version 0.0.1
     * @Author Oscar Cardozo
     * @Required Interfaz de Servicio
     */

    @Override
    @Transactional(readOnly = true)
    public List<directorEntity> findAll(){
        return(List<directorEntity>) directorDAO.findAll();
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
    public void save(directorEntity director){
        directorDAO.save(director);
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
        directorDAO.deleteById(id);
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
    public directorEntity updateDirector(directorEntity director){
        return directorDAO.save(director);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        directorDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public directorEntity findOne(Long id){
        return directorDAO.findById(id).orElse(null);
    }
}

