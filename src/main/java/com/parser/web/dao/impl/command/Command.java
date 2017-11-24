package main.java.com.parser.web.dao.impl.command;

import main.java.com.parser.web.dao.exception.DAOException;
import main.java.com.parser.web.domain.Book;

import java.util.List;

public interface Command {

    List<Book> execute(String filePath) throws DAOException;

}
