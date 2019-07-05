
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MostrarTodasInspeccionesResponse_QNAME = new QName("http://Service/", "MostrarTodasInspeccionesResponse");
    private final static QName _MostrarTodasInspecciones_QNAME = new QName("http://Service/", "MostrarTodasInspecciones");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MostrarTodasInspeccionesResponse }
     * 
     */
    public MostrarTodasInspeccionesResponse createMostrarTodasInspeccionesResponse() {
        return new MostrarTodasInspeccionesResponse();
    }

    /**
     * Create an instance of {@link MostrarTodasInspecciones }
     * 
     */
    public MostrarTodasInspecciones createMostrarTodasInspecciones() {
        return new MostrarTodasInspecciones();
    }

    /**
     * Create an instance of {@link Inspeccion }
     * 
     */
    public Inspeccion createInspeccion() {
        return new Inspeccion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarTodasInspeccionesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "MostrarTodasInspeccionesResponse")
    public JAXBElement<MostrarTodasInspeccionesResponse> createMostrarTodasInspeccionesResponse(MostrarTodasInspeccionesResponse value) {
        return new JAXBElement<MostrarTodasInspeccionesResponse>(_MostrarTodasInspeccionesResponse_QNAME, MostrarTodasInspeccionesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarTodasInspecciones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Service/", name = "MostrarTodasInspecciones")
    public JAXBElement<MostrarTodasInspecciones> createMostrarTodasInspecciones(MostrarTodasInspecciones value) {
        return new JAXBElement<MostrarTodasInspecciones>(_MostrarTodasInspecciones_QNAME, MostrarTodasInspecciones.class, null, value);
    }

}
