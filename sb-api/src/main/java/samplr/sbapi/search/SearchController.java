package samplr.sbapi.search;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class SearchController {
  private final SearchService searchService;

  @PostMapping(path = "/actions/search", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<?> search(@Valid @RequestBody SearchQuery query) {
    searchService.findEntities(query);
    return ResponseEntity.ok().build();
  }
}
