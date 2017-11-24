package main.java.com.parser.web.controller.command.impl;

import main.java.com.parser.web.controller.command.Command;
import main.java.com.parser.web.domain.ResultSet;
import main.java.com.parser.web.service.ParserService;
import main.java.com.parser.web.service.ServiceFactory;
import main.java.com.parser.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParserCommand implements Command {

    private final static String COMMAND_FIELD_NAME = "command";
    private final static String COMMAND_FIELD_VALUE = "parser";
    private final static String PARSER_TYPE_NAME = "parserType";
    private final static String PAGE_NUMBER_NAME = "page";
    private final static String TOTAL_PAGES_NUMBER_NAME = "totalPages";
    private final static String BOOK_LIST_NAME = "bookList";
    private final static String ERROR_MESSAGE_NAME = "errorMessage";
    private final static String MAIN_PAGE = "/WEB-INF/page/main.jsp" ;
    private final static String ERROR_PAGE = "/WEB-INF/page/error.jsp" ;
    private final static int ITEMS_PER_PAGE = 3;
    private final static int DEFAULT_PAGE_NUMBER = 1;
    private ParserService parserService = ServiceFactory.getInstance().getParserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parserType = request.getParameter(PARSER_TYPE_NAME);
        String pageNumberParameter = request.getParameter(PAGE_NUMBER_NAME);
        int pageNumber = pageNumberParameter != null ? Integer.valueOf(pageNumberParameter) : DEFAULT_PAGE_NUMBER;
        try {
            ResultSet resultSet = parserService.parse(parserType, ITEMS_PER_PAGE, pageNumber);
            int totalPages = resultSet.getTotalBooks() / ITEMS_PER_PAGE;
            if (resultSet.getTotalBooks() % ITEMS_PER_PAGE != 0) {
                totalPages++;
            }
            request.setAttribute(BOOK_LIST_NAME, resultSet.getBookPage());
            request.setAttribute(PAGE_NUMBER_NAME, pageNumber);
            request.setAttribute(TOTAL_PAGES_NUMBER_NAME, totalPages);
            request.setAttribute(PARSER_TYPE_NAME, parserType);
            request.setAttribute(COMMAND_FIELD_NAME, COMMAND_FIELD_VALUE);
            request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
        } catch (ServiceException e) {
            request.setAttribute(ERROR_MESSAGE_NAME, e.getMessage());
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }

    }

}
