package org.spark.jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.spark.jms.models.AgvStatus;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;

public class TestConsumerTopicWarehouseSelector {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        String connPrefix = "Spark2-WarehouseSelector";
        connection.setClientID(connPrefix);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = (Topic) context.lookup("store");
        MessageConsumer consumer = session.createDurableSubscriber(
                topic, "agv-checkpoint2",
                "agv='agv1'", false
        );

        ObjectMapper objectMapper = new ObjectMapper();
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage text = (TextMessage) message;
                try {
                    AgvStatus agvStatus = objectMapper.readValue(text.getText(), AgvStatus.class);
                    System.out.println("RECEBIDO: " + agvStatus.getName() + " "+ agvStatus.getPosition());
                } catch (JsonProcessingException | JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        new Scanner(System.in).nextLine();
        session.close();
        connection.close();
        context.close();
    }
}
