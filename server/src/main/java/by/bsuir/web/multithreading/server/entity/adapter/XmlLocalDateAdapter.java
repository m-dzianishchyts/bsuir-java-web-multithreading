package by.bsuir.web.multithreading.server.entity.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class XmlLocalDateAdapter extends XmlAdapter<XMLGregorianCalendar, LocalDate> {

    @Override
    public LocalDate unmarshal(XMLGregorianCalendar xmlGregorianCalendar) {
        int year = xmlGregorianCalendar.getYear();
        int month = xmlGregorianCalendar.getMonth();
        int day = xmlGregorianCalendar.getDay();
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    @Override
    public XMLGregorianCalendar marshal(LocalDate localDate) {
        String localDateLexical = localDate.toString();
        DatatypeFactory datatypeFactory = DatatypeFactory.newDefaultInstance();
        XMLGregorianCalendar xmlGregorianCalendar = datatypeFactory.newXMLGregorianCalendar(localDateLexical);
        return xmlGregorianCalendar;
    }
}
