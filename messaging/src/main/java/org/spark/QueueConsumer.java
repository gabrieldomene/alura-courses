package org.spark;

import javax.jms.*;
import javax.naming.InitialContext;

public class QueueConsumer {

    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        factory.createConnection();

        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
        Destination queue = (Destination) context.lookup("financial");
        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {

                TextMessage textMessage = (TextMessage) message;
                try {
//                    message.acknowledge();
                    System.out.println(((TextMessage) message).getText());
                    session.rollback();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
