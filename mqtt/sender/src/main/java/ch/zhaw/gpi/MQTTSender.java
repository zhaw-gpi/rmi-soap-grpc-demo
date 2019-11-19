package ch.zhaw.gpi;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MQTTSender implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(MQTTSender.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    MqttClient client = new MqttClient("tcp://localhost", MqttClient.generateClientId());
 
      client.connect();
 
    MqttMessage message = new MqttMessage("Hello MQTT".getBytes());
    client.publish("gpi-queue", message);
 
    client.disconnect();
  }

}


