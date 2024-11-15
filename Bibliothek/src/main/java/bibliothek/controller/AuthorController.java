package bibliothek.controller;


import bibliothek.entity.Author;
import bibliothek.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService service;

//  GET ----------------------------------------------------------------------------------------------------------------

    @GetMapping
    public List<Author> getAll () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/name")
    public Author getByName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return service.getByName(firstName, lastName);
    }

//  POST ---------------------------------------------------------------------------------------------------------------


//  DELETE -------------------------------------------------------------------------------------------------------------

}









































