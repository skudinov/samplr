package samplr.sbapi.update;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import samplr.sbapi.common.domain.model.dto.DTOEntity;
import samplr.sbapi.common.domain.DomainMapper;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;

@Component
@RequiredArgsConstructor
public class UpdateService {
  private UpdateRegistry registry;
  private DomainMapper mapper;

  public void update(XMLEntity entity) {
    DTOEntity dto = mapper.toDTO(entity);
    registry.insert(dto);
  }
}
