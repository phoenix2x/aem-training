package org.example.aemtraining.services.osgi.workflow;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowService;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.Workflow;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.model.WorkflowModel;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 */
@Component(immediate = true)
@Service(StartWorkflow.class)
public class StartWorkflow {

    @Reference
    private WorkflowService workflowService;

    @Reference
    private Repository repository;

    @Activate
    public void activate() throws RepositoryException, WorkflowException {
        Session session = repository.login();

        WorkflowSession workflowSession = workflowService.getWorkflowSession(session);

        WorkflowModel workflowModel = workflowSession.getModel("/etc/workflow/.../jcr:content/model");

        WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", "/content/dam");

        workflowData.getMetaDataMap().put("internal message", "hello to next step");

        Workflow workflow = workflowSession.startWorkflow(workflowModel, workflowData);
    }
}
