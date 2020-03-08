package samplr.workflow;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class Transition {
    private final State source;
    private final String eventId;
    private final State target;
}
