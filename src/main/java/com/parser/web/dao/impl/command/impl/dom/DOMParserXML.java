package main.java.com.parser.web.dao.impl.command.impl.dom;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import main.java.com.parser.web.dao.impl.command.Command;
import main.java.com.parser.web.domain.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.parser.web.dao.impl.XMLProperty.*;

public class DOMParserXML implements Command {

    @Override
    public List<Book> execute(String filePath) {

        List<Book> books = new ArrayList<>();

        try {
            DOMParser parser = new DOMParser();
            parser.parse(filePath);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList bookNodes = root.getElementsByTagName(BOOK_ELEMENT);
            Book book = null;
            for (int i = 0; i < bookNodes.getLength(); i ++) {
                book = new Book();
                Element bookElement = (Element) bookNodes.item(i);
                book.setId(bookElement.getAttribute(ID_ATTRIBUTE));
                book.setAuthor(getSingleChild(bookElement, AUTHOR_ELEMENT).getTextContent().trim());
                book.setTitle(getSingleChild(bookElement, TITLE_ELEMENT).getTextContent().trim());
                book.setGenre(getSingleChild(bookElement, GENRE_ELEMENT).getTextContent().trim());
                book.setPrice(getSingleChild(bookElement, PRICE_ELEMENT).getTextContent().trim());
                book.setPublish_date(getSingleChild(bookElement, PUBLISH_DATE_ELEMENT).getTextContent().trim());
                book.setDescription(getSingleChild(bookElement, DESCRIPTION_ELEMENT).getTextContent().trim());
                books.add(book);
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }

        return books;
    }

    private Element getSingleChild(Element element, String childElement) {
        NodeList nodeList = element.getElementsByTagName(childElement);
        Element child = (Element) nodeList.item(0);
        return child;
    }

}
