package samplr.sbapi.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import samplr.sbapi.model.dto.EntityDTO;

@Mapper
public interface DTOEntityMapper {

  void insert(EntityDTO entity);
}
