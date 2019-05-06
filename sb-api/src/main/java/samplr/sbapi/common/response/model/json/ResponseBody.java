package samplr.sbapi.common.response.model.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder(builderMethodName = "begin", buildMethodName = "end")
public class ResponseBody<T> {
  private Metadata metadata;
  private T payload;
}
