package no.fintlabs.kafka;


import no.fintlabs.kafka.entity.EntityProducer;
import no.fintlabs.kafka.entity.EntityProducerRecord;
import no.fintlabs.kafka.entity.topic.EntityTopicNameParameters;
import no.fintlabs.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonProducer {

    private final EntityProducer<Person> entityProducer;

    public PersonProducer(EntityProducer<Person> entityProducer) {
        this.entityProducer = entityProducer;
    }

    public void send(Person person) {
        // Lag en EntityTopicNameParameters


        // Lag en EntityProducerRecord av Person


        // Send entityProducerRecord

    }

}
