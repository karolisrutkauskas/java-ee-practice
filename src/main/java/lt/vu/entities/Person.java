package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select p from Person as p")
})
@Table(name = "Person")
@Getter
@Setter
public class Person {
    public Person(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "first_name", nullable = true, length = 20)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = true, length = 20)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    private String email;

    @ManyToMany
    @JoinTable(name = "Participation")
    private List<Club> clubs = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
