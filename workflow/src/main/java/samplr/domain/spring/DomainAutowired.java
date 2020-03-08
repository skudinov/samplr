package samplr.domain.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Autowired
@DomainQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainAutowired {
}
