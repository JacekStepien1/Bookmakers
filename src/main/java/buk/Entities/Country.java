package buk.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

    @Id
    private Long id;

    private String country;

    private String leagueName;

    @OneToMany(mappedBy = "country")
    private List<Teams> teamsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Teams> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Teams> teamsList) {
        this.teamsList = teamsList;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }


}
