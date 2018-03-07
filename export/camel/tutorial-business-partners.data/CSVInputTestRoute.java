package org.apache.camel.tutorial.dsl;

import org.apache.camel.builder.RouteBuilder;

/**
 * Java DSL Route definition for the CSVInputTest test class
 */
public class CSVInputTestRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:CSVstart")
                .unmarshal().csv()
                .pipeline("bean:CSVConverter", "mock:finish");
    }
}