package com.mycompany;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class HelloHandlerTest {

  HelloHandler handler;
  APIGatewayProxyRequestEvent input;
  @Before
  public void setUp() throws Exception {
    handler = new HelloHandler();
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("name", "Universe");
    input = new APIGatewayProxyRequestEvent().withPath("/hello").withPathParamters(pathParams);
  }

  @Test
  public void handleRequest() {
    APIGatewayProxyResponseEvent res = handler.handleRequest(input, null);
    assertNotNull(res);
    assertEquals("Hello Universe!", res.getBody());
  }
  @Test
  public void handleEmptyRequest() {
    input.withPathParamters(Collections.emptyMap());
    APIGatewayProxyResponseEvent res = handler.handleRequest(input, null);
    assertNotNull(res);
    assertEquals("Hello World!", res.getBody());
  }
}