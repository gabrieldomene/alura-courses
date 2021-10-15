package org.spark.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.UUID;

public class TestConsumerTopicWarehouse {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        String connPrefix = "Spark2-Warehouse";
        connection.setClientID(connPrefix);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = (Topic) context.lookup("store");
        MessageConsumer consumer = session.createDurableSubscriber(topic, "agv-checkpoint3",
                "agv='agv2'", false);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage text = (TextMessage) message;
                try {
                    System.out.println("Receiving message " + " with " + text.getStringProperty("agv"));
                    Thread.sleep(1000);
                } catch (JMSException | InterruptedException e) {
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
