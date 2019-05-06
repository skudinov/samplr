package samplr.sbapi.common.response;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;
import samplr.sbapi.common.response.model.json.Metadata;
import samplr.sbapi.common.response.model.json.ResponseBody;

import static samplr.sbapi.common.response.ResponseType.XML;

@Component
@RequiredArgsConstructor
public class ResponseFactory {
  private final ResponseMapper mapper;

  private ResponseBody createBody(XMLEntity payload) {
    return ResponseBody
        .<XMLEntity>begin()
        .metadata(Metadata.success())
        .payload(payload)
        .end();
  }

  public ResponseEntity success(XMLEntity payload, ResponseType type) {
    return ResponseEntity.ok(type==XML? mapper.map(createBody(payload)): createBody(payload));
  }
}
