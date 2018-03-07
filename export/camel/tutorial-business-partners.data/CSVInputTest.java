package org.apache.camel.tutorial;

import java.io.InputStream;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.activemq.camel.tutorial.partners.invoice.Invoice;

/**
 * A test class the ensure we can convert Partner 2 CSV input files to the
 * canonical XML output format, using JAXB POJOs.
 */
@ContextConfiguration(locations = "/CSVInputTest-context.xml")
public class CSVInputTest extends AbstractJUnit38SpringContextTests {
    @Autowired
    protected CamelContext camelContext;
    protected ProducerTemplate<Exchange> template;

    protected void setUp() throws Exception {
        super.setUp();
        template = camelContext.createProducerTemplate();
    }

    public void testCSVConversion() throws InterruptedException {
        MockEndpoint finish = MockEndpoint.resolve(camelContext, "mock:finish");
        finish.setExpectedMessageCount(1);
        InputStream in = CSVInputTest.class.getResourceAsStream("/input-customer2.csv");
        assertNotNull(in);
        template.sendBody("direct:CSVstart", in);
        MockEndpoint.assertIsSatisfied(camelContext);
        assertEquals(Invoice.class, finish.getExchanges().get(0).getIn().getBody().getClass());
    }
}
