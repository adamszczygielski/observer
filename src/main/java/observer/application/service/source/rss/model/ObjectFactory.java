//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.23 at 02:29:15 PM CEST 
//


package observer.application.service.source.rss.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the observer.application.service.source.rss.model package. 
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

    private final static QName _Rss_QNAME = new QName("", "rss");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: observer.application.service.source.rss.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Rss }
     * 
     */
    public Rss createRss() {
        return new Rss();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link SkipHours }
     * 
     */
    public SkipHours createSkipHours() {
        return new SkipHours();
    }

    /**
     * Create an instance of {@link Channel }
     * 
     */
    public Channel createChannel() {
        return new Channel();
    }

    /**
     * Create an instance of {@link Source }
     * 
     */
    public Source createSource() {
        return new Source();
    }

    /**
     * Create an instance of {@link SkipDays }
     * 
     */
    public SkipDays createSkipDays() {
        return new SkipDays();
    }

    /**
     * Create an instance of {@link Cloud }
     * 
     */
    public Cloud createCloud() {
        return new Cloud();
    }

    /**
     * Create an instance of {@link TextInput }
     * 
     */
    public TextInput createTextInput() {
        return new TextInput();
    }

    /**
     * Create an instance of {@link Enclosure }
     * 
     */
    public Enclosure createEnclosure() {
        return new Enclosure();
    }

    /**
     * Create an instance of {@link Guid }
     * 
     */
    public Guid createGuid() {
        return new Guid();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
//    public Category createCategory() {
//        return new Category();
//    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rss }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rss")
    public JAXBElement<Rss> createRss(Rss value) {
        return new JAXBElement<Rss>(_Rss_QNAME, Rss.class, null, value);
    }

}