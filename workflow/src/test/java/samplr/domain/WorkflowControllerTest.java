package samplr.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import samplr.domain.spring.DomainAutowired;
import samplr.domain.spring.DomainQualifier;
import samplr.domain.spring.WorkflowConfiguration;
import samplr.workflow.WorkflowController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WorkflowConfiguration.class })
public class WorkflowControllerTest {
    @DomainAutowired
    ObjectFactory<WorkflowController<DomainWorkItem>> workflowControllerFactory;

    @Test
    public void workflowControllerCreated() {
        WorkflowController<DomainWorkItem> workflowController = workflowControllerFactory.getObject();
        assertThat(workflowController).isNotNull();
        assertThat(workflowController.getCommandChannel()).isNotNull();
        assertThat(workflowController.getWorkItem()).isNotNull();
    }
}
