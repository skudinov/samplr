package samplr.sbapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchRepository {
  @Autowired
  private AMapper amapper;

  public List<?> search() {
    return  amapper.search();
  }
}
