package com.ning.demo;

import com.yammer.metrics.core.HealthCheck;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/4/13
 * Time: 9:15 AM
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    protected TemplateHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template,"TEST");
        if(!saying.contains("TEST")){
            return Result.unhealthy("template doesn't include a name!");
        }
        return Result.healthy();
    }
}
