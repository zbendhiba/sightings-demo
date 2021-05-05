package org.example;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class TwitterRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("twitter-search://@Apachecamel?count=100")
                .log("log:${body}")
                .to("kafka:sighting");
    }
}
