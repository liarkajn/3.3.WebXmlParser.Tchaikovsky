package main.java.com.parser.web.service;

import main.java.com.parser.web.domain.Book;
import main.java.com.parser.web.service.exception.ServiceException;

import java.util.List;

public interface ParserService {

    List<Book> parse(String parserName) throws ServiceException;

}
