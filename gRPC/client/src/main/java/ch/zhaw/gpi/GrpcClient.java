package ch.zhaw.gpi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.zhaw.gpi.GreeterGrpc.GreeterBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class GrpcClient  implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(GrpcClient.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
          .usePlaintext()
          .build();
 
        GreeterBlockingStub stub 
          = GreeterGrpc.newBlockingStub(channel);
 
        GreetingServiceResponse helloResponse = stub.getGreetingWithDateRequest(GreetingServiceRequest.newBuilder()
          .setMessage("Hallo GRPC")
          .build());
 
        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
  }

}

