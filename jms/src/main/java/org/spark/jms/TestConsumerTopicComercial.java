package org.spark.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;

public class TestConsumerTopicComercial {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        String connPrefix = "Spark-Comercial";
        connection.setClientID(connPrefix);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = (Topic) context.lookup("store");
        MessageConsumer consumer = session.createDurableSubscriber(
                topic, "agv-checkpoint1",
                "agv='agv3'",
                false);

        consumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                TextMessage text = (TextMessage) message;
                try {
                    System.out.println("Receiving message "
                            + text.getText()
                            + " with "
                            + text.getStringProperty("agv"));
                } catch (JMSException e) {
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
