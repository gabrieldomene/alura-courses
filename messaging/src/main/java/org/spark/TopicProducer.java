package org.spark;

import org.spark.models.Order;
import org.spark.models.OrderFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.util.Random;

public class TopicProducer {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination topic = (Destination) context.lookup("DLQ");

        MessageProducer producer = session.createProducer(topic);

        Order order = new OrderFactory().geraPedidoComValores();

//        StringWriter writer = new StringWriter();
//        JAXB.marshal(order, writer);
//        String xml = writer.toString();
//        System.out.println(xml);

        Message message = session.createObjectMessage(order);
        producer.send(message);
//        for (int i = 0; i < 15; i++) {
//            int number = new Random().nextInt(3000);
//            boolean digital = number % 2 == 0;
////            Message message = session.createTextMessage("id: " + number + " - digital: " + digital);
//            message.setBooleanProperty("digital", digital);
//            producer.send(message);
//        }

        session.close();
        connection.close();
        context.close();
    }
}
