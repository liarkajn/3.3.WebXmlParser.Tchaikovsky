package main.java.com.parser.web.service;

import main.java.com.parser.web.domain.ResultSet;
import main.java.com.parser.web.service.exception.ServiceException;

public interface ParserService {

    ResultSet parse(String parserName, int pageSize, int page) throws ServiceException;

}
