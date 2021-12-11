package by.bsuir.web.multithreading.server.entity;

import by.bsuir.web.multithreading.server.entity.validation.StateValidation;
import by.bsuir.web.multithreading.server.entity.validation.StateValidationException;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for contacts complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="contacts"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="email" type="{https://www.businnes.by/archive/state/xml/minor}email"/&gt;
 *         &lt;element name="phone" type="{https://www.businnes.by/archive/state/xml/minor}phone"/&gt;
 *         &lt;element name="contactLinks" type="{https://www.businnes.by/archive/state/xml/minor}contactLinks" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contacts", propOrder = {

})
public class Contacts {

    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String phone;
    protected ContactLinks contactLinks;

    /**
     * Gets the value of the email property.
     *
     * @return possible object is {@link String }
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param email allowed object is {@link String }
     * @throws StateValidationException if an email is not valid
     */
    public void setEmail(String email) throws StateValidationException {
        StateValidation.validateEmail(email);
        this.email = email;
    }

    /**
     * Gets the value of the phone property.
     *
     * @return possible object is {@link String }
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     *
     * @param phoneNumber allowed object is {@link String }
     * @throws StateValidationException if provided phone number is not valid
     */
    public void setPhone(String phoneNumber) throws StateValidationException {
        StateValidation.validatePhoneNumber(phoneNumber);
        this.phone = phoneNumber;
    }

    /**
     * Gets the value of the contactLinks property.
     *
     * @return possible object is {@link ContactLinks }
     */
    public ContactLinks getContactLinks() {
        return contactLinks;
    }

    /**
     * Sets the value of the contactLinks property.
     *
     * @param value allowed object is {@link ContactLinks }
     */
    public void setContactLinks(ContactLinks value) {
        this.contactLinks = value;
    }
}
