module server {
    requires jakarta.xml.bind;
    requires org.apache.logging.log4j;

    opens by.bsuir.web.multithreading.server.entity to jakarta.xml.bind;
}