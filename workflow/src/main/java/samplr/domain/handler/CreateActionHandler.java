package samplr.domain.handler;

import samplr.domain.DomainModel;
import samplr.domain.DomainWorkItem;
import samplr.workflow.Command;
import samplr.workflow.CommandHandler;
import samplr.workflow.WorkflowController;

public class CreateActionHandler implements CommandHandler<DomainWorkItem> {

    @Override
    public void handle(Command command, DomainWorkItem workItem, WorkflowController<DomainWorkItem> controller) {
        DomainModel domainItem = workItem.getPayload();
    }
}
