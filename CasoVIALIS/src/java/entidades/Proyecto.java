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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NOMBRE_PROYECTO")
    private String nombreProyecto;
    @Column(name = "TIPO_PROYECTO")
    private String tipoProyecto;
    @Column(name = "ESTADO_PROYECTO")
    private String estadoProyecto;
    @Column(name = "ENCARGADO_PROYECTO")
    private String encargadoProyecto;
    @Column(name = "DIRECCION_PROYECTO")
    private String direccionProyecto;
    @OneToMany(mappedBy = "proyecto")
    private Collection<InspeccionProyecto> inspeccionProyectoCollection;
    @OneToMany(mappedBy = "proyecto")
    private Collection<Cotizacion> cotizacionCollection;
    @OneToMany(mappedBy = "proyecto")
    private Collection<Seguimiento> seguimientoCollection;
    @OneToMany(mappedBy = "proyecto")
    private Collection<Hitos> hitosCollection;
    @OneToMany(mappedBy = "proyecto")
    private Collection<PedidoMaterial> pedidoMaterialCollection;
    @OneToMany(mappedBy = "proyecto")
    private Collection<HistoricoProyecto> historicoProyectoCollection;

    public Proyecto() {
    }

    public Proyecto(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getEncargadoProyecto() {
        return encargadoProyecto;
    }

    public void setEncargadoProyecto(String encargadoProyecto) {
        this.encargadoProyecto = encargadoProyecto;
    }

    public String getDireccionProyecto() {
        return direccionProyecto;
    }

    public void setDireccionProyecto(String direccionProyecto) {
        this.direccionProyecto = direccionProyecto;
    }

    @XmlTransient
    public Collection<InspeccionProyecto> getInspeccionProyectoCollection() {
        return inspeccionProyectoCollection;
    }

    public void setInspeccionProyectoCollection(Collection<InspeccionProyecto> inspeccionProyectoCollection) {
        this.inspeccionProyectoCollection = inspeccionProyectoCollection;
    }

    @XmlTransient
    public Collection<Cotizacion> getCotizacionCollection() {
        return cotizacionCollection;
    }

    public void setCotizacionCollection(Collection<Cotizacion> cotizacionCollection) {
        this.cotizacionCollection = cotizacionCollection;
    }

    @XmlTransient
    public Collection<Seguimiento> getSeguimientoCollection() {
        return seguimientoCollection;
    }

    public void setSeguimientoCollection(Collection<Seguimiento> seguimientoCollection) {
        this.seguimientoCollection = seguimientoCollection;
    }

    @XmlTransient
    public Collection<Hitos> getHitosCollection() {
        return hitosCollection;
    }

    public void setHitosCollection(Collection<Hitos> hitosCollection) {
        this.hitosCollection = hitosCollection;
    }

    @XmlTransient
    public Collection<PedidoMaterial> getPedidoMaterialCollection() {
        return pedidoMaterialCollection;
    }

    public void setPedidoMaterialCollection(Collection<PedidoMaterial> pedidoMaterialCollection) {
        this.pedidoMaterialCollection = pedidoMaterialCollection;
    }

    @XmlTransient
    public Collection<HistoricoProyecto> getHistoricoProyectoCollection() {
        return historicoProyectoCollection;
    }

    public void setHistoricoProyectoCollection(Collection<HistoricoProyecto> historicoProyectoCollection) {
        this.historicoProyectoCollection = historicoProyectoCollection;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proyecto[ id=" + id + " ]";
    }
    
}
