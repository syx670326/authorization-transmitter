package com.a3test.component.authorizationtransmitter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.a3test.component.authorizationtransmitter.EnableAuthorizationTransmitterAutoConfiguration;

/**
 * @author eason
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({
        EnableAuthorizationTransmitterAutoConfiguration.class
})
public @interface EnableAuthorizationTransmitter {

}
