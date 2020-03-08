package samplr.domain.spring;

import org.springframework.context.annotation.Configuration;
import samplr.domain.handler.CreateActionHandler;
import samplr.domain.DomainWorkItem;
import samplr.domain.handler.SaveDomainInOracleHandler;
import samplr.workflow.*;

import java.util.List;
import java.util.Map;

import static samplr.domain.Commands.*;
import static samplr.domain.EventIds.DATA_IN_MONGO_COMPLETED;
import static samplr.domain.Statuses.*;
import static samplr.domain.Steps.DATA_IN_MONGO;
import static samplr.domain.Steps.DATA_IN_ORACLE;

@Configuration
public class WorkflowConfiguration {
    @DomainBean
    public Workflow workflow(@DomainQualifier Map<String, State> states,
                             @DomainQualifier List<Transition> transitions) {
        return new Workflow(states, transitions);
    }

    @DomainBean
    public CommandExecutor commandExecutor() {
        return CommandExecutor.builder()
                .handler(CREATE_ACTION, new CreateActionHandler())
                .handler(SAVE_IN_ORACLE, new SaveDomainInOracleHandler())
                .build();
    }

    @PrototypeDomainBean
    public WorkflowController<DomainWorkItem> workflowController(@DomainQualifier Workflow workflow,
                                                 @DomainQualifier CommandExecutor commandExecutor) {
        return new WorkflowController<>(workflow, commandExecutor, new DomainWorkItem());
    }

    @DomainBean
    public Transition dataInMongoReadyToCompleted(State dataInMongoReady, State dataInMongoCompleted) {
        return new Transition(dataInMongoReady, DATA_IN_MONGO_COMPLETED, dataInMongoCompleted);
    }

    @DomainBean
    public State dataInMongoReady() {
        return State.builder().step(DATA_IN_MONGO).status(READY).command(CREATE_ACTION).build();
    }

    @DomainBean
    public State dataInMongoCompleted() {
        return State.builder().step(DATA_IN_MONGO).status(COMPLETED).command(UPDATE_ACTION).build();
    }

    @DomainBean
    public State dataInMongoError() {
        return State.builder().step(DATA_IN_MONGO).status(ERROR).command(UPDATE_ACTION).build();
    }

    @DomainBean
    public State dataInOraclePending() {
        return State.builder().step(DATA_IN_ORACLE).status(PENDING).command(POST_MESSAGE).build();
    }

    @DomainBean
    public State dataInOracleReady() {
        return State.builder().step(DATA_IN_MONGO).status(READY)
                .command(CREATE_ACTION).command(SAVE_IN_ORACLE).build();
    }
}
