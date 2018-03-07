package org.apache.camel.tutorial;

import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;

/**
 * A test class to ensure we can convert Partner 1 XML input files to the
 * canonical XML output format, using XSLT.
 */
@ContextConfiguration(locations = "/XMLInputTest-context.xml")
public class XMLInputTest extends AbstractJUnit38SpringContextTests {
    @Autowired
    protected CamelContext camelContext;
    protected ProducerTemplate<Exchange> template;

    protected void setUp() throws Exception {
        super.setUp();
        template = camelContext.createProducerTemplate();
    }

    public void testNothing() {}
}
