package org.example.aemtraining.services.osgi.replication;

import com.day.cq.replication.*;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;

import javax.jcr.Session;

/**
 */
@Component(immediate = true)
@Service(ReplicationTest.class)
public class ReplicationTest {
    @Reference
    private OutboxManager outboxManager;

    @Reference
    private Replicator replicator;


    public void test(SlingHttpServletRequest request) {
//        outboxManager.fetch();
        try {
            ReplicationOptions replicationOptions = new ReplicationOptions();
            replicationOptions.setFilter(new AgentIdFilter("static"));
            replicator.replicate(request.getResourceResolver().adaptTo(Session.class)
                    , ReplicationActionType.ACTIVATE, "", replicationOptions);
        } catch (ReplicationException e) {

        }
    }

}
