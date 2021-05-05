package org.example;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.camel.ConsumerTemplate;

@ApplicationScoped
@Path("twitter")
public class TwitterResource {

    @Inject
    ConsumerTemplate consumerTemplate;

    @GET
    @Path("search/{keywords}")
    public String search(@PathParam("keywords") String keywords) {
        final String tweets = consumerTemplate.receiveBodyNoWait("twitter-search://" + keywords + "?count=3", String.class);
        return "Search keywords " + tweets;
    }
}
