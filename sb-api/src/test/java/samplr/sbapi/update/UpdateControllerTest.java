package samplr.sbapi.update;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UpdateControllerTest {
  @Value("classpath:root-entity.xml")
  private Resource resource;
  private String xml;
  @Autowired
  private MockMvc mvc;

  @BeforeEach
  public void before() throws IOException {
    xml = new String(Files.readAllBytes(Paths.get(resource.getURI())), StandardCharsets.UTF_8);
  }

  @Test
  public void shouldMapXMLToModel() throws Exception {
    this.mvc.perform(post("/")
      .accept(APPLICATION_JSON).contentType(APPLICATION_XML).content(xml)
      )
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string("Success!"));
  }
}

