package samplr.sbapi.update;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import samplr.sbapi.common.response.ResponseMapper;
import samplr.sbapi.common.response.model.json.Metadata;
import samplr.sbapi.common.response.model.json.ResponseBody;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;

import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@RestController
@RequiredArgsConstructor
public class UpdateController {
  private final ResponseMapper responseMapper;

  @PostMapping(path = "/", consumes = APPLICATION_XML_VALUE, produces = APPLICATION_XML_VALUE)
  public ResponseEntity<?> insertOrUpdate(@RequestBody XMLEntity entity) {
    return ResponseEntity.ok(
      responseMapper.map(ResponseBody
        .<XMLEntity>begin()
        .metadata(Metadata.success())
        .payload(new XMLEntity())
        .end()
      ));
  }

}
