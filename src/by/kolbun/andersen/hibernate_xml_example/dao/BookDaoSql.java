package by.kolbun.andersen.hibernate_xml_example.dao;

import by.kolbun.andersen.hibernate_xml_example.HibernateUtil;
import by.kolbun.andersen.hibernate_xml_example.entity.Author;
import by.kolbun.andersen.hibernate_xml_example.entity.Book;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDaoSql implements IDao {
    private Session session = HibernateUtil.getSession();
    private Transaction transaction;

    @Override
    public int add(Book t) {
        transaction = getTransaction();
        SQLQuery query = session.createSQLQuery("INSERT INTO `books` (title, ISBN) VALUES ('"
                + t.getTitle() + "', " + t.getISBN() + ");");
        query.executeUpdate();
        for (Author a : t.getAuthors()) {
            query = session.createSQLQuery("INSERT INTO `authors` (`name`, `age`, `status`) VALUES ('" +
                    a.getName() + "', " + a.getAge() + ", '" + a.getStatus() + "');");
            query.executeUpdate();
        }
        transaction.commit();
        return 1;
    }

    @Override
    public Book get(int id) {
        transaction = getTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM `books` WHERE `id` = " + id + ";");
        query.addEntity(Book.class);
        Object o = query.uniqueResult();
        transaction.commit();
        return (Book) o;
    }

    @Override
    public void update(Book t) {
        transaction = getTransaction();
        SQLQuery query = session.createSQLQuery("UPDATE books SET " +
                "`title` = '" + t.getTitle() +
                "', `ISBN` = " + t.getISBN() +
                " WHERE `id` = " + t.getId() + ";");
        query.executeUpdate();
        query = session.createSQLQuery("DELETE FROM `authors` WHERE `book_id` = " + t.getId() + ";");
        query.executeUpdate();
        for (Author a : t.getAuthors()) {
            query = session.createSQLQuery("INSERT INTO `authors` (`name`, `age`, `status`) VALUES ('+" +
                    a.getName() + "', " + a.getAge() + ", '" + a.getStatus() + "');");
            query.executeUpdate();
        }
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        transaction = getTransaction();
        SQLQuery query = session.createSQLQuery("DELETE FROM `books` WHERE `id` = " + id + ";");
        query.executeUpdate();
        transaction.commit();
    }

    private Transaction getTransaction() {
        if (transaction == null || !transaction.isActive()) return session.beginTransaction();
        return transaction;
    }

    @Override
    public List getAll() {
        /*List result;
        transaction = getTransaction();
        SQLQuery query = session.createSQLQuery("SELECT * FROM books;");
        result = query.list();
        return result;*/
//        return (List<Book>) session.createCriteria(Book.class).list();
        throw null;
    }

    @Override
    public void finish() {
        if (session != null && !session.isOpen()) session.close();
    }
}
