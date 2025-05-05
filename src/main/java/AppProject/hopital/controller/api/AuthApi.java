package AppProject.hopital.controller.api;

import AppProject.hopital.entity.Personnel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthApi {

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody Personnel personnel);

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody Personnel personnel);
}
