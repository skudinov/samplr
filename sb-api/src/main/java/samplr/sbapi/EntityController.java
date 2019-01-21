package samplr.sbapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import samplr.sbapi.model.xsd.Entity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@RestController
public class EntityController {

  @PostMapping(path = "/", consumes = APPLICATION_XML_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<String> insertOrUpdate(@RequestBody Entity entity) {
    return ResponseEntity.ok("Success!");
  }

}
