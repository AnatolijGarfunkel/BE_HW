package bibliothek.last.repository;

import bibliothek.last.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastRepository extends JpaRepository<User, Integer> {
}

