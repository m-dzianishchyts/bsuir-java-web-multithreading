package by.bsuir.web.multithreading.server.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

/**
 * Personnel Files
 *
 * <p>Java class for files complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="files"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="file" type="{https://www.businnes.by/archive/state/xml/types}file" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "files", propOrder = {
        "file"
})
public class PersonnelFiles {

    protected List<PersonnelFile> fileList;

    /**
     * Gets the value of the fileList property.
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonnelFile }
     */
    public List<PersonnelFile> getFileList() {
        if (fileList == null) {
            fileList = new ArrayList<>();
        }
        return fileList;
    }

    /**
     * Sets the value of the linkList property.
     */
    public void setFileList(List<PersonnelFile> value) {
        fileList = value;
    }
}
