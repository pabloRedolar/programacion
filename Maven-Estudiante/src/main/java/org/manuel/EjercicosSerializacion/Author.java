package org.manuel.EjercicosSerializacion;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class Author {
    private String name;
    private List<Book> ListaDeLibrosDelAuthor = null ;

    public Author() {
    }

    public Author(String name, List<Book> listaDeLibrosDelAuthor) {
        this.name = name;
        ListaDeLibrosDelAuthor = listaDeLibrosDelAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@XmlElement(name = "Libro")
    public List<Book> getListaDeLibrosDelAuthor() {
        return ListaDeLibrosDelAuthor;
    }

    public void setListaDeLibrosDelAuthor(List<Book> listaDeLibrosDelAuthor) {
        ListaDeLibrosDelAuthor = listaDeLibrosDelAuthor;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                "ListaDeLibrosDelAuthor=" + ListaDeLibrosDelAuthor +
                "}\n";
    }

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Manuel");
        List<Book> listaDeLibros = new ArrayList<>();
        Book book = new Book("SANJUANDEDIOS","kaka","2002");
        Book book1 = new Book("TORNER","kaktua","2005");
        listaDeLibros.add(book);
        listaDeLibros.add(book1);
        author.setListaDeLibrosDelAuthor(listaDeLibros);

        ObjectMapper objectMapper = new ObjectMapper();
        //Serializar Author a JSON
        /**try {
            String json = objectMapper.writeValueAsString(author);
            System.out.println(json);
            objectMapper.writeValue(new File("Author.json"), author);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Serializar Author a XML
        try {
            JAXBContext context = JAXBContext.newInstance(Author.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(author, new File("Author.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
