/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fmaldonc
 */
@Entity
@Table(name = "HISTORICO_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoProyecto.findAll", query = "SELECT h FROM HistoricoProyecto h")})
public class HistoricoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_HISTORICO")
    private String nombreHistorico;
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID")
    @ManyToOne
    private Proyecto proyecto;

    public HistoricoProyecto() {
    }

    public HistoricoProyecto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreHistorico() {
        return nombreHistorico;
    }

    public void setNombreHistorico(String nombreHistorico) {
        this.nombreHistorico = nombreHistorico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof HistoricoProyecto)) {
            return false;
        }
        HistoricoProyecto other = (HistoricoProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HistoricoProyecto[ id=" + id + " ]";
    }
    
}
