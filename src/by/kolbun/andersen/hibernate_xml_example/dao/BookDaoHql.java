package by.kolbun.andersen.hibernate_xml_example.dao;

import by.kolbun.andersen.hibernate_xml_example.HibernateUtil;
import by.kolbun.andersen.hibernate_xml_example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDaoHql implements IDao {
    private Session session = HibernateUtil.getSession();
    private Transaction transaction;

    @Override
    public int add(Book t) {
        transaction = getTransaction();
//        Query query = session.createQuery("insert into books (title, ISBN)");
        transaction.commit();
        return 1;
    }

    @Override
    public Book get(int id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void update(Book t) {
            }

    @Override
    public void delete(int id) {

    }

    private Transaction getTransaction() {
        if (transaction == null || !transaction.isActive()) return session.beginTransaction();
        return transaction;
    }

    @Override
    public void finish() {
        if (session != null && !session.isOpen()) session.close();
    }
}
