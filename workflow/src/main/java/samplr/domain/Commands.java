package samplr.domain;

import samplr.workflow.Command;

import java.util.Collection;

public final class Commands {
    public final static Command CREATE_ACTION = new Command("CREATE_ACTION");
    public final static Command UPDATE_ACTION = new Command("UPDATE_ACTION");
    public final static Command POST_MESSAGE = new Command("POST_MESSAGE");
    public static final Command SAVE_IN_ORACLE = new Command("SAVE_IN_MONGO");

    private Commands() {}
}
