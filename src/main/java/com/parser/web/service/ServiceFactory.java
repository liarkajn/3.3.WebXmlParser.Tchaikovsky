package main.java.com.parser.web.service;

import main.java.com.parser.web.service.impl.ParserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ParserService parserService = new ParserServiceImpl();

    private ServiceFactory() { }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ParserService getParserService() {
        return parserService;
    }

}
