package application.Mqttproject;



import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Subscriber {

  public static void main(String[] args) throws MqttException {

    System.out.println(" Welcome to MQTT broker>>");

    //connect to the MqttClient using the local host
    MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.setCallback( new SimpleMqttCallBack() );
    client.connect();

    client.subscribe("events");
    
    System.out.print("Wanna send the message now ?? Type y to send message and n to end.");
    Scanner scan = new Scanner(System.in);
    String ans = scan.next();
    if(ans.equalsIgnoreCase("y")) {
    	Publisher publish = new Publisher();
    	publish.sendMessage();
    }else {
    	System.out.print("Goodbye....");
    	client.disconnect();
    }
   scan.close();
  }

}
