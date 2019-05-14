/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_MATERIAL")
    private String nombreMaterial;
    @Column(name = "TIPO_MATERIAL")
    private String tipoMaterial;
    @Column(name = "COSTO_MATERIAL")
    private BigInteger costoMaterial;
    @Column(name = "ESTADO_MATERIAL")
    private String estadoMaterial;
    @Column(name = "STOCK_MATERIAL")
    private BigInteger stockMaterial;
    @OneToMany(mappedBy = "material")
    private Collection<PedidoMaterial> pedidoMaterialCollection;

    public Material() {
    }

    public Material(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public BigInteger getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(BigInteger costoMaterial) {
        this.costoMaterial = costoMaterial;
    }

    public String getEstadoMaterial() {
        return estadoMaterial;
    }

    public void setEstadoMaterial(String estadoMaterial) {
        this.estadoMaterial = estadoMaterial;
    }

    public BigInteger getStockMaterial() {
        return stockMaterial;
    }

    public void setStockMaterial(BigInteger stockMaterial) {
        this.stockMaterial = stockMaterial;
    }

    @XmlTransient
    public Collection<PedidoMaterial> getPedidoMaterialCollection() {
        return pedidoMaterialCollection;
    }

    public void setPedidoMaterialCollection(Collection<PedidoMaterial> pedidoMaterialCollection) {
        this.pedidoMaterialCollection = pedidoMaterialCollection;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Material[ id=" + id + " ]";
    }
    
}
