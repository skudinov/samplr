package samplr.sbapi.common.response;

import org.mapstruct.Mapper;
import samplr.sbapi.common.response.model.json.ResponseBody;
import samplr.sbapi.common.response.model.xsd.XMLPayloadType;
import samplr.sbapi.common.response.model.xsd.XMLResponse;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;

@Mapper(componentModel = "spring")
public abstract class ResponseMapper {

  public abstract XMLResponse map(ResponseBody<XMLEntity> json);

  protected XMLPayloadType entityToPayloadType(XMLEntity entity) {
    XMLPayloadType payload = new XMLPayloadType();
    if (entity != null) {
      payload.setAny(entity);
    }
    return payload;
  }
}
