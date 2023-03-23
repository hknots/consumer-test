package no.fintlabs.kafka;

import lombok.extern.slf4j.Slf4j;
import no.fintlabs.cache.SuperCache;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicNameParameters;
import no.fintlabs.model.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.CommonLoggingErrorHandler;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class PersonConsumer {

    private final EntityConsumerFactoryService entityConsumerFactoryService;
    private final SuperCache superCache;


    public PersonConsumer(EntityConsumerFactoryService entityConsumerFactoryService, SuperCache superCache) {
        this.entityConsumerFactoryService = entityConsumerFactoryService;
        this.superCache = superCache;
    }

    @PostConstruct
    public void init() {
        entityConsumerFactoryService.createFactory(
                Person.class,
                consumerRecord -> addToCache(consumerRecord.value()),
                new CommonLoggingErrorHandler()
        ).createContainer(
                EntityTopicNameParameters
                        .builder()
                        .orgId("fintlabs-no")
                        .domainContext("fint-core")
                        .resource("person")
                        .build()
        );
    }

    public void addToCache(Person person) {
        log.info(person.toString());
        superCache.addPerson(person);
    }

    public SuperCache getSuperCache() {
        return superCache;
    }

}
