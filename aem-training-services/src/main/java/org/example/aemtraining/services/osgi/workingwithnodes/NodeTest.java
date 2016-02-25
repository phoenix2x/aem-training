package org.example.aemtraining.services.osgi.workingwithnodes;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.*;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;

/**
 */
@Component(immediate = true)
@Service(NodeTest.class)
public class NodeTest {

    public static final String VAR_TESTQ = "/var/testq";

    public void test(SlingHttpServletRequest request) {
        ResourceResolver resolver = request.getResourceResolver();
        Session session = resolver.adaptTo(Session.class);
        try {
//            getNode(session);

            persistentQuery(session);
        } catch (RepositoryException e) {

        }
    }

    public void persistentQuery(Session session) throws RepositoryException {
        QueryManager queryManager = session.getWorkspace().getQueryManager();
        Query query = queryManager.createQuery("/jcr:root/content/aem-training", Query.XPATH);
        if (!session.nodeExists(VAR_TESTQ)) {
            query.storeAsNode(VAR_TESTQ);
            session.save();
        }
        Query query1 = queryManager.getQuery(session.getNode(VAR_TESTQ));

        RowIterator rowIterator = query1.execute().getRows();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.nextRow();
            System.out.println("q");
        }

    }

    private void getNode(Session session) throws RepositoryException {
        Node node = session.getNode("/content/aem-training/jcr:content");
        Property property = node.getProperty("testProp");
        Node node1 = property.getNode();
        System.out.println("q");
    }

    private void testValueFactory(Session session) throws RepositoryException {
        ValueFactory valueFactory = session.getValueFactory();
        valueFactory.createValue("", PropertyType.REFERENCE);
    }
}
