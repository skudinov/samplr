package samplr.domain.spring;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier("domain")
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainQualifier {
}
