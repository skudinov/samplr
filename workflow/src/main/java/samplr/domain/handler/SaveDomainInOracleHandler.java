package samplr.domain.handler;

import samplr.domain.DomainModel;
import samplr.domain.DomainWorkItem;
import samplr.domain.spring.DomainBean;
import samplr.workflow.*;

import static samplr.domain.EventIds.SAVE_IN_ORACLE_ERROR;

@DomainBean
public class SaveDomainInOracleHandler implements CommandHandler<DomainWorkItem> {

    @Override
    public void handle(Command command, DomainWorkItem workItem, WorkflowController<DomainWorkItem> controller) {
        DomainModel domainModel = workItem.getPayload();
        try {
            // save domain model with possible failure
        } catch (Throwable e) {
            controller.handle(new ErrorEvent(SAVE_IN_ORACLE_ERROR, domainModel, e));
        }
    }
}
