package was.httpserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {

    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    private HttpServlet defaultServlet;
    private HttpServlet noFoundErrorServlet;
    private HttpServlet internalErrorServlet;

    public ServletManager() {
    }

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public void setDefaultServlet(HttpServlet defaultServlet) {
        this.defaultServlet = defaultServlet;
    }

    public void setNoFoundErrorServlet(HttpServlet noFoundErrorServlet) {
        this.noFoundErrorServlet = noFoundErrorServlet;
    }

    public void setInternalErrorServlet(HttpServlet internalErrorServlet) {
        this.internalErrorServlet = internalErrorServlet;
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);
            if (servlet == null) {
                throw new PageNotFoundException("request url= " + request.getPath());
            }
            servlet.service(request, response);

        } catch (PageNotFoundException e) {
            e.printStackTrace();
            noFoundErrorServlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            internalErrorServlet.service(request, response);
        }
    }
}
