package org.example.aemtraining.services.osgi.utils;

import com.day.cq.replication.ReplicationStatus;
import com.day.text.ISO9075;
import org.apache.sling.api.SlingHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 */

public class Usefull {
    public static void test1(){
//        encode path according to iso - e.g. replace leading numbers in node names with their char codes;
        System.out.println(ISO9075.encodePath("/asd/jcr:content/2"));
    }

    //check if gzip ENABLED and DON'T DISABLED before call this method
    public PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
        return new PrintWriter(new GZIPOutputStream(response.getOutputStream()));
    }

    public boolean isActivated(SlingHttpServletRequest request) {
        return request.getResource().adaptTo(ReplicationStatus.class).isActivated();
    }


}
