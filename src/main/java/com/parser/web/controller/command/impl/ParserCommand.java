package main.java.com.parser.web.controller.command.impl;

import main.java.com.parser.web.controller.command.Command;
import main.java.com.parser.web.domain.Book;
import main.java.com.parser.web.service.ParserService;
import main.java.com.parser.web.service.ServiceFactory;
import main.java.com.parser.web.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ParserCommand implements Command {

    private final static String PARSER_NAME_PARAMETER = "parser";
    private final static String BOOK_LIST_ATTRIBUTE = "bookList";
    private final static String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
    private final static String MAIN_PAGE = "/WEB-INF/page/main.jsp" ;
    private final static String ERROR_PAGE = "/WEB-INF/page/error.jsp" ;
    private ParserService parserService = ServiceFactory.getInstance().getParserService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parserName = request.getParameter(PARSER_NAME_PARAMETER);
        try {
            List<Book> books = parserService.parse(parserName);
            request.setAttribute(BOOK_LIST_ATTRIBUTE, books);
            request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
        } catch (ServiceException e) {
            request.setAttribute(ERROR_MESSAGE_ATTRIBUTE, e.getMessage());
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }

    }

}
