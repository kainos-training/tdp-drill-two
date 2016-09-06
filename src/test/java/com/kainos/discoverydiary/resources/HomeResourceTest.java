package com.kainos.discoverydiary.resources;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;
import io.dropwizard.testing.junit.ResourceTestRule;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.ViewRenderer;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomeResourceTest {

    private static List<ViewRenderer> renders = Lists.<ViewRenderer>newArrayList(new FreemarkerViewRenderer());

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HomeResource())
            .addProvider(new ViewMessageBodyWriter(new MetricRegistry(), renders))
            .build();

    @Before
    public void setup() {
    }

    @Test
    public void testHome() {
        Response response = resources.client()
                .target("")
                .request(MediaType.TEXT_HTML_TYPE)
                .get();

        assertEquals(200, response.getStatus());
    }
}
