package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Club.findAll", query = "select c from Club as c")
})
@Table(name = "Club")
@Getter
@Setter
public class Club {
    public Club(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Basic
    @Column(name = "start_time", nullable = true)
    private Time startTime;

    @Basic
    @Column(name = "end_time", nullable = true)
    private Time endTime;

    @ManyToMany(mappedBy = "clubs")
    public List<Person> people = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "venue")
    private Venue venue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return id == club.id &&
                Objects.equals(name, club.name) &&
                Objects.equals(startTime, club.startTime) &&
                Objects.equals(endTime, club.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startTime, endTime);
    }
}
