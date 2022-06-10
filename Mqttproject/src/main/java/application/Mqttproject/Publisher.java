package application.Mqttproject;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/*
 * This class publishes the message to the Mqtt client
 */
public class Publisher{

  public void sendMessage() throws MqttException {

    String message = "{“sensor_value”:20}";

    MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.connect();
    MqttMessage mqttMessage = new MqttMessage();
    mqttMessage.setPayload(message.getBytes());
    
    //Publishing the message via the subscription topic "Events"
    client.publish("events", mqttMessage);

    client.disconnect();

  }
  
}
