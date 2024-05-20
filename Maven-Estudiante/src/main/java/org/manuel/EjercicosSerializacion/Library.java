package org.manuel.EjercicosSerializacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Library{

    private List<Book> lista_de_Libros = null;

    public Library() {
    }
    @XmlElement(name = "libro")
    public List<Book> getLista_de_Libros() {
        return lista_de_Libros;
    }

    public void setLista_de_Libros(List<Book> lista_de_Libros) {
        this.lista_de_Libros = lista_de_Libros;
    }

    @Override
    public String toString() {
        return "Library{" +
                "lista_de_Libros=" + lista_de_Libros +
                '}';
    }

    public static void main(String[] args) {
        List<Book> listaLibros = new ArrayList<>();
        Library library = new Library();
        Book book = new Book();
        Book book1 = new Book();
        book.setTitle("KAKA");
        book.setAuthor("REMONES");
        book.setYearPublished("2006");
        book1.setTitle("MAMA");
        book1.setAuthor("JUANES");
        book1.setYearPublished("2005");
        listaLibros.add(book);
        listaLibros.add(book1);
        library.setLista_de_Libros(listaLibros);
        ObjectMapper objectMapper = new ObjectMapper();

        //Serializar Libreria
        /**
        try {
            String json = objectMapper.writeValueAsString(library);
            System.out.println(json);
            objectMapper.writeValue(new File("library.json"), library);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //DesSerializar Libreria
        /**try {
            Library library1 = objectMapper.readValue(new File("library.json"), Library.class);
            System.out.println(library1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //SerializarXML con una lista
        /**try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(library, new File("LibreriaXML.xml"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }*/

        ////DeserializarXML con una lista
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Library library1 = (Library) unmarshaller.unmarshal(new File("LibreriaXML.xml"));
            System.out.println(library1);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
