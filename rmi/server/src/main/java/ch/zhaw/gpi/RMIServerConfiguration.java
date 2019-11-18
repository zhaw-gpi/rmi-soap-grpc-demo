package ch.zhaw.gpi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

@Configuration
public class RMIServerConfiguration {
    @Bean
    GreetingService dateService() {
        return new GreetingServiceImpl();
    }

    @Bean
    RemoteExporter registerRMIExporter(GreetingService implementation) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName(GreetingService.class.getSimpleName());
        exporter.setServiceInterface(GreetingService.class);
        exporter.setService(implementation);
        exporter.setRegistryPort(1099); 
        return exporter;
    }

}

