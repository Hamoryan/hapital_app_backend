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

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonnelRepository personnelRepository;

    @Override
    public UserDetails loadUserByUsername(String personnelname) throws UsernameNotFoundException {
        Personnel personnel = personnelRepository.findByPersonnelname(personnelname);

        if (personnel == null){
            throw new UsernameNotFoundException("personnel not found with personnelname" + personnelname);
        }
        return new org.springframework.security.core.userdetails.User(personnel.getPersonnelname(), personnel.getPasseword(),
                Collections.singletonList(new SimpleGrantedAuthority(personnel.getRole().toString())));
    }
}
