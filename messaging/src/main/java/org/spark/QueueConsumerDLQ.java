package org.spark;

import org.spark.models.Order;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueConsumerDLQ {

    public static void main(String[] args) throws Exception {

        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination queue = (Destination) context.lookup("DLQ");
        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                try {
                    Order order = (Order) objectMessage.getObject();
                    System.out.println(order.getCodigo());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}
