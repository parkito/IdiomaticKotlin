package com.karnov.activeMq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.util.Date;

/**
 * @author Artem Karnov @date 10/22/2017.
 * artem.karnov@t-systems.com
 */
public class Sender {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String subject = "JCG_QUEUE";

    public static void main(String[] args) throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageProducer producer = session.createProducer(destination);

        while (true) {
            SimpleMessage simpleMessage = new SimpleMessage(new Date(), Thread.currentThread().getName());
            ObjectMessage message = session.createObjectMessage();
            message.setObject(simpleMessage);
            System.out.println(simpleMessage);
            producer.send(message);
        }
//        connection.close();
    }
}
