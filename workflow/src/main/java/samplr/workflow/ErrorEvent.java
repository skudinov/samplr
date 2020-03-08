package samplr.workflow;

import lombok.*;

@Getter
public class ErrorEvent<T> extends Event<T> {
    private final Throwable error;

    public ErrorEvent(String id, T payload, Throwable error) {
        super(id, payload);
        this.error = error;
    }
}
