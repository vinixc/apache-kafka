package br.com.vini.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudDetectorService {
	
	public static void main(String[] args) {
		
		FraudDetectorService fraudService = new FraudDetectorService();
		var service = new KafkaService(
				fraudService.getClass().getSimpleName(),"ECOMMERCE_NEW_ORDER", fraudService::parse);
		
		service.run();
		
	}
	
	public void parse(ConsumerRecord<String, String> record) {
		System.out.println("----------------------------------------------");
		System.out.println("processando new order, checking for fraud");
		System.out.println(record.key());
		System.out.println(record.value());
		System.out.println(record.partition());
		System.out.println(record.offset());
		System.out.println("----------------------------------------------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
