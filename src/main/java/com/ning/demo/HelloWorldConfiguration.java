package com.ning.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.BeanConfig;
import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.internal.metadata.raw.BeanConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: xianlinbox
 * Date: 1/3/13
 * Time: 3:22 PM
 */
public class HelloWorldConfiguration extends Configuration {
    @NotEmpty //参数检查
    @JsonProperty //自动映射配置文件
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName;

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }
}
