package org.manuel.EjercicosSerializacion;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BookTitleAdapter extends XmlAdapter<String, Book> {
    @Override
    public Book unmarshal(String s) throws Exception {
        Book libro = new Book();
        libro.setTitle(s);
        return libro;
    }

    @Override
    public String marshal(Book book) throws Exception {
        return book.getTitle();
    }
}
