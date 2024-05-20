package org.manuel.EjercicosSerializacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@XmlRootElement
public class Book {
    private String title;
    private String author;
    private String YearPublished;

    public Book() {
    }

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.YearPublished = yearPublished;
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublished() {
        return YearPublished;
    }

    public void setYearPublished(String yearPublished) {
        YearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", YearPublished='" + YearPublished + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("Manuel");
        book.setTitle("TuMAMA");
        book.setYearPublished("2005");
        ObjectMapper objectMapper = new ObjectMapper();

        /** Serializar Book
        try {
            String json = objectMapper.writeValueAsString(book);
            System.out.println(json);
            objectMapper.writeValue(new File("book.json"), book);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //DesSerializar Book
        /**try {
            Book book1 = objectMapper.readValue(new File("book.json"), Book.class);
            System.out.println(book1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //SerializarXML
        /**try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(book, new File("LibroXML.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }*/
        //DeserializarXML
        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Book libro = (Book) unmarshaller.unmarshal(new File("LibroXML.xml"));
            System.out.println(libro);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
