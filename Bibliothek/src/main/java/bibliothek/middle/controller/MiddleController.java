package bibliothek.middle.controller;

import bibliothek.middle.model.User;
import bibliothek.middle.service.MiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/middleuser")
public class MiddleController {

    @Autowired
    private MiddleService middleService;

    @GetMapping
    public List<User> getAll () {
        return middleService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return middleService.getById(id);
    }

    @GetMapping("/search")
    public List<User> search(@RequestParam(name = "firstName") String firstName) {
        return middleService.search(firstName);
    }

    @GetMapping("/getbyname")
    public User getByName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return middleService.getByName(firstName, lastName);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return middleService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return middleService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id) {
        return middleService.delete(id);
    }

    @GetMapping("/{field}/{param}")
    public List<User> filter(@PathVariable String field, @PathVariable String param) {
        return middleService.filter(field, param);
    }
}
