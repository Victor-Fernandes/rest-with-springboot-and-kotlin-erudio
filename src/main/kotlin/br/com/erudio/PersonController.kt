package br.com.erudio

import br.com.erudio.model.Person
import br.com.erudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var  service: PersonService
    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun search(@PathVariable(value = "id") id: Long): Person {
        return service.findById(id)
    }
}