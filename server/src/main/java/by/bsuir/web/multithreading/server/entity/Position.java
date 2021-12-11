package by.bsuir.web.multithreading.server.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for position complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="position"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attGroup ref="{https://www.businnes.by/archive/state/xml/minor}positionInfo"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "position")
public class Position {

    @XmlAttribute(name = "division", required = true)
    protected String division;
    @XmlAttribute(name = "title", required = true)
    protected String title;

    /**
     * Gets the value of the division property.
     *
     * @return possible object is {@link String }
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return possible object is {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }
}
