package org.example;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class TwitterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // example of Routes that need the class Account to be registred for reflection
        from("twitter-search://@Apachecamel")
                .setBody()
                .simple("{\"sigthning\": \"${body}\", \"where\": \"twitter\"}")
                .marshal().json()
                .log("${body}")
                .to("kafka:camelsightings");
    }
}