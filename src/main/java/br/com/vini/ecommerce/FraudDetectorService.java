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
		System.out.println("-------START FRAUD SERVICE CONSUMER----------");
		System.out.println("-------KEY: " + record.key() + "-------------");
		System.out.println("-------VALUE: " +record.value() + "----------");
		System.out.println("-------PARTITION: " +record.partition()+ "---");
		System.out.println("-------OFFSET: " + record.offset() + "-------");
		System.out.println("-------FIM FRAUD SERVICE CONSUMER -----------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
