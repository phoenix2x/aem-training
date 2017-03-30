package org.example.aemtraining.services.osgi.preprocessors;

import com.day.cq.replication.Preprocessor;
import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.ReplicationOptions;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.scripting.api.BindingsValuesProvider;

import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.script.Bindings;

/**
 */
@Component(immediate = true)
@Service(value = Preprocessor.class)
public class TestPreprocessor implements Preprocessor, BindingsValuesProvider{

    @Reference(target = "(testProp=test2)")
    private TestInter testInter2;

    @Reference(target = "(testProp=test1)")
    private TestInter testInter1;

    @Reference(target = "(singleTestProp=test2)")
    private TestInter testInter3;

    @Reference
    private SlingRepository repository;

    @Override
    public void preprocess(ReplicationAction replicationAction, ReplicationOptions replicationOptions) throws ReplicationException {
        testInter2.test();
        testInter1.test();
        try {
            Session session = repository.loginAdministrative(null);
            QueryManager queryManager = session.getWorkspace().getQueryManager();
            Query query = queryManager.createQuery("//*", Query.XPATH);
            NodeIterator iterator = query.execute().getNodes();
            while (iterator.hasNext()) {
                iterator.nextNode();
            }
        } catch (RepositoryException e) {
        }
//        throw new ReplicationException("oblom");
    }

    @Override
    public void addBindings(Bindings bindings) {
        System.out.println("q");
    }
}
