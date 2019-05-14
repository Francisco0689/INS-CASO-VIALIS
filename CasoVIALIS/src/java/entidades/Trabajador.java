/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmaldonc
 */
@Entity
@Table(name = "TRABAJADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")})
public class Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Column(name = "NOMBRE_TRABAJADOR")
    private String nombreTrabajador;
    @Column(name = "APELLIDO_TRABAJADOR")
    private String apellidoTrabajador;
    @Column(name = "RUT_TRABAJADOR")
    private int rutTrabajador;
    @Column(name = "DV_TRABAJADOR")
    private int dvTrabajador;
    @Column(name = "ESTADO_CIVIL_TRABAJADOR")
    private String estadoCivilTrabajador;
    @Column(name = "DIRECCION_TRABAJADOR")
    private String direccionTrabajador;
    @Column(name = "TELEFONO_TRABAJADOR")
    private int telefonoTrabajador;
    @Column(name = "ESTADO_TRABAJADOR")
    private String estadoTrabajador;
    @Column(name = "NACIONALIDAD_TRABAJADOR")
    private String nacionalidadTrabajador;
    @Column(name = "CONDICION_EXTRANJERO_TRAB")
    private String condicionExtranjeroTrab;
    @Column(name = "ESPECIALIDAD_TRABAJADOR")
    private String especialidadTrabajador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador")
    private Collection<Usuario> usuarioCollection;

    public Trabajador() {
    }

    public Trabajador(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoTrabajador() {
        return apellidoTrabajador;
    }

    public void setApellidoTrabajador(String apellidoTrabajador) {
        this.apellidoTrabajador = apellidoTrabajador;
    }

    public int getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(int rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public int getDvTrabajador() {
        return dvTrabajador;
    }

    public void setDvTrabajador(int dvTrabajador) {
        this.dvTrabajador = dvTrabajador;
    }

    public String getEstadoCivilTrabajador() {
        return estadoCivilTrabajador;
    }

    public void setEstadoCivilTrabajador(String estadoCivilTrabajador) {
        this.estadoCivilTrabajador = estadoCivilTrabajador;
    }

    public String getDireccionTrabajador() {
        return direccionTrabajador;
    }

    public void setDireccionTrabajador(String direccionTrabajador) {
        this.direccionTrabajador = direccionTrabajador;
    }

    public int getTelefonoTrabajador() {
        return telefonoTrabajador;
    }

    public void setTelefonoTrabajador(int telefonoTrabajador) {
        this.telefonoTrabajador = telefonoTrabajador;
    }

    public String getEstadoTrabajador() {
        return estadoTrabajador;
    }

    public void setEstadoTrabajador(String estadoTrabajador) {
        this.estadoTrabajador = estadoTrabajador;
    }

    public String getNacionalidadTrabajador() {
        return nacionalidadTrabajador;
    }

    public void setNacionalidadTrabajador(String nacionalidadTrabajador) {
        this.nacionalidadTrabajador = nacionalidadTrabajador;
    }

    public String getCondicionExtranjeroTrab() {
        return condicionExtranjeroTrab;
    }

    public void setCondicionExtranjeroTrab(String condicionExtranjeroTrab) {
        this.condicionExtranjeroTrab = condicionExtranjeroTrab;
    }

    public String getEspecialidadTrabajador() {
        return especialidadTrabajador;
    }

    public void setEspecialidadTrabajador(String especialidadTrabajador) {
        this.especialidadTrabajador = especialidadTrabajador;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }



    @Override
    public String toString() {
        return "entidades.Trabajador[ id=" + id + " ]";
    }
    
}
