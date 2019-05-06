package samplr.sbapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import samplr.sbapi.common.domain.model.xsd.XMLEntity;

import java.util.List;

@Configuration
@EnableWebMvc
public class Jaxb2Config implements WebMvcConfigurer {
  @Value("classpath:root-entity.xsd")
  private Resource schema;

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(0, new MarshallingHttpMessageConverter(jaxb2Marshaller()));
  }

  @Bean
  protected Jaxb2Marshaller jaxb2Marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setSchema(schema);
    marshaller.setClassesToBeBound(XMLEntity.class);
    return  marshaller;
  }
}
