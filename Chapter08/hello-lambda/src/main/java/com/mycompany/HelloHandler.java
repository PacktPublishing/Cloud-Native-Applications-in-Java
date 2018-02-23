package com.mycompany;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.net.HttpURLConnection;

public class HelloHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
    String who = "World";
    if ( request.getPathParameters() != null ) {
      String name  = request.getPathParameters().get("name");
      if ( name != null && !"".equals(name.trim()) ) {
        who = name;
      }
    }
    return new APIGatewayProxyResponseEvent().withStatusCode(HttpURLConnection.HTTP_OK).withBody(String.format("Hello %s!", who));
  }

}
