package productAPI;

import java.util.*;
import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {

	@FunctionName("hello")
	public HttpResponseMessage<String> hello(
			@HttpTrigger(name = "req", methods = { "get",
					"post" }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
			final ExecutionContext context) {
		context.getLogger().info("Java HTTP trigger processed a request.");

		// Parse query parameter
		String query = request.getQueryParameters().get("name");
		String name = request.getBody().orElse(query);

		if (name == null) {
			return request.createResponse(400, "Please pass a name on the query string or in the request body");
		} else {
			return request.createResponse(200, "Hello, " + name);
		}
	}
}
