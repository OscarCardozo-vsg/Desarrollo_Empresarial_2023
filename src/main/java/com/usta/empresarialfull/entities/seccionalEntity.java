package com.usta.empresarialfull.entities;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "seccionales")
public class seccionalEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //llave primaria se genera sola
    @Column(name = "id_seccional")
    private Long id_seccional;

    @NotNull
    @Size(min = 1,max= 30)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "cantidadFacultades")
    private Integer cantidadFacultades;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @JoinColumn(name = "idUniversidad", referencedColumnName = "idUniversidad")
    @ManyToOne (fetch = FetchType.LAZY)
    private universidadEntity idUniversidad;

    public Long getId_seccional() {
        return id_seccional;
    }

    public void setId_seccional(Long id_seccional) {
        this.id_seccional = id_seccional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadFacultades() {
        return cantidadFacultades;
    }

    public void setCantidadFacultades(Integer cantidadFacultades) {
        this.cantidadFacultades = cantidadFacultades;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public universidadEntity getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(universidadEntity idUniversidad) {
        this.idUniversidad = idUniversidad;
    }
}
