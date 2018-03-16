package by.kolbun.andersen.hibernate_xml_example.dao;

import by.kolbun.andersen.hibernate_xml_example.entity.Book;

import java.util.List;

public interface IDao {
    int add(Book t);

    Book get(int id);

    List<Book> getAll();

    void update(Book t);

    void delete(int id);

    void finish();
}
