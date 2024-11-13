package bibliothek.last.controller;

import bibliothek.last.entity.User;
import bibliothek.last.service.LastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliothek")
public class LastController {

    @Autowired
    private LastService service;

    @GetMapping
    public List<User> getALL() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @DeleteMapping
    public User delete(@RequestParam(name = "id") int id) {
        return service.delete(id);
    }
}
