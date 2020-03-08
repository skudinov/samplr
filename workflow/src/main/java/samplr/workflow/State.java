package samplr.workflow;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
public class State {
    private final Step step;
    private final Status status;
    @Singular
    private final List<Command> commands;

    public <T extends WorkItem> void executeCommands(CommandExecutor channel, WorkflowController<T> controller) {
        commands.forEach(command -> channel.execute(command, controller));
    }

}
