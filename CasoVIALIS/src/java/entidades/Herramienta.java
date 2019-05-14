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
@Table(name = "HERRAMIENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Herramienta.findAll", query = "SELECT h FROM Herramienta h")})
public class Herramienta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_HERRAMIENTA")
    private String nombreHerramienta;
    @Column(name = "TIPO_HERRAMIENTA")
    private String tipoHerramienta;
    @Column(name = "COSTO_HERRAMIENTA")
    private BigInteger costoHerramienta;
    @Column(name = "ESTADO_HERRAMIENTA")
    private String estadoHerramienta;
    @Column(name = "STOCK_HERRAMIENTA")
    private BigInteger stockHerramienta;
    @OneToMany(mappedBy = "herramienta")
    private Collection<PedidoMaterial> pedidoMaterialCollection;

    public Herramienta() {
    }

    public Herramienta(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getTipoHerramienta() {
        return tipoHerramienta;
    }

    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }

    public BigInteger getCostoHerramienta() {
        return costoHerramienta;
    }

    public void setCostoHerramienta(BigInteger costoHerramienta) {
        this.costoHerramienta = costoHerramienta;
    }

    public String getEstadoHerramienta() {
        return estadoHerramienta;
    }

    public void setEstadoHerramienta(String estadoHerramienta) {
        this.estadoHerramienta = estadoHerramienta;
    }

    public BigInteger getStockHerramienta() {
        return stockHerramienta;
    }

    public void setStockHerramienta(BigInteger stockHerramienta) {
        this.stockHerramienta = stockHerramienta;
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
        if (!(object instanceof Herramienta)) {
            return false;
        }
        Herramienta other = (Herramienta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Herramienta[ id=" + id + " ]";
    }
    
}
