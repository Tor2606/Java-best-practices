package SaxParserSample;

import com.google.common.base.Joiner;

import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


public class Book {
    private String id;
    private String lang;
    private String isbn;
    private Date regDate;
    private String title;
    private String publisher;
    private int price;
    private List<String> authors;
    public Book(){
        authors = newArrayList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book:" + Joiner.on(", ").join("Authors" + this.getAuthors(), this.getId(), this.getTitle(), this.getIsbn(), this.getPrice());
    }
}
