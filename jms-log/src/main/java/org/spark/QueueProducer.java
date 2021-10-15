package org.spark;

import javax.jms.*;
import javax.naming.InitialContext;
import java.time.LocalDateTime;
import java.util.Random;

public class QueueProducer {

    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        factory.createConnection();
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Destination queue = (Destination) context.lookup("LOG");

        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 10; i++) {
            int prioroty = new Random().nextInt(10);
            String type;
            if (prioroty >= 8) {
                type = "ERROR";
            } else if (prioroty >= 5) {
                type = "WARN";
            } else if (prioroty >= 3) {
                type = "INFO";
            } else {
                type = "DEBUG";
            }
//            Message message = session.createTextMessage("TESTE");
            Message message = session.createTextMessage("[" + prioroty + "] " + type + " " + LocalDateTime.now());
            producer.send(message, DeliveryMode.NON_PERSISTENT, prioroty, 5000);
        }

        session.close();
        connection.close();
        context.close();



    }
}
