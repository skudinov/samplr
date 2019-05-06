package samplr.sbapi.update;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;
import samplr.sbapi.common.response.ResponseFactory;

import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;
import static samplr.sbapi.common.response.ResponseType.XML;

@RestController
@RequiredArgsConstructor
public class UpdateController {
  private final ResponseFactory responseFactory;

  @PostMapping(path = "/", consumes = APPLICATION_XML_VALUE, produces = APPLICATION_XML_VALUE)
  public ResponseEntity<?> insertOrUpdate(@RequestBody XMLEntity entity) {
    return responseFactory.success(new XMLEntity(), XML);
  }

}
