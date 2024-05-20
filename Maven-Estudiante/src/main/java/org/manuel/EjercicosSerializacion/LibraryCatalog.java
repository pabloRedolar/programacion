package org.manuel.EjercicosSerializacion;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement
public class LibraryCatalog {
    private Map<Author,Book> catalog;

    public LibraryCatalog() {

    }
    @JsonAnyGetter

    public Map<String, String> getCatalog() {
        Map<String,String> catalogoModificado = new HashMap<>();
        for (Map.Entry<Author, Book> entrada : catalog.entrySet()){
            String nombreAutor = entrada.getKey().getName();
            String nombreLibro = entrada.getValue().getTitle();
            catalogoModificado.put(nombreAutor,nombreLibro);
        }
        return catalogoModificado;
    }

    public void setCatalog(Map<Author, Book> catalog) {
        this.catalog = catalog;
    }
    @XmlElement
    @XmlJavaTypeAdapter(CatalogoAdapter.class)
    public Map<Author,Book> getCatalogo(){
        return null;
    }

    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        Author author = new Author();
        author.setName("Palomo");
        Author author1 = new Author();
        author.setName("Paloma");
        Book book = new Book();
        book.setTitle("Kaka");
        Book book1 = new Book();
        book1.setTitle("Kaka2");
        author.setListaDeLibrosDelAuthor(Arrays.asList(book,book1));
        Map<Author,Book> catalogo = new HashMap<>();
        catalogo.put(author,book);
        //catalogo.put(author1,book1);
        libraryCatalog.setCatalog(catalogo);



        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(libraryCatalog);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        try {
            JAXBContext context = JAXBContext.newInstance(LibraryCatalog.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libraryCatalog, new File("LibraryCatalog.xml"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
