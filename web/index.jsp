<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Xml parser</title>
  </head>
  <body>

    <div align="center">

        <form action="main" method="get">
            <input type="hidden" name="command" value="parser" />
            <input type="hidden" name="parserType" value="SAX" />
            <input type="submit" value="SAX" />
        </form>

        <form action="main" method="get">
            <input type="hidden" name="command" value="parser" />
            <input type="hidden" name="parserType" value="StAX" />
            <input type="submit" value="StAX" />
        </form>

        <form action="main" method="get">
            <input type="hidden" name="command" value="parser" />
            <input type="hidden" name="parserType" value="DOM" />
            <input type="submit" value="DOM" />
        </form>

    </div>

  </body>
</html>
