package pl.lepsy.familyapp.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String familyName;
    @NotNull
    private int nrOfInfants;
    @NotNull
    private int nrOfChildren;
    @NotNull
    private int nrOfAdults;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FamilyMember> familyMembers;

    public Family () {

    }

}
