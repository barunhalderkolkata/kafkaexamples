import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by barun.h on 18/08/18.
 */
public class KafkaProducerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "3");
        properties.setProperty("linger.ms", "1");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
        for(int i=0; i<10; i++){
            int key = i%3;
            ProducerRecord<String, String> producerRecord =
                    new ProducerRecord<String, String>("second_topic", Integer.toString(key), "message:" + Integer.toString(i));

            producer.send(producerRecord);
        }
        producer.close();

    }
}
