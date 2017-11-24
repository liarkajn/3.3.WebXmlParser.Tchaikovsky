package main.java.com.parser.web.controller;

import main.java.com.parser.web.controller.command.Command;
import main.java.com.parser.web.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private final static String COMMAND_FIELD_NAME = "command";
    private CommandProvider commandProvider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND_FIELD_NAME);
        Command command = commandProvider.getCommand(commandName);
        command.execute(request, response);
    }

}
