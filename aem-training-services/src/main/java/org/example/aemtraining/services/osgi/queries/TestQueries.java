package org.example.aemtraining.services.osgi.queries;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.query.Query;
import java.util.Iterator;

/**
 */

@Component(immediate = true)
@Service(TestQueries.class)
public class TestQueries {
    public void test(SlingHttpServletRequest request) {
        queryResources(request.getResourceResolver());
    }
    private void queryResources(ResourceResolver resolver) {
        Iterator<Resource> it = resolver.findResources(
                "SELECT pages.* " +
                "FROM [cq:PageContent] AS pages " +
                "WHERE ISDESCENDANTNODE(pages, [/content/aem-training])"

                , Query.JCR_SQL2);
        while (it.hasNext()) {
            Resource resource = it.next();
            System.out.println("q");
        }
    }
}
