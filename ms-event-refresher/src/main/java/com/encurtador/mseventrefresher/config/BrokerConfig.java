package com.encurtador.mseventrefresher.config;

import com.encurtador.mseventrefresher.service.EventListenerImpl;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * Broker Configuration.
 */
@Configuration
@ConfigurationProperties(prefix = "broker")
public class BrokerConfig {

    /**
     * Broker address.
     */
    private String addresses;

    /**
     * Broker username.
     */
    private String username;

    /**
     * Broker password.
     */
    private String password;

    /**
     * Broker exchange.
     */
    private String exchange;

    /**
     * Routing key refresh.
     */
    private String routingKeyRefresh;

    private String queue;

    /**
     * Configures the ConnectionFactory bean.
     *
     * @return An instance of ConnectionFactory.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cf = new CachingConnectionFactory();
        cf.setAddresses(this.addresses);
        cf.setUsername(this.username);
        cf.setPassword(this.password);

        return cf;
    }

    /**
     * Configures the RabbitTemplate bean.
     *
     * @param connectionFactory The ConnectionFactory to be used by the template.
     * @return An instance of RabbitTemplate.
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
        rabbitTemplate.setRetryTemplate(retryTemplate);

        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public TopicExchange eventExchange() {
        return new TopicExchange(this.exchange);
    }

    @Bean
    public Queue queue() {
        return new Queue(this.queue);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange eventExchange) {
        return BindingBuilder.bind(queue).to(eventExchange).with(getRoutingKeyRefresh());
    }

    @Bean
    public EventListenerImpl eventReceiver() {
        return new EventListenerImpl();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    /**
     * Sets new Broker exchange..
     *
     * @param exchange New value of Broker exchange..
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * Sets new Broker username..
     *
     * @param username New value of Broker username..
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets Broker password..
     *
     * @return Value of Broker password..
     */
    public String getPassword() {
        return password;
    }


    /**
     * Gets Broker username..
     *
     * @return Value of Broker username..
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets new Broker address..
     *
     * @param addresses New value of Broker address..
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets Broker exchange..
     *
     * @return Value of Broker exchange..
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * Sets new Broker password..
     *
     * @param password New value of Broker password..
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets Broker address..
     *
     * @return Value of Broker address..
     */
    public String getAddresses() {
        return addresses;
    }

    public String getRoutingKeyRefresh() {
        return routingKeyRefresh;
    }

    public void setRoutingKeyRefresh(String routingKeyRefresh) {
        this.routingKeyRefresh = routingKeyRefresh;
    }

}
