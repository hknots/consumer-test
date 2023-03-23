package no.fintlabs.model;

import lombok.RequiredArgsConstructor;
import no.fintlabs.kafka.PersonConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("person")
@RestController
public class PersonController {

    private final PersonConsumer personConsumer;

    @GetMapping
    public List<Person> getPersons() {
        return personConsumer.getSuperCache().getAllPerson();
    }
}
