package samplr.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import samplr.domain.spring.DomainAutowired;
import samplr.domain.spring.DomainQualifier;
import samplr.domain.spring.WorkflowConfiguration;
import samplr.workflow.Workflow;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WorkflowConfiguration.class })
public class WorkflowTest {

    @DomainAutowired
    Workflow workflow;

    @Test
    public void workflowDefined() {
        assertNotNull(workflow);
        assertThat(workflow.getStates()).isNotEmpty();
        assertThat(workflow.getTransitions()).isNotEmpty();
    }
}
