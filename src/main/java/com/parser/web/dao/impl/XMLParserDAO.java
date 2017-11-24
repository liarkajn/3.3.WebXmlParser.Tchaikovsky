package main.java.com.parser.web.dao.impl;

import main.java.com.parser.web.dao.ParserDAO;
import main.java.com.parser.web.dao.exception.DAOException;
import main.java.com.parser.web.dao.impl.command.Command;
import main.java.com.parser.web.dao.impl.command.CommandProvider;
import main.java.com.parser.web.domain.Book;

import java.net.URL;
import java.util.List;

public class XMLParserDAO implements ParserDAO {

    private final static String FILE_NAME = "books.xml";
    private final static String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "File not found";

    public List<Book> parse(String parserName) throws DAOException {

        URL url = getClass().getClassLoader().getResource(FILE_NAME);
        if (url == null) {
            throw new DAOException(FILE_NOT_FOUND_EXCEPTION_MESSAGE);
        }

        String filePath = url.toString();
        CommandProvider commandProvider = new CommandProvider();
        Command command = commandProvider.takeParser(parserName);
        return command.execute(filePath);
    }

}
