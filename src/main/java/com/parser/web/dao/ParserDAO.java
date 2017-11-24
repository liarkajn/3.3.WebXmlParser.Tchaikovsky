package main.java.com.parser.web.dao;

import main.java.com.parser.web.dao.exception.DAOException;
import main.java.com.parser.web.domain.Book;

import java.util.List;

public interface ParserDAO {

    List<Book> parse(String parserName) throws DAOException;

}
