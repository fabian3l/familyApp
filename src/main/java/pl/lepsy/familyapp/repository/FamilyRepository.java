package pl.lepsy.familyapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lepsy.familyapp.model.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
}
