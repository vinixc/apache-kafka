package br.com.vini.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {
	
	public static void main(String[] args) {
		var emailService = new EmailService();
		
		try(var service = new KafkaService(emailService.getClass().getSimpleName(),"ECOMMERCE_SEND_EMAIL", emailService::parse)){
			service.run();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void parse(ConsumerRecord<String,String> record) {
		System.out.println("-------START EMAIL SERVICE CONSUMER----------");
		System.out.println("-------KEY: " + record.key() + "-------------");
		System.out.println("-------VALUE: " +record.value() + "----------");
		System.out.println("-------PARTITION: " +record.partition()+ "---");
		System.out.println("-------OFFSET: " + record.offset() + "-------");
		System.out.println("-------FIM EMAIL SERVICE CONSUMER -----------");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
