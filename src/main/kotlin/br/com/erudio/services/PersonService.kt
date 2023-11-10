package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    val counter: AtomicLong = AtomicLong()
    private  val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person{
        logger.info("Finding one person")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "name"
        person.lastName = "last"
        person.address = "add"
        person.gender = "gender"
        return person;
    }
}