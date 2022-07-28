package {{ cookiecutter.__package }};

import java.util.function.Function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldFunction implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody("Hello " + resolveName(request));
    }

    private String resolveName(APIGatewayProxyRequestEvent request) {
        if (request.getQueryStringParameters() != null && request.getQueryStringParameters().containsKey("name")) {
            return request.getQueryStringParameters().get("name");
        } else {
            return "stranger";
        }
    }
}
