package by.bsuir.web.multithreading.server.entity;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for gender.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="gender"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Male"/&gt;
 *     &lt;enumeration value="Female"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "gender")
@XmlEnum
public enum Gender {

    @XmlEnumValue("Male")
    MALE("Male"),
    @XmlEnumValue("Female")
    FEMALE("Female"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    Gender(String v) {
        value = v;
    }

    public static Gender fromValue(String value) throws IllegalArgumentException {
        for (Gender c : Gender.values()) {
            if (c.value.equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value);
    }

    public String value() {
        return value;
    }
}
