package samplr.workflow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class Workflow {

    private final Map<String, State> states;
    private final List<Transition> transitions;
}
