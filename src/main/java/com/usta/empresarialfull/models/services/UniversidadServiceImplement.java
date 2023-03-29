package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.universidadEntity;
import com.usta.empresarialfull.models.dao.universidadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidadServiceImplement implements IuniversidadService{
    @Autowired
    private universidadDAO universidadDAO;

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
    public List<universidadEntity> findAll(){
        return(List<universidadEntity>) universidadDAO.findAll();
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
    public void save(universidadEntity universidad){
        universidadDAO.save(universidad);
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
        universidadDAO.deleteById(id);
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
    public universidadEntity updateUniversidad(universidadEntity universidad){
        return universidadDAO.save(universidad);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        universidadDAO.changeState(id);
    }
    @Override
    @Transactional(readOnly = true)
    public universidadEntity findOne(Long id){
        return universidadDAO.findById(id).orElse(null);
    }
    @Override
    @Transactional(readOnly = true)
    public universidadEntity selectOneUni(){
        return universidadDAO.findById().orElse(null);
    }
}
