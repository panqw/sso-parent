package com.sso.goods.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author panqw
 * @date 2020/7/1 21:15
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue testQueue(){
        return new Queue("test.queue",true);
    }

    @Bean
    public TopicExchange testExchange(){
        return new TopicExchange("test.exchange");
    }

    @Bean
    public Binding testBinding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(testQueue()).to(testExchange()).with("test");
    }

}
