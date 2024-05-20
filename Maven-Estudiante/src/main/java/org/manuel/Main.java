package org.manuel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.manuel.modelos.Coche;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Coche coche1 = new Coche();
        coche1.setMarca("BMW");
        coche1.setModelo("320d");
        coche1.setColor("Negro");
        coche1.setMatricula("7777MMM");
        //System.out.println(coche1.toString());
        ObjectMapper objectMapper = new ObjectMapper();

        /**try {
            String json = objectMapper.writeValueAsString(coche1);
            System.out.println(json);
            objectMapper.writeValue(new File("coche1.json"), coche1);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } */

        //Desserializar


        /** try {
            Coche micoche = objectMapper.readValue(new File("coche1.json"), Coche.class);
            System.out.println(micoche);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        //Serializar XML
        /**try {
            JAXBContext context = JAXBContext.newInstance(Coche.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            //imprimimos por pantalla
            marshaller.marshal(coche1, new File("cocheXML.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }*/

        //Deserializar XML

        try {
            File archivo = new File("cocheXML.xml");
            JAXBContext context = JAXBContext.newInstance(Coche.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Coche coche = (Coche) unmarshaller.unmarshal(archivo);
            System.out.println(coche);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}