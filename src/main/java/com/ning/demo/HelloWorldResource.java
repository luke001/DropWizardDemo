package com.ning.demo;

import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.*;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/3/13
 * Time: 4:03 PM
 */
@Path("/helloWorld")
@Api(value = "/helloWorld", description = "Greeting API", position = 1)
@Produces(APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Path("/{name}")
    @ApiOperation(value = "Greeting by Name",
            notes = "Say hello to the people",
            response = SayingRepresentation.class,
            position = 0)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "No Name Provided")
    })
    @Produces(APPLICATION_JSON)
    @Timed
    public SayingRepresentation sayHello(@ApiParam(value = "name for greeting", required = true) @PathParam("name") String name) {
        return new SayingRepresentation(counter.incrementAndGet(),
                String.format(template, name != null ? name : defaultName));
    }
}
