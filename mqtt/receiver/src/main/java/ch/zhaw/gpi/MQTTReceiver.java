package ch.zhaw.gpi;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MQTTReceiver implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(MQTTReceiver.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    MqttClient client = new MqttClient("tcp://localhost", MqttClient.generateClientId());

    client.setCallback(new MqttCallback() {
      @Override
      public void connectionLost(Throwable throwable) {
      }
      @Override
      public void messageArrived(String t, MqttMessage m) throws Exception {
        System.out.println(new String(m.getPayload()));
      }
      @Override
        public void deliveryComplete(IMqttDeliveryToken t) {
      }
    });

    client.connect();
    client.subscribe("gpi-queue");
  }

}
