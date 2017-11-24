package main.java.com.parser.web.dao;

import main.java.com.parser.web.dao.impl.XMLParserDAO;

public class DAOFactory {

    private final static DAOFactory instance = new DAOFactory();

    private ParserDAO parserDAO = new XMLParserDAO();

    private DAOFactory() { }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ParserDAO getParserDAO() {
        return parserDAO;
    }

}
