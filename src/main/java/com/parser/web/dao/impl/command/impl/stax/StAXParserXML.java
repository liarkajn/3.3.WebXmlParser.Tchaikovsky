package main.java.com.parser.web.dao.impl.command.impl.stax;

import main.java.com.parser.web.dao.exception.DAOException;
import main.java.com.parser.web.dao.impl.command.Command;
import main.java.com.parser.web.domain.Book;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.parser.web.dao.impl.XMLProperty.*;

public class StAXParserXML implements Command {

    private final static String XML_STREAM_READER_ERROR_MESSAGE = "Cannot create XML stream reader";
    private List<Book> books = new ArrayList<>();
    private Book book = null;
    private String elementName = null;

    @Override
    public List<Book> execute(String filePath) throws DAOException {
        List<Book> books;
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("books.xml");
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            books = process(reader);
        } catch (XMLStreamException e) {
            throw new DAOException(XML_STREAM_READER_ERROR_MESSAGE, e);
        }

        return books;
    }

    private List<Book> process(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    handleStartElement(reader);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    handleCharacters(reader);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    handleEndElement(reader);
                    break;
            }
        }
        return books;
    }

    private void handleStartElement(XMLStreamReader reader) {
        elementName = reader.getLocalName();
        switch (elementName) {
            case BOOK_ELEMENT:
                book = new Book();
                String id = reader.getAttributeValue(null, ID_ATTRIBUTE);
                book.setId(id);
                break;
        }
    }

    private void handleEndElement(XMLStreamReader reader) {
        elementName = reader.getLocalName();
        switch (elementName) {
            case BOOK_ELEMENT:
                books.add(book);
                break;
        }
    }

    private void handleCharacters(XMLStreamReader reader) {
        String text = reader.getText().trim();
        if (text.isEmpty()) {
            return;
        }
        switch (elementName) {
            case AUTHOR_ELEMENT:
                book.setAuthor(text);
                break;
            case TITLE_ELEMENT:
                book.setTitle(text);
                break;
            case GENRE_ELEMENT:
                book.setGenre(text);
                break;
            case PRICE_ELEMENT:
                book.setPrice(text);
                break;
            case PUBLISH_DATE_ELEMENT:
                book.setPublish_date(text);
                break;
            case DESCRIPTION_ELEMENT:
                book.setDescription(text);
                break;
        }
    }

}
