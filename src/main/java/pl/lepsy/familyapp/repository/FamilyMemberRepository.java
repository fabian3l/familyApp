package pl.lepsy.familyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.lepsy.familyapp.model.Family;
import pl.lepsy.familyapp.model.FamilyMember;

import java.util.List;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

//    List<FamilyMember> findAllFamilyMembersByFamilyId(Long id);

}
