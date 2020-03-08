package samplr.workflow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class WorkflowController<T extends WorkItem> {
    private final Workflow workflow;
    private final CommandExecutor commandChannel;
    private final T workItem;
    private State currentState;

    public void setCurrentState(State state) {
        this.currentState = state;
        state.executeCommands(commandChannel, this);
    }

    public void handle(Event event) {

    }
}
