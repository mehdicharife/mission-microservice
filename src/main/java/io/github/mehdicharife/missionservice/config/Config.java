package io.github.mehdicharife.missionservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Config {
    
    private static final String QUEUE_NAME = "mission-request-approved-mission-service-queue";


    @Bean
    public FanoutExchange missionRequestApprovedExchange() {
        return new FanoutExchange("mission-request-approved");
    }


    @Bean
    public Queue missionRequestApprovedQueue() {
        return new Queue(QUEUE_NAME, false);
    }


    @Bean
    public Binding binding(FanoutExchange missionRequestApprovedExchange, Queue missionRequestApprovedQueue) {
        return BindingBuilder.bind(missionRequestApprovedQueue).to(missionRequestApprovedExchange);
    }


    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }


    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, MessageConverter jsonMessageConverter) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }
}
