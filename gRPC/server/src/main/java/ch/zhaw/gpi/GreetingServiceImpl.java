package ch.zhaw.gpi;

import java.util.Date;

import org.lognet.springboot.grpc.GRpcService;

import ch.zhaw.gpi.GreeterGrpc.GreeterImplBase;
import ch.zhaw.gpi.GreetingServiceResponse.Builder;
import io.grpc.stub.StreamObserver;


@GRpcService
public class GreetingServiceImpl extends GreeterImplBase {
    @Override
    public void getGreetingWithDateRequest(GreetingServiceRequest request,
            StreamObserver<GreetingServiceResponse> responseObserver) {

                String greeting = "You entered: " + request.getMessage() + " on " 
                    + new Date(System.currentTimeMillis());

                Builder replyBuilder =  GreetingServiceResponse.newBuilder().setGreeting(greeting);
                responseObserver.onNext(replyBuilder.build());
                responseObserver.onCompleted();    
    }   
}

