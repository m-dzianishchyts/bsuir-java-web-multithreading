package by.bsuir.web.multithreading.server.entity;

import by.bsuir.web.multithreading.server.entity.adapter.XmlLocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

/**
 * Personnel File
 *
 * <p>Java class for file complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="file"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="position" type="{https://www.businnes.by/archive/state/xml/minor}position"/&gt;
 *         &lt;element name="contacts" type="{https://www.businnes.by/archive/state/xml/minor}contacts"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{https://www.businnes.by/archive/state/xml/minor}personInfo"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "file", propOrder = {
        "position",
        "contacts"
})
public class PersonnelFile {

    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "firstName", required = true)
    protected String firstName;
    @XmlAttribute(name = "lastName", required = true)
    protected String lastName;
    @XmlAttribute(name = "gender", required = true)
    protected Gender gender;
    @XmlAttribute(name = "birthDate", required = true)
    @XmlJavaTypeAdapter(value = XmlLocalDateAdapter.class)
    protected LocalDate birthDate;
    @XmlElement(required = true)
    protected Position position;
    @XmlElement(required = true)
    protected Contacts contacts;

    /**
     * Gets the value of the position property.
     *
     * @return possible object is {@link Position }
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     *
     * @param value allowed object is {@link Position }
     */
    public void setPosition(Position value) {
        this.position = value;
    }

    /**
     * Gets the value of the contacts property.
     *
     * @return possible object is {@link Contacts }
     */
    public Contacts getContacts() {
        return contacts;
    }

    /**
     * Sets the value of the contacts property.
     *
     * @param value allowed object is {@link Contacts }
     */
    public void setContacts(Contacts value) {
        this.contacts = value;
    }

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return possible object is {@link String }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     *
     * @return possible object is {@link String }
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the gender property.
     *
     * @return possible object is {@link Gender }
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     *
     * @param value allowed object is {@link Gender }
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the birthDate property.
     *
     * @return possible object is {@link LocalDate }
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     *
     * @param value allowed object is {@link LocalDate }
     */
    public void setBirthDate(LocalDate value) {
        this.birthDate = value;
    }
}
