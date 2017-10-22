package com.karnov.activeMq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Artem Karnov @date 10/22/2017.
 * artem.karnov@t-systems.com
 */
public class Receiver {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String subject = "JCG_QUEUE";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("com,java.util".split(","))));

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(subject);
        MessageConsumer consumer = session.createConsumer(destination);

        while (true) {
            try {
                Message objectMessage = consumer.receive();
                if (objectMessage instanceof ObjectMessage) {
                    SimpleMessage object = (SimpleMessage) ((ObjectMessage) objectMessage).getObject();
                    System.out.println(object);
                }
            } catch (Exception ex) {
                System.out.println("Skip message " + ex);
            }
        }
//        connection.close();
    }
}
