package AppProject.hopital.controller;


import AppProject.hopital.configuration.JwtUtils;
import AppProject.hopital.controller.api.AuthApi;
import AppProject.hopital.entity.Personnel;
import AppProject.hopital.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController implements AuthApi {

    private final PersonnelRepository personnelRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(Personnel personnel) {
        if (personnelRepository.findByPersonnelname(personnel.getPersonnelname()) !=null){
            return ResponseEntity.badRequest().body("personnelname is already in use");
        }
        personnel.setPasseword(passwordEncoder.encode(personnel.getPasseword()));
        return ResponseEntity.ok(personnelRepository.save(personnel));
    }

    public ResponseEntity<?> login(@RequestBody Personnel personnel){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(personnel.getPersonnelname(), personnel.getPasseword()));
            if (authentication.isAuthenticated()){
                Map<String, Object> authData = new HashMap<>();
                authData.put("token", jwtUtils.generateToken(personnel.getPersonnelname()));
                authData.put("type", "Bearer");
                return ResponseEntity.ok(authData);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid personnelname or password");
        } catch (AuthenticationException e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid personnelname or password");

        }
    }
}
