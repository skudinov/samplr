package samplr.sbapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchRepository {
  @Autowired
  private AMapper amapper;
}
