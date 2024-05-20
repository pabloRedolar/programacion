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
public class BookStore {
    private List<Author> Lista_De_Autores = null;
    private List<Book> Lista_De_Libros = null;

    public BookStore() {
    }

    public BookStore(List<Author> lista_De_Autores, List<Book> lista_De_Libros) {
        Lista_De_Autores = lista_De_Autores;
        Lista_De_Libros = lista_De_Libros;
    }
    @XmlElement(name = "Author")
    public List<Author> getLista_De_Autores() {
        return Lista_De_Autores;
    }

    public void setLista_De_Autores(List<Author> lista_De_Autores) {
        Lista_De_Autores = lista_De_Autores;
    }

    @XmlElement(name = "Libro")
    public List<Book> getLista_De_Libros() {
        return Lista_De_Libros;
    }

    public void setLista_De_Libros(List<Book> lista_De_Libros) {
        Lista_De_Libros = lista_De_Libros;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "Lista_De_Autores=" + Lista_De_Autores +
                "Lista_De_Libros=" + Lista_De_Libros +
                '}';
    }

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        Author author = new Author();
        author.setName("MANUEL");
        List<Book> ListaDeLibrosParaElAuthor = new ArrayList<>();
        Book book = new Book("KAKADIVACA", "NACHO","2005");
        Book book1 = new Book("MACARENA", "JUANDEDIOS","2000");
        ListaDeLibrosParaElAuthor.add(book);
        ListaDeLibrosParaElAuthor.add(book1);
        author.setListaDeLibrosDelAuthor(ListaDeLibrosParaElAuthor);

        Author author1 = new Author();
        author1.setName("REMONES");
        List<Book> ListaDeLibrosParaElAuthor1 = new ArrayList<>();
        Book book2 = new Book("MORENA", "KACHONDA","2005");
        Book book3 = new Book("lAUUUURUA", "REDOLARESGAY","2000");
        ListaDeLibrosParaElAuthor1.add(book2);
        ListaDeLibrosParaElAuthor1.add(book3);
        author1.setListaDeLibrosDelAuthor(ListaDeLibrosParaElAuthor1);

        List<Author> ListaDeAutores = new ArrayList<>();
        ListaDeAutores.add(author);
        ListaDeAutores.add(author1);

        bookStore.setLista_De_Autores(ListaDeAutores);

        List<Book> ListaDeLibrosParaElBookStore = new ArrayList<>();
        ListaDeLibrosParaElBookStore.add(book);
        ListaDeLibrosParaElBookStore.add(book1);
        ListaDeLibrosParaElBookStore.add(book2);
        ListaDeLibrosParaElBookStore.add(book3);
        bookStore.setLista_De_Libros(ListaDeLibrosParaElBookStore);

        ObjectMapper objectMapper = new ObjectMapper();
        /**try {
            String json = objectMapper.writeValueAsString(bookStore);
            objectMapper.writeValue(new File("BookStore.json"), json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookStore, new File("BookStore.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
