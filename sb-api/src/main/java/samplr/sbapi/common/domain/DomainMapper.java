package samplr.sbapi.common.domain;

import org.mapstruct.Mapper;
import samplr.sbapi.common.domain.model.dto.DTOAddress;
import samplr.sbapi.common.domain.model.dto.DTOEntity;
import samplr.sbapi.common.domain.model.xsd.XMLAddressType;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;

@Mapper
public interface DomainMapper {

  DTOEntity toDTO(XMLEntity entity);

  DTOAddress toDTO(XMLAddressType addresses);
}
