/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fmaldonc
 */
@Entity
@Table(name = "REUNION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r")})
public class Reunion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ESTADO_REUNION")
    private String estadoReunion;
    @Column(name = "FECHA_REUNION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReunion;
    @Column(name = "LUGAR_REUNION")
    private String lugarReunion;
    @Column(name = "ENCARGADO_REUNION")
    private String encargadoReunion;

    public Reunion() {
    }

    public Reunion(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEstadoReunion() {
        return estadoReunion;
    }

    public void setEstadoReunion(String estadoReunion) {
        this.estadoReunion = estadoReunion;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public String getLugarReunion() {
        return lugarReunion;
    }

    public void setLugarReunion(String lugarReunion) {
        this.lugarReunion = lugarReunion;
    }

    public String getEncargadoReunion() {
        return encargadoReunion;
    }

    public void setEncargadoReunion(String encargadoReunion) {
        this.encargadoReunion = encargadoReunion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reunion)) {
            return false;
        }
        Reunion other = (Reunion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Reunion[ id=" + id + " ]";
    }
    
}
