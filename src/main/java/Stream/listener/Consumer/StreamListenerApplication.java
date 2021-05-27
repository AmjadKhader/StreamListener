package Stream.listener.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Filter;
import org.springframework.messaging.Message;

import java.util.Collections;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamListenerApplication {

    @StreamListener(target = Sink.INPUT
            		, condition = "headers['my header']=='amjad'")
    public void consumerMessages(Message<?> message) {
        System.out.println("\n \n \n " + message.getPayload());
    }


    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(StreamListenerApplication.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        application.run(args);
    }
}