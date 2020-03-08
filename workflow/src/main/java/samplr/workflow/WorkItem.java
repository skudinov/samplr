package samplr.workflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkItem<T> {
    private State source;
    private State target;
    private Event event;
    private T payload;
}
