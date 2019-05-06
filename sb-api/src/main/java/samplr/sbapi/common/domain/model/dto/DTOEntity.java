package samplr.sbapi.common.domain.model.dto;

import lombok.*;

import java.util.Date;

@Data
public class DTOEntity {
  private String id;
  private String name;
  private String createdBy;
  private Date createdAT;
  private String updatedBy;
  private Date updatedAt;

}
