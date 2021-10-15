package org.spark;

import org.spark.models.Order;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Scanner;

public class TopicConsumerWarehouseSelector {
    public static void main(String[] args) throws Exception {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        connection.setClientID("warehouse1");

        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = (Topic) context.lookup("store");

        MessageConsumer consumer = session.createDurableSubscriber(topic, "membership-selector", "digital is null OR digital=false", false);


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


        new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close();
    }
}
