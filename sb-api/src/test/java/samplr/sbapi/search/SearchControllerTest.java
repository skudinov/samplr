package samplr.sbapi.search;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import samplr.sbapi.test.common.MockitoSkipAutowireConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
@Import(SearchService.class)
public class SearchControllerTest {
  @Autowired
  private MockMvc mvc;
  @MockBean
  private SearchRepository searchRepository;

  @Test
  public void searchQueryValid() throws Exception {
    searchRepository.search();
    mvc.perform(
      post("/actions/search")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{" +
          "\"firstName\": \"Slava\", " +
          "\"lastName\": \"Kudzinau\"}")
        .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk());
  }
}
