package by.bsuir.web.multithreading.server.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for contactLinks complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="contactLinks"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contactLinks", propOrder = {
        "link"
})
public class ContactLinks {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected List<String> linkList;

    /**
     * Gets the value of the linkList property.
     * <p>
     * Objects of the following type(s) are allowed in the list: {@link String }
     */
    public List<String> getLinkList() {
        if (linkList == null) {
            linkList = new ArrayList<>();
        }
        return linkList;
    }

    /**
     * Sets the value of the linkList property.
     */
    public void setLinkList(List<String> value) {
        linkList = value;
    }
}
