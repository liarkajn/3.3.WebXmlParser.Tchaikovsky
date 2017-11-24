package main.java.com.parser.web.service.impl;

import main.java.com.parser.web.dao.DAOFactory;
import main.java.com.parser.web.dao.ParserDAO;
import main.java.com.parser.web.dao.exception.DAOException;
import main.java.com.parser.web.domain.Book;
import main.java.com.parser.web.service.ParserService;
import main.java.com.parser.web.service.exception.ServiceException;

import java.util.List;

public class ParserServiceImpl implements ParserService {

    private final static String SERVICE_EXCEPTION_MESSAGE = "Sorry, something went wrong. We're working on getting this fixed as soon as possible";
    private ParserDAO parserDAO = DAOFactory.getInstance().getParserDAO();

    public List<Book> parse(String parserName) throws ServiceException {

        List<Book> books;
        try {
            books = parserDAO.parse(parserName);
        } catch (DAOException e) {
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }

        return books;
    }

}
