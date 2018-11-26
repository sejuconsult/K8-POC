package tdc.k8.apigateway;

import org.apache.http.client.utils.URIUtils;
import org.mitre.dsmiley.httpproxy.ProxyServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class K8POCProxyServlet extends ProxyServlet {

    @Override
    protected void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(servletRequest.getRequestURL());
        try {
            URI uri = new URI(servletRequest.getRequestURL().toString());
            String path = uri.getPath();
            String targetUrl = String.format("http:/%s", path);
            servletRequest.setAttribute(ATTR_TARGET_URI, targetUrl);
            servletRequest.setAttribute(ATTR_TARGET_HOST, URIUtils.extractHost(new URI(targetUrl)));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        super.service(servletRequest, servletResponse);
    }
}
