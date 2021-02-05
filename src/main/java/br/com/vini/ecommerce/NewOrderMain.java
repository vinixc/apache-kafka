package br.com.vini.ecommerce;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		try(var dispatcher = new KafkaDispatcher()){
			
			for(int i = 0 ; i < 10; i++) {
				
				var key = UUID.randomUUID().toString();
				var value = key + "123,567,323";
				var email = key + "Thank you for your order";
				
				dispatcher.send("ECOMMERCE_NEW_ORDER", key,value);
				dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
