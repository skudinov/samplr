package samplr.sbapi.model.mapper;

import org.mapstruct.Mapper;
import samplr.sbapi.model.dto.AddressDTO;
import samplr.sbapi.model.dto.EntityDTO;
import samplr.sbapi.model.xsd.AddressType;
import samplr.sbapi.model.xsd.Entity;

@Mapper
public interface XSDMapper {

  EntityDTO mapToDTO(Entity entity);

  AddressDTO mapToDTO(AddressType addresses);
}
