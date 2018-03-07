package org.apache.camel.tutorial.dsl;

import org.apache.camel.builder.RouteBuilder;

/**
 * Java DSL Route definition for the XMLInputTest test class
 */
public class XMLInputTestRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:start").pipeline("xslt:XMLConverter.xsl", "mock:finish");
    }
}
