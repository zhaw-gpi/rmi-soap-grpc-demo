package ch.zhaw.gpi;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import ch.zhaw.gpi.greetings.GetGreetingWithDateRequest;
import ch.zhaw.gpi.greetings.GetGreetingWithDateResponse;


public class GreetingClient extends WebServiceGatewaySupport {

    public GetGreetingWithDateResponse getGreetingWithDate(String message) {

		GetGreetingWithDateRequest request = new GetGreetingWithDateRequest();
        request.setMessage(message);

		GetGreetingWithDateResponse response = (GetGreetingWithDateResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/getGreetingWithDateRequest", request,
						new SoapActionCallback(
								"http://www.zhaw.ch/gpi/greetings/GreetingService"));

		return response;
	}

}