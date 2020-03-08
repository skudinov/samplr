package samplr.workflow;

import lombok.*;

@Getter
@Builder
@RequiredArgsConstructor
public class Event<T> {
    private final String id;
    private final T payload;
}
