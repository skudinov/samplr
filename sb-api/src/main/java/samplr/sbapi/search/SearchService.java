package samplr.sbapi.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class SearchService {
  @Autowired
  private SearchRepository repository;

  public List<?> findEntities(@Valid SearchQuery query) {
    return repository.search();
  }
}
