package br.com.vini.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		try(var orderDispatcher = new KafkaDispatcher<Order>();
			var emailDispatcher = new KafkaDispatcher<Email>()){
			
			for(int i = 0 ; i < 10; i++) {
				
				var userId = UUID.randomUUID().toString();
				var orderId = UUID.randomUUID().toString();
				var amount = new BigDecimal(Math.random() * 5000 + 1);
				
				Order order = new Order(userId, orderId, amount);
				
				orderDispatcher.send("ECOMMERCE_NEW_ORDER", userId,order);
				
				
				var subject = "Pedido em processamento!";
				var body = "Thank you for your order! We are processing your order!";
				
				Email email = new Email(subject, body);
				
				emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userId, email);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
