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

    IDao dao;

    public void execCritariaDaoExample() {
        dao = new BookDaoCriteria();
        List<Author> list = new ArrayList<>();
//        list.add(new Author("Liza Alekseeva", 41, "woman"));
//        list.add(new Author("Alexey Elizavetov", 30, "man"));
//        list.add(new Author("Vasily Petrov", 35, "M.D."));
//        list.add(new Author("Petr Vasiliev", 45, "Ph.D."));

        list.add(new Author("Igor Anreev", 25, "writer"));
        list.add(new Author("Andrew Igorev", 51, "reader"));
        list.add(new Author("Semen Semenov", 26, "artist"));
        Book book = new Book("title2", 12303, list);
        dao.add(book);
        System.out.println(" :>> Print all records: ");
        List<Book> all = dao.getAll();
        for (Book b : all) {
            System.out.println(b);
        }
//        book.setTitle("updated");
//        dao.update(book);
//        list.remove(0);
//        list.remove(1);
        List list2 = new ArrayList();
        list2.add(new Author("Alenas Pupkins", 29, "she"));
        book.setAuthors(list2);
        dao.update(book);
        System.out.println(" :>> Print all records: ");
        all = dao.getAll();
        for (Book b : all) {
            System.out.println(b);
        }

//        dao.delete(book.getId());
        dao.finish();
    }
}
