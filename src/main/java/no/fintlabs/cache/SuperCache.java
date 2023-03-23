package no.fintlabs.cache;

import lombok.RequiredArgsConstructor;
import no.fintlabs.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SuperCache {

    private final List<Person> personCache;

    public void addPerson(Person person) {
        personCache.add(person);
    }

    public List<Person> getAllPerson() {
        return personCache;
    }

}
