package samplr.sbapi.common.response.model.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@Builder(builderMethodName = "begin", buildMethodName = "end")
public class Metadata {
  private int code;
  private String message;

  public static Metadata success() {
    return Metadata
      .begin()
      .code(HttpStatus.OK.value())
      .message(HttpStatus.OK.getReasonPhrase())
      .end();
  }
}
