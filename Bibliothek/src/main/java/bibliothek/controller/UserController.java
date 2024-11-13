package bibliothek.controller;

import bibliothek.entity.User;
import bibliothek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliothek")
public class UserController {

    @Autowired
    private UserService service;

//  GET ----------------------------------------------------------------------------------------------------------------

    @GetMapping
    public List<User> getALL() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return service.getById(id);
    }

//  POST ---------------------------------------------------------------------------------------------------------------

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return service.update(id, user);
    }

//  DELETE -------------------------------------------------------------------------------------------------------------

    @DeleteMapping
    public User delete(@RequestParam(name = "id") int id) {
        return service.delete(id);
    }
}
