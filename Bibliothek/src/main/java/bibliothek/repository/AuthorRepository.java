package bibliothek.repository;

import bibliothek.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("select a from Author a where a.firstName =:firstName and a.lastName =:lastName")
    Author findAuthorByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
