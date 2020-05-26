package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Venue.findAll", query = "select v from Venue as v")
})
@Table(name = "Venue")
@Getter
@Setter
public class Venue {
    public Venue(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "venue_address", nullable = true, length = 40)
    private String venueAddress;

    @Basic
    @Column(name = "venue_name", nullable = true, length = 30)
    private String venueName;

    @OneToMany(mappedBy = "venue", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Club> clubs = new ArrayList<>();

   @Basic
   @Column(name = "venue_price")
   private double venuePrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return id == venue.id &&
                Objects.equals(venueAddress, venue.venueAddress) &&
                Objects.equals(venueName, venue.venueName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, venueAddress, venueName);
    }
}
