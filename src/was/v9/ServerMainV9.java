package was.v9;

import was.httpserver.HttpServer;
import was.httpserver.ServletManager;
import was.httpserver.annotation.AnnotationServletV3;
import was.httpserver.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV9 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV9(), new SearchControllerV9());
        AnnotationServletV3 annotationServlet = new AnnotationServletV3(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}
