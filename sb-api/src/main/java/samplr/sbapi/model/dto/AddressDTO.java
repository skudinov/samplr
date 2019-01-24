package samplr.sbapi.model.dto;

import lombok.Data;

@Data
public class AddressDTO {
  private String id;
  private String entityId;
  private String zip;
  private String street;
}
