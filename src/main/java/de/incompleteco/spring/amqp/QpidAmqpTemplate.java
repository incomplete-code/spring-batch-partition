package de.incompleteco.spring.amqp;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * rough qpid template
 * @author Will
 *
 */
public class QpidAmqpTemplate implements AmqpTemplate {
	
	private String exchange;
	
	private String routingKey;
	
	private ConnectionFactory connectionFactory;
	
	private Destination destination;
	
	@Override
	public void send(Message message) throws AmqpException {
		send(this.exchange,this.routingKey,message);
	}

	@Override
	public void send(String routingKey, Message message) throws AmqpException {
		send(this.exchange,routingKey,message);
	}

	@Override
	public void send(String exchange, String routingKey, Message message) throws AmqpException {
		if (exchange == null) {
			exchange = this.exchange;
		}//end if
		if (routingKey == null) {
			routingKey = this.routingKey;
		}//end if
		try {
			//open a session
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			//send
//			org.apache.qpid.jms.Message msg = new org.apache.qpid.jms.JMSObjectMessage();
//			producer.send(session.createObjectMessage(message));
			//close the session
		}
		catch (JMSException e) {
			throw new AmqpException(e);
		}
	}
	
	@Override
	public void convertAndSend(Object message) throws AmqpException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertAndSend(String routingKey, Object message)
			throws AmqpException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertAndSend(String exchange, String routingKey,
			Object message) throws AmqpException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertAndSend(Object message,
			MessagePostProcessor messagePostProcessor) throws AmqpException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertAndSend(String routingKey, Object message,
			MessagePostProcessor messagePostProcessor) throws AmqpException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertAndSend(String exchange, String routingKey,
			Object message, MessagePostProcessor messagePostProcessor)
			throws AmqpException {
		// TODO Auto-generated method stub

	}

	@Override
	public Message receive() throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receive(String queueName) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object receiveAndConvert() throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object receiveAndConvert(String queueName) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message sendAndReceive(Message message) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message sendAndReceive(String routingKey, Message message)
			throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message sendAndReceive(String exchange, String routingKey,
			Message message) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convertSendAndReceive(Object message) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convertSendAndReceive(String routingKey, Object message)
			throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convertSendAndReceive(String exchange, String routingKey,
			Object message) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convertSendAndReceive(Object message,
			MessagePostProcessor messagePostProcessor) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convertSendAndReceive(String routingKey, Object message,
			MessagePostProcessor messagePostProcessor) throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object convertSendAndReceive(String exchange, String routingKey,
			Object message, MessagePostProcessor messagePostProcessor)
			throws AmqpException {
		// TODO Auto-generated method stub
		return null;
	}

}
