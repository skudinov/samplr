package samplr.sbapi.common.domain.model.dto;

import lombok.Data;

@Data
public class DTOAddress {
  private String id;
  private String entityId;
  private String zip;
  private String street;
}
