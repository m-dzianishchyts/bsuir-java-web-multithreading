module by.bsuir.web.multithreading.client {
    requires jakarta.xml.bind;
    requires org.apache.logging.log4j;
    requires by.bsuir.web.multithreading.common;

    opens by.bsuir.web.multithreading.server.entity to jakarta.xml.bind;
}