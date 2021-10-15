package org.spark.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.UUID;

public class TestConsumerQueue {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        String connPrefix = "Spark-";
        connection.setClientID(connPrefix + UUID.randomUUID().toString().split("-")[0]);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination queue = (Destination) context.lookup("financial");
//        MessageConsumer consumer = session.createConsumer(queue);
        QueueBrowser browser = session.createBrowser((Queue) queue);

        Enumeration msgs = browser.getEnumeration();
        while (msgs.hasMoreElements()) {
            TextMessage msg = (TextMessage) msgs.nextElement();
            System.out.println("Message: " + msg.getText());
        }

//        consumer.setMessageListener(new MessageListener() {
//
//            @Override
//            public void onMessage(Message message) {
//                TextMessage text = (TextMessage) message;
//                try {
//                    System.out.println("Receiving message " + text.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        new Scanner(System.in).nextLine();
        session.close();
        connection.close();
        context.close();
    }
}
