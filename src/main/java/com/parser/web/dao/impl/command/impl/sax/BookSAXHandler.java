package main.java.com.parser.web.dao.impl.command.impl.sax;

import main.java.com.parser.web.domain.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.parser.web.dao.impl.XMLProperty.*;

public class BookSAXHandler extends DefaultHandler {

    private List<Book> books = new ArrayList<>();
    private Book book;
    private StringBuilder text;

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if(qName.equals(BOOK_ELEMENT)) {
            book = new Book();
            book.setId(attributes.getValue(ID_ATTRIBUTE));
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case AUTHOR_ELEMENT:
                book.setAuthor(text.toString());
                break;
            case TITLE_ELEMENT:
                book.setTitle(text.toString());
                break;
            case GENRE_ELEMENT:
                book.setGenre(text.toString());
                break;
            case PRICE_ELEMENT:
                book.setPrice(text.toString());
                break;
            case PUBLISH_DATE_ELEMENT:
                book.setPublish_date(text.toString());
                break;
            case DESCRIPTION_ELEMENT:
                book.setDescription(text.toString());
                break;
            case BOOK_ELEMENT:
                books.add(book);
                book = null;
                break;
        }
    }
}
