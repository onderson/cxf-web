package org.apache.camel.tutorial.dsl;

import org.apache.camel.builder.RouteBuilder;

/**
 * Java DSL Route definition for the ExcelInputTest test class
 */
public class ExcelInputTestRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:XLSstart").pipeline("bean:ExcelConverter", "mock:finish");
    }
}