package bibliothek.middle.model;

import bibliothek.enums.OriginLand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private OriginLand land;
}
