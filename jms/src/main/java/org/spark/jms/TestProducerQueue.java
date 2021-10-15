package org.spark.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;
import java.util.UUID;

public class TestProducerQueue {

    public static void main(String[] args) throws Exception {


        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();

        String connPrefix = "Spark-";
        connection.setClientID(connPrefix + UUID.randomUUID().toString().split("-")[0]);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination queue = (Destination) context.lookup("financial");

        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 1000; i++) {
            Message message = session.createTextMessage("sent to queue " + i);
            producer.send(message);
            System.out.println("Message sent to queue " + i);
        }

        new Scanner(System.in).nextLine();
        session.close();
        connection.close();
        context.close();
    }
}
