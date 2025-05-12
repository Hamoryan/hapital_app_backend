package AppProject.hopital.service.impl;

import AppProject.hopital.entity.Personnel;
import AppProject.hopital.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonnelRepository personnelRepository;

    @Override
    public UserDetails loadUserByUsername(String personnelname) throws UsernameNotFoundException {
        Optional<Personnel> personnel = personnelRepository.findByPersonnelname(personnelname);

        if (personnel.isEmpty()){
            throw new UsernameNotFoundException("personnel not found with personnelname" + personnelname);
        }
        return new org.springframework.security.core.userdetails.User(personnel.get().getPersonnelname(), personnel.get().getPasseword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" +personnel.get().getRole().toString())));
    }
}
