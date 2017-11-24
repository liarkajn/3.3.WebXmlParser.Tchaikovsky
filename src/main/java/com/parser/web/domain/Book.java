package main.java.com.parser.web.domain;

import java.io.Serializable;

public class Book implements Serializable {

    private String id;
    private String author;
    private String title;
    private String genre;
    private String price;
    private String publish_date;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return 107 * (id.hashCode() +author.hashCode() + title.hashCode() +
                genre.hashCode() + price.hashCode() + publish_date.hashCode() +
                description.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        if (!super.equals(book)) {
            return false;
        }
        return (id.equals(book.id) && author.equals(book.author) && title.equals(book.title)
                && genre.equals(book.genre) && price.equals(book.price)
                && publish_date.equals(book.publish_date) && description.equals(book.description));
    }

    @Override
    public String toString() {
        return "id : " + id +
                "\nauthor : " + author +
                "\n1title : " + title +
                "\ngenre : " + genre +
                "\nprice : " + price +
                "\npublish date : " + publish_date +
                "\ndescription : " + description;
    }
}
