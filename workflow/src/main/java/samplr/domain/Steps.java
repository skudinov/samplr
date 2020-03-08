package samplr.domain;

import samplr.workflow.Step;

public final class Steps {
    public final static Step DATA_IN_MONGO = new Step("DATA_IN_MONGO");
    public final static Step DATA_IN_ORACLE = new Step("DATA_IN_ORACLE");

    private Steps() {}
}
