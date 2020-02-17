package samplr.sbapi;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class APIErrorHandler {

//  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  @ExceptionHandler(Exception.class)
//  @ResponseBody
  public String handleInternalError(Exception e) {
    log.error("Internal server error", e);
    return String.format("Internal Server Error (traceId: %s), error %s", MDC.get("X-TraceId"));
  }
}
