package samplr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import samplr.workflow.WorkItem;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainWorkItem extends WorkItem<DomainModel> {
    private String parentActionId;
    private String actionId;
}
