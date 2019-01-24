package samplr.sbapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import samplr.sbapi.model.dto.EntityDTO;
import samplr.sbapi.model.mapper.DTOEntityMapper;
import samplr.sbapi.model.mapper.XSDMapper;
import samplr.sbapi.model.xsd.Entity;

@Component
@RequiredArgsConstructor
public class EntityService {
  private DTOEntityMapper dtoMapper;
  private XSDMapper xsdMapper;

  public void update(Entity entity) {
    EntityDTO dto = xsdMapper.mapToDTO(entity);
    dtoMapper.insert(dto);
  }
}
