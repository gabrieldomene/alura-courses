package org.spark;

import javax.jms.*;
import javax.naming.InitialContext;

public class QueueProducer {

    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        factory.createConnection();
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Destination queue = (Destination) context.lookup("financial");

        MessageProducer producer = session.createProducer(queue);

        Message message = session.createTextMessage("financial aid available");
        producer.send(message);
//        for (int i = 0; i < 10; i++) {
//            Message message = session.createTextMessage("financial aid available");
//            producer.send(message);
//        }

        session.close();
        connection.close();
        context.close();



    }
}
