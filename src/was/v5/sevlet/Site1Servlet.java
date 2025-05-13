package was.v5.sevlet;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;

import java.io.IOException;

public class Site1Servlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site1</h1>");
    }
}
