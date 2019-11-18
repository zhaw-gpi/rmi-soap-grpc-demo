package ch.zhaw.gpi;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ch.zhaw.gpi.greetings.GetGreetingWithDateRequest;
import ch.zhaw.gpi.greetings.GetGreetingWithDateResponse;


@Endpoint
public class GreetingServiceEndpoint {
    private static final String NAMESPACE_URI = "http://www.zhaw.ch/gpi/greetings";
 
 
    public GreetingServiceEndpoint() {
        return;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGreetingWithDateRequest")
    @ResponsePayload
    public GetGreetingWithDateResponse getGreetingWithDate(@RequestPayload GetGreetingWithDateRequest request) {
        GetGreetingWithDateResponse response = new GetGreetingWithDateResponse();
        GreetingService service = new GreetingServiceImpl();
        response.setGreeting(service.getGreetingWithDate(request.getMessage()));
        return response;
    }
    
}