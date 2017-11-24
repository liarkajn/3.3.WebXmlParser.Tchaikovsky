package main.java.com.parser.web.dao.impl.command;

import main.java.com.parser.web.dao.impl.command.impl.dom.DOMParserXML;
import main.java.com.parser.web.dao.impl.command.impl.sax.SAXParserXML;
import main.java.com.parser.web.dao.impl.command.impl.stax.StAXParserXML;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<ParserType, Command> parsers = new HashMap<>();

    public CommandProvider() {
        parsers.put(ParserType.SAX, new SAXParserXML());
        parsers.put(ParserType.STAX, new StAXParserXML());
        parsers.put(ParserType.DOM, new DOMParserXML());
    }

    public Command takeParser(String parserName) {
        ParserType type = ParserType.valueOf(parserName.toUpperCase());
        return parsers.get(type);
    }

}
