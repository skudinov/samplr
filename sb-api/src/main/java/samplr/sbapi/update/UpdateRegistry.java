package samplr.sbapi.update;

import org.apache.ibatis.annotations.Mapper;
import samplr.sbapi.common.domain.model.dto.DTOEntity;

@Mapper
public interface UpdateRegistry {

  void insert(DTOEntity entity);
}
