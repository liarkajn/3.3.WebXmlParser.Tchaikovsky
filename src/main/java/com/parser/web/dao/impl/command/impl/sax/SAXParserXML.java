package main.java.com.parser.web.dao.impl.command.impl.sax;

import main.java.com.parser.web.dao.impl.command.Command;
import main.java.com.parser.web.domain.Book;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.util.List;

public class SAXParserXML implements Command {

    @Override
    public List<Book> execute(String filePath) {

        try {

            XMLReader reader = XMLReaderFactory.createXMLReader();
            BookSAXHandler handler = new BookSAXHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(filePath));
            return handler.getBooks();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
