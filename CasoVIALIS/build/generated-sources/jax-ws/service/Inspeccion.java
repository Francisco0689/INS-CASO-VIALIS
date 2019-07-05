
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para inspeccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="inspeccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idInspeccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rutaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inspeccion", propOrder = {
    "idInspeccion",
    "nombreDocumento",
    "rutaDocumento",
    "tipoDocumento"
})
public class Inspeccion {

    protected int idInspeccion;
    protected String nombreDocumento;
    protected String rutaDocumento;
    protected String tipoDocumento;

    /**
     * Obtiene el valor de la propiedad idInspeccion.
     * 
     */
    public int getIdInspeccion() {
        return idInspeccion;
    }

    /**
     * Define el valor de la propiedad idInspeccion.
     * 
     */
    public void setIdInspeccion(int value) {
        this.idInspeccion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    /**
     * Define el valor de la propiedad nombreDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDocumento(String value) {
        this.nombreDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRutaDocumento() {
        return rutaDocumento;
    }

    /**
     * Define el valor de la propiedad rutaDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRutaDocumento(String value) {
        this.rutaDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

}
