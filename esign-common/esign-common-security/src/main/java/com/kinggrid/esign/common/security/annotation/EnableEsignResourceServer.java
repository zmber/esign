package com.kinggrid.esign.common.security.annotation;

import com.kinggrid.esign.common.security.component.EsignResourceServerAutoConfiguration;
import com.kinggrid.esign.common.security.component.EsignSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ EsignResourceServerAutoConfiguration.class, EsignSecurityBeanDefinitionRegistrar.class })
public @interface EnableEsignResourceServer {

}
