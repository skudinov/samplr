package samplr.domain;

import samplr.workflow.Status;

public final class Statuses {
    public final static Status PENDING = new Status("PENDING");
    public final static Status READY = new Status("READY");
    public final static Status COMPLETED = new Status("COMPLETED");
    public final static Status ERROR = new Status("ERROR");
    private Statuses() {}
}
