package org.example.aemtraining.services.osgi.httpclient;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


@SlingServlet(resourceTypes = "sling/servlet/default", selectors = "http-cn")
public class HTTPConnectionServlet extends SlingSafeMethodsServlet {
    private final static Logger LOG = LoggerFactory.getLogger(HTTPConnectionServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String urlString = "http://www.google.by";



//            URL url = new URL(urlString);
//            URLConnection connection = url.openConnection();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String inputLine;
//            PrintWriter writer = response.getWriter();
//            while ((inputLine = bufferedReader.readLine()) != null) {
//                writer.write(inputLine);
//            }
//        } catch (java.io.IOException e) {
//            LOG.error("err", e);
//        }
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(urlString);
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        try {
            String responseBody = client.execute(httpGet, responseHandler);
            response.getWriter().write(responseBody);
        } catch (IOException e) {
            LOG.error("err", e);
        }
    }
}
