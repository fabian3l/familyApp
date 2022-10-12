package pl.lepsy.familyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lepsy.familyapp.model.Family;
import pl.lepsy.familyapp.model.FamilyMember;
import pl.lepsy.familyapp.repository.FamilyMemberRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyMemberService {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;
    @Autowired
    private EntityManager entityManager;

    public FamilyMember createFamilyMember(FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
        return familyMember;
    }
    public List<FamilyMember> searchFamilyMember(Long id) {
        List<FamilyMember> familyMemberList =
                entityManager.createNativeQuery("select fm.* from family_member fm inner join " +
                        "family_family_members ffm on ffm.family_members_id = fm.id where" +
                        " ffm.family_id="+id+";").getResultList();
        return familyMemberList;
    }
}
