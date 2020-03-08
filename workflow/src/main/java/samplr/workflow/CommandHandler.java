package samplr.workflow;

public interface CommandHandler<T extends WorkItem> {
    void handle(Command command, T workItem,  WorkflowController<T> controller);
}
