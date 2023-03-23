package no.fintlabs.model;

import lombok.RequiredArgsConstructor;
import no.fintlabs.kafka.PersonProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("person")
@RestController()
public class PersonController {

    private final PersonProducer personProducer;

    @PostMapping
    public void post(@RequestBody Person person) {
        personProducer.send(person);
    }
}
