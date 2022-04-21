//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.04.19 a las 12:48:20 PM CDT 
//


package https.actss_uv_mx.lista;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.actss_uv_mx.lista package. 
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

    private final static QName _MostrarListaRequest_QNAME = new QName("https://actss.uv.mx/lista", "MostrarListaRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.actss_uv_mx.lista
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MostrarListaResponse }
     * 
     */
    public MostrarListaResponse createMostrarListaResponse() {
        return new MostrarListaResponse();
    }

    /**
     * Create an instance of {@link ListaRequest }
     * 
     */
    public ListaRequest createListaRequest() {
        return new ListaRequest();
    }

    /**
     * Create an instance of {@link ListaResponse }
     * 
     */
    public ListaResponse createListaResponse() {
        return new ListaResponse();
    }

    /**
     * Create an instance of {@link MostrarListaResponse.Lista }
     * 
     */
    public MostrarListaResponse.Lista createMostrarListaResponseLista() {
        return new MostrarListaResponse.Lista();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://actss.uv.mx/lista", name = "MostrarListaRequest")
    public JAXBElement<Object> createMostrarListaRequest(Object value) {
        return new JAXBElement<Object>(_MostrarListaRequest_QNAME, Object.class, null, value);
    }

}
