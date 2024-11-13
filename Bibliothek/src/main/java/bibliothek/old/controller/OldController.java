package bibliothek.old.controller;

import bibliothek.old.model.User;
import bibliothek.old.service.OldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/olduser")
public class OldController {

    @Autowired
    private OldService oldService;


    @GetMapping
    public List<User> getAll() {
        return oldService.getAll();
    }

    @GetMapping("/id")
    public User getById(@RequestParam(name = "id") int id) {
        return oldService.getById(id);
    }

    @GetMapping("/searchbyname")
    public User getByName(@RequestParam (name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return oldService.getByName(firstName, lastName);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return oldService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return oldService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id) {
        return oldService.delete(id);
    }

    @GetMapping("/{field}/{param}")
    public List<User> filter(@PathVariable String field, @PathVariable String param) {
        return oldService.filter(field, param);
    }
}
