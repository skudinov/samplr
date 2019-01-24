package samplr.sbapi.model.dto;

import lombok.*;

import java.util.Date;

@Data
public class EntityDTO {
  private String id;
  private String name;
  private String createdBy;
  private Date createdAT;
  private String updatedBy;
  private Date updatedAt;

}
