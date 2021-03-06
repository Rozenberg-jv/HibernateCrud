package by.kolbun.andersen.hibernate_xml_example.entity;

import java.util.List;

public class Book {
    private Integer id;
    private String title;
    private int ISBN;

    private List<Author> authors;

    public Book() {
    }

    public Book(String title, int isbn, List<Author> authors) {
        this.title = title;
        this.ISBN = isbn;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t>").append(this.getClass().getSimpleName()).append(" [").append(Integer.toHexString(this.hashCode()))
                .append("] id: ").append(id).append(", title: ").append(title).append(", ISBN: ")
                .append(ISBN).append("\n\t\t>Authors:\n");
        if (authors == null || authors.isEmpty()) sb.append("\t\t-null or empty-");
        else
            for (Author a : authors) {
                sb.append(a).append("\n");
            }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (ISBN != book.ISBN) return false;
        if (!id.equals(book.id)) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return authors != null ? authors.equals(book.authors) : book.authors == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + ISBN;
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }
}
