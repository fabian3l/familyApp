package pl.lepsy.familyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lepsy.familyapp.model.Family;
import pl.lepsy.familyapp.model.FamilyMember;
import pl.lepsy.familyapp.repository.FamilyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;


    public void createFamily(Family family) {
        familyRepository.save(family);
    }
    public Family getFamily(Long id) {
        Family family = familyRepository.findById(id).orElseThrow();
        return family;
    }

    public boolean validateFamilyData(Family family) {

        List<FamilyMember> familyMemberList = family.getFamilyMembers();
        int infantsQua = 0;
        int childrenQua = 0;
        int adultQua = 0;

        for (FamilyMember fm : familyMemberList) {
            int thisAge = fm.getAge();
            if (thisAge >= 0 && thisAge < 4) {
                infantsQua++;
            }else if (thisAge >= 4 && thisAge < 16) {
                childrenQua++;
            }else if (thisAge >= 16) {
                adultQua++;
            }
        }

        if (family.getNrOfAdults() == adultQua &&
            family.getNrOfChildren() == childrenQua &&
            family.getNrOfInfants() == infantsQua) {
            return true;
        }
        return false;
    }
}
