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

    fun findAll(): List<Person>{
        logger.info("Finding all person")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0 .. 7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun createPerson(person: Person) = person

    fun updatePerson(person: Person) = person

    fun deletePerson(id: Long) {}

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "name $i"
        person.lastName = "last $i"
        person.address = "in Br $i"
        person.gender = "gender $i"
        return person;
    }
}