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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HITOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hitos.findAll", query = "SELECT h FROM Hitos h")})
public class Hitos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_HITO")
    private String nombreHito;
    @Column(name = "FECHA_HITO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHito;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID")
    @ManyToOne
    private Proyecto proyecto;

    public Hitos() {
    }

    public Hitos(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreHito() {
        return nombreHito;
    }

    public void setNombreHito(String nombreHito) {
        this.nombreHito = nombreHito;
    }

    public Date getFechaHito() {
        return fechaHito;
    }

    public void setFechaHito(Date fechaHito) {
        this.fechaHito = fechaHito;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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
        if (!(object instanceof Hitos)) {
            return false;
        }
        Hitos other = (Hitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Hitos[ id=" + id + " ]";
    }
    
}
