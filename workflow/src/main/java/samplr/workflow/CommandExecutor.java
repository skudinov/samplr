package samplr.workflow;

import lombok.Builder;
import lombok.Singular;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Builder
public class CommandExecutor {
    @Singular
    private final Map<Command, CommandHandler> handlers;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void execute(Command command, WorkflowController controller) {
        Optional.ofNullable(handlers.get(command)).ifPresent(
            handler -> executor.execute(() -> handler.handle(command, controller.getWorkItem(), controller))
        );
    }
}
