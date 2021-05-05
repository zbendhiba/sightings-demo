package org.example;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.camel.ProducerTemplate;

@ApplicationScoped
@Path("twitter")
public class TwitterResource {

    @Inject
    ProducerTemplate producerTemplate;

    @GET
    @Path("search/{keywords}")
    public String search(@PathParam("keywords") String keywords){
        Map<String, Object> headers = new HashMap<>();
        producerTemplate.requestBodyAndHeaders("twitter:search", keywords, headers);
        return "Search keywords " + keywords;
    }
}
