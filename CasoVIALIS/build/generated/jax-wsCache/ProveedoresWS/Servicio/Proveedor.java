
package Servicio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para proveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="proveedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="direccionProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="especialidadProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProveedor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rutProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proveedor", propOrder = {
    "direccionProveedor",
    "especialidadProveedor",
    "idProveedor",
    "nombreProveedor",
    "rutProveedor"
})
public class Proveedor {

    protected String direccionProveedor;
    protected String especialidadProveedor;
    protected int idProveedor;
    protected String nombreProveedor;
    protected String rutProveedor;

    /**
     * Obtiene el valor de la propiedad direccionProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    /**
     * Define el valor de la propiedad direccionProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionProveedor(String value) {
        this.direccionProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad especialidadProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspecialidadProveedor() {
        return especialidadProveedor;
    }

    /**
     * Define el valor de la propiedad especialidadProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspecialidadProveedor(String value) {
        this.especialidadProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idProveedor.
     * 
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * Define el valor de la propiedad idProveedor.
     * 
     */
    public void setIdProveedor(int value) {
        this.idProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Define el valor de la propiedad nombreProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProveedor(String value) {
        this.nombreProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad rutProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutProveedor() {
        return rutProveedor;
    }

    /**
     * Define el valor de la propiedad rutProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutProveedor(String value) {
        this.rutProveedor = value;
    }

}
