package pl.lepsy.familyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lepsy.familyapp.model.Family;
import pl.lepsy.familyapp.model.FamilyMember;
import pl.lepsy.familyapp.repository.FamilyMemberRepository;
import pl.lepsy.familyapp.repository.FamilyRepository;
import pl.lepsy.familyapp.service.FamilyMemberService;
import pl.lepsy.familyapp.service.FamilyService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/family")
@RequiredArgsConstructor
public class FamilyController {

    @Autowired
    private FamilyMemberService familyMemberService;
    @Autowired
    private FamilyService familyService;


    @PostMapping("/add")
    public String createFamily(@RequestBody Family family) {
        List<FamilyMember> familyMemberList = family.getFamilyMembers();
        if (familyService.validateFamilyData(family)) {
            for (FamilyMember fm : familyMemberList) {
                familyMemberService.createFamilyMember(fm);
            }
            familyService.createFamily(family);
            return String.valueOf(family.getId());
        }
        return "Wrong informations";
    }

    @GetMapping("/get/{id}")
    public Family getFamily(@PathVariable Long id) {
        Family family = familyService.getFamily(id);
        List<FamilyMember> familyMemberList = familyMemberService.searchFamilyMember(id);
        family.setFamilyMembers(familyMemberList);
        return family;
    }
}

