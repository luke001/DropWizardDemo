package com.ning.demo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: xianlinbox
 * Date: 1/3/13
 * Time: 3:34 PM
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {

    //服务入口
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //指定配置文件的名字
        bootstrap.setName("helloWorld");
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final String template = helloWorldConfiguration.getTemplate();
        final String defaultName = helloWorldConfiguration.getDefaultName();
        environment.addResource(new HelloWorldResource(template,defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}
