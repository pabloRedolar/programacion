package org.manuel.EjercicosSerializacion;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Publisher {
    private String name;
    private String address;
    private List<Book> listaDeLibros = null;

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
@XmlElement(name = "Libro")
@XmlJavaTypeAdapter(BookTitleAdapter.class)
    public List<Book> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Book> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    @JsonGetter("listaDeLibros")
    public List<String> getBookTitle() {
        List<String> listaTitulos = new ArrayList<>();
        for (Book libro : listaDeLibros) {
            String titulo = libro.getTitle();
            listaTitulos.add(titulo);
        }
        return listaTitulos;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", listaDeLibros=" + listaDeLibros +
                '}';
    }


    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.setAddress("casaputas");
        publisher.setName("Angel");
        List<Book> listaDelibros = new ArrayList<>();
        Book book = new Book("mamaita", "torner", "2005");
        Book book1 = new Book("remonesEsGay", "Remones", "2005");
        listaDelibros.add(book);
        listaDelibros.add(book1);
        publisher.setListaDeLibros(listaDelibros);


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(publisher);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Publisher.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(publisher, new File("Publisher.xml"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
