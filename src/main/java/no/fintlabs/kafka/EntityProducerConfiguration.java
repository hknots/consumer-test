package no.fintlabs.kafka;

import no.fintlabs.kafka.entity.EntityProducer;
import no.fintlabs.kafka.entity.EntityProducerFactory;
import no.fintlabs.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityProducerConfiguration {

    private final EntityProducerFactory entityProducerFactory;

    public EntityProducerConfiguration(EntityProducerFactory entityProducerFactory) {
        this.entityProducerFactory = entityProducerFactory;
    }

    @Bean
    public EntityProducer<Person> personEntityProducer() {
        return entityProducerFactory.createProducer(Person.class);
    }
}
