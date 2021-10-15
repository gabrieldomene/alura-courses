package org.spark.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.spark.jms.models.AgvStatus;

import javax.jms.*;
import javax.naming.InitialContext;
import java.io.Serializable;
import java.util.*;

public class TestProducerTopic {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        String connPrefix = "MANAGER";
        connection.setClientID(connPrefix + UUID.randomUUID().toString().split("-")[0]);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination topic = (Destination) context.lookup("status");

        MessageProducer producer = session.createProducer(topic);
        List<String> options = Arrays.asList("comercial", "warehouse");


        for (int i = 1; i < 10; i++) {
            AgvStatus agvStatus = new AgvStatus();
            agvStatus.setBattery(i);
            agvStatus.setPosition(UUID.randomUUID().toString().split("-")[0]);
            agvStatus.setSafety(new Random().nextInt(i) % 2 == 0);
            agvStatus.setUuid(new Random().nextInt(1000000));
            agvStatus.setName("agv-" + (new Random().nextInt(3) + 1));

            ObjectMapper mapper = new ObjectMapper();

            TextMessage message = session.createTextMessage("teste");
            String choice = "agv-" + (new Random().nextInt(3) + 1);
            System.out.println(choice);
            message.setStringProperty("agv", choice);
//            System.out.println(message.getText());
            producer.send(message);
        }

        new Scanner(System.in).nextLine();
        session.close();
        connection.close();
        context.close();
    }
}
