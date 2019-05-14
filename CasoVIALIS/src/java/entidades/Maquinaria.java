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
@Table(name = "MAQUINARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquinaria.findAll", query = "SELECT m FROM Maquinaria m")})
public class Maquinaria implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_MAQUINARIA")
    private String nombreMaquinaria;
    @Column(name = "TIPO_MAQUINARIA")
    private String tipoMaquinaria;
    @Column(name = "COSTO_MAQUINARIA")
    private BigInteger costoMaquinaria;
    @Column(name = "STOCK_MAQUINARIA")
    private BigInteger stockMaquinaria;
    @OneToMany(mappedBy = "maquinaria")
    private Collection<PedidoMaterial> pedidoMaterialCollection;

    public Maquinaria() {
    }

    public Maquinaria(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public String getTipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(String tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
    }

    public BigInteger getCostoMaquinaria() {
        return costoMaquinaria;
    }

    public void setCostoMaquinaria(BigInteger costoMaquinaria) {
        this.costoMaquinaria = costoMaquinaria;
    }

    public BigInteger getStockMaquinaria() {
        return stockMaquinaria;
    }

    public void setStockMaquinaria(BigInteger stockMaquinaria) {
        this.stockMaquinaria = stockMaquinaria;
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
        if (!(object instanceof Maquinaria)) {
            return false;
        }
        Maquinaria other = (Maquinaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Maquinaria[ id=" + id + " ]";
    }
    
}
