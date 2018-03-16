package by.kolbun.andersen.hibernate_xml_example;


import by.kolbun.andersen.hibernate_xml_example.dao.BookDaoCriteria;
import by.kolbun.andersen.hibernate_xml_example.dao.BookDaoHql;
import by.kolbun.andersen.hibernate_xml_example.dao.BookDaoSql;
import by.kolbun.andersen.hibernate_xml_example.dao.IDao;
import by.kolbun.andersen.hibernate_xml_example.entity.Author;
import by.kolbun.andersen.hibernate_xml_example.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class HibernateXmlExample {

    BookDaoCriteria dao;

    public void execCritariaDaoExample() {
        dao = new BookDaoCriteria();
        List<Author> list = new ArrayList<>();
//        list.add(new Author("Liza Alekseeva", 41, "woman"));
//        list.add(new Author("Alexey Elizavetov", 30, "man"));
//        list.add(new Author("Vasily Petrov", 35, "M.D."));
//        list.add(new Author("Petr Vasiliev", 45, "Ph.D."));

        /*list.add(new Author("Igor Anreev", 25, "writer"));
        list.add(new Author("Andrew Igorev", 51, "reader"));
        list.add(new Author("Semen Semenov", 26, "artist"));
        Book book = new Book("title2", 12304, list);
        dao.add(book);*/
//        System.out.println(" :>> Print all records: ");
//        List<Book> all = dao.getAll();
//        for (Book b : all) {
//            System.out.println(b);
//        }

        /*Book book = dao.get(17);
        book.setISBN(132);
        list.add(new Author("q", 1, "w"));
        book.setAuthors(list);
        Book book2 = dao.get(17);
//        dao.update(book);
        System.out.println(book);
        System.out.println(book2);*/

        list.add(new Author("new", 111, "new"));
//        list.add(new Author("t2", 3, "b2"));
        Book newbook = new Book("new", 13333, list);
        newbook.setId(17);

        dao.update(newbook);

//        dao.delete(17);
//        dao.getAllAuthors().forEach(System.out::println);
        dao.finish();
    }
}
