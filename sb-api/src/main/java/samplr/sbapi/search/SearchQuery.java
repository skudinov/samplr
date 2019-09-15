package samplr.sbapi.search;

import javax.validation.constraints.NotNull;

public class SearchQuery {
  @NotNull
  public String firstName;
  @NotNull
  public String lastName;
}
