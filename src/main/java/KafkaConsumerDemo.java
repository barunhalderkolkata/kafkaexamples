import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;


import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by barun.h on 18/08/18.
 */
public class KafkaConsumerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        properties.setProperty("group.id", "test1243");
        properties.setProperty("enable.auto.commit", "true");
        properties.setProperty("auto.commit.interval.ms", "1000");
        properties.setProperty("auto.offset.reset", "earliest");


        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList("second_topic"));

        Duration duration = Duration.ofMillis(1000);
        while (true){
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(100);
//            System.out.println("Size of ProducerRecords: " + consumerRecords.count());
            for(ConsumerRecord<String, String> consumerRecord: consumerRecords){
//                consumerRecord.partition();
//                consumerRecord.offset();
//                consumerRecord.key();
//                consumerRecord.value();
                System.out.println("Partition: " + consumerRecord.partition()
                                    + "Offset: " + consumerRecord.offset()
                                    + "Key: " + consumerRecord.key()
                                    + "Value: " + consumerRecord.value());
            }
        }
    }
}
