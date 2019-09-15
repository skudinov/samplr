package samplr.sbapi.test.common;

import org.mockito.internal.util.MockUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockitoSkipAutowireConfiguration {

  @Bean
  MockBeanFactory mockBeanFactory() {
    return new MockBeanFactory();
  }

  private static class MockBeanFactory extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
      return !MockUtil.isMock(bean);
    }
  }

}
