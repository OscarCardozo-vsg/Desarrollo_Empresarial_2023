package com.usta.empresarialfull.entities;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "director")
public class directorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //llave primaria se genera sola
    @Column(name = "idDirector")
    private Long idDirector;

    @NotNull
    @Size(min = 1,max= 20)
    @Column(name = "documento", unique = true)
    private String documento;

    @NotNull
    @Size(min = 1,max= 30)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Size(min = 1,max= 30)
    @Column(name = "apellido")
    private String apellido;

    @NotNull
    @Size(min = 1,max= 30)
    @Column(name = "calificacion")
    private Float calificacion;

    @JoinColumn(name = "idUniversidad")
    @OneToOne
    private universidadEntity idUniversidad;

    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public Long getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Long idDirector) {
        this.idDirector = idDirector;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public universidadEntity getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(universidadEntity idUniversidad) {
        this.idUniversidad = idUniversidad;
    }
}