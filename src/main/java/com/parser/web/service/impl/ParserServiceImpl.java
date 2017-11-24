package main.java.com.parser.web.service.impl;

import main.java.com.parser.web.dao.DAOFactory;
import main.java.com.parser.web.dao.ParserDAO;
import main.java.com.parser.web.dao.exception.DAOException;
import main.java.com.parser.web.domain.Book;
import main.java.com.parser.web.domain.ResultSet;
import main.java.com.parser.web.service.ParserService;
import main.java.com.parser.web.service.exception.ServiceException;

import java.util.List;

public class ParserServiceImpl implements ParserService {

    private final static String SERVICE_EXCEPTION_MESSAGE = "Sorry, something went wrong. We're working on getting this fixed as soon as possible";
    private ParserDAO parserDAO = DAOFactory.getInstance().getParserDAO();

    public ResultSet parse(String parserName, int pageSize, int page) throws ServiceException {

        ResultSet resultSet = new ResultSet();
        try {
            List<Book> books = parserDAO.parse(parserName);
            resultSet.setTotalBooks(books.size());
            int to = page * pageSize;
            int from = to - pageSize;
            if (to > books.size()) {
                resultSet.setBookPage(books.subList(from, books.size()));
            } else {
                resultSet.setBookPage(books.subList(from, to));
            }
        } catch (DAOException e) {
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }
        return resultSet;
    }

}
