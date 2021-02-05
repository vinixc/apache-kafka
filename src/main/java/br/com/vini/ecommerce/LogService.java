package br.com.vini.ecommerce;

import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class LogService {

	public static void main(String[] args) {

		LogService logService = new LogService();
		try (var service = new KafkaService(logService.getClass().getSimpleName(), Pattern.compile("ECOMMERCE.*"), logService::parse)) {
			
			service.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parse(ConsumerRecord<String, String> record) {
		System.out.println("-------START LOG SERVICE CONSUMER----------");
		System.out.println("-------KEY: " + record.key() + "-------------");
		System.out.println("-------VALUE: " + record.value() + "----------");
		System.out.println("-------PARTITION: " + record.partition() + "---");
		System.out.println("-------OFFSET: " + record.offset() + "-------");
		System.out.println("-------FIM LOG SERVICE CONSUMER -----------");
	}
}
