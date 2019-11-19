package ch.zhaw.gpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class SOAPClient implements CommandLineRunner {

  @Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("ch.zhaw.gpi.greetings");
		return marshaller;
  }
  
  @Bean
	public GreetingClient cgreetingClient(Jaxb2Marshaller marshaller) {
		GreetingClient client = new GreetingClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

  @Autowired
  private GreetingClient greetingClient;

  public static void main(String[] args) {
    SpringApplication.run(SOAPClient.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String greeting = greetingClient.getGreetingWithDate("Hello SOAP!").getGreeting();
    System.out.println(greeting);
  }

}

