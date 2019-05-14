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
@Table(name = "PEDIDO_MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoMaterial.findAll", query = "SELECT p FROM PedidoMaterial p")})
public class PedidoMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "ID_HERRAMIENTA", referencedColumnName = "ID")
    @ManyToOne
    private Herramienta herramienta;
    @JoinColumn(name = "ID_MAQUINARIA", referencedColumnName = "ID")
    @ManyToOne
    private Maquinaria maquinaria;
    @JoinColumn(name = "ID_MATERIAL", referencedColumnName = "ID")
    @ManyToOne
    private Material material;
    @JoinColumn(name = "ID_PROYECTO", referencedColumnName = "ID")
    @ManyToOne
    private Proyecto proyecto;

    public PedidoMaterial() {
    }

    public PedidoMaterial(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public Maquinaria getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(Maquinaria maquinaria) {
        this.maquinaria = maquinaria;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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
        if (!(object instanceof PedidoMaterial)) {
            return false;
        }
        PedidoMaterial other = (PedidoMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PedidoMaterial[ id=" + id + " ]";
    }
    
}
