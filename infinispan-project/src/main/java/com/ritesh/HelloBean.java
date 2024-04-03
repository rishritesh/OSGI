package com.ritesh;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.builder.RouteBuilder;

/**
 * A bean which we use in the route
 */
public class HelloBean extends RouteBuilder{
	
	
@Override
public void configure() throws Exception {
    from("restlet:http://localhost:8080/myapp/myservice")
        .to("log:receivedMessage");
}

	

    
}
