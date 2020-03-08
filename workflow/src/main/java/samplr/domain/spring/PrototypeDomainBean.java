package samplr.domain.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Bean
@DomainQualifier
@Scope(SCOPE_PROTOTYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrototypeDomainBean {
}
