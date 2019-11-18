package ch.zhaw.gpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RMIClient implements CommandLineRunner {

  @Autowired
  private ApplicationContext context;

  @Bean
  RmiProxyFactoryBean greetingProxyFactory() {
    RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
    bean.setServiceInterface(GreetingService.class);
    bean.setServiceUrl("rmi://localhost:1099/" + GreetingService.class.getSimpleName());
    return bean;
  }  
  public static void main(String[] args) {
    SpringApplication.run(RMIClient.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    GreetingService greetingService = context.getBean(GreetingService.class);
    System.out.println(greetingService.getGreetingWithDate("How are you?"));
  }

}

