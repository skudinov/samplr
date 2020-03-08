package samplr.domain.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Bean
@Qualifier("domain")
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainBean {
}
