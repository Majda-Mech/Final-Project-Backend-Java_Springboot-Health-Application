package com.example.backendendproject.Controller;//package com.example.endprojectsmechapplication.Contoller;
//
//import com.example.endprojectsmechapplication.Dtos.AuthDto;
//import com.example.endprojectsmechapplication.Dtos.AuthenticationResponse;
//import com.example.endprojectsmechapplication.Security.JwtService;
//import com.example.endprojectsmechapplication.Security.MyUserDetailsService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@CrossOrigin
//@RestController
//public class AuthenticationController {
//    private final AuthenticationManager authenticationManager;
//    private final MyUserDetailsService userDetailsService;
//    private final JwtService jwtService;
//    public AuthenticationController(AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtService jwtService) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtService = jwtService;
//    }
//
//    @GetMapping(value = "/authenticated")
//    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
//        return ResponseEntity.ok().body(principal);
//    }
//
//    @PostMapping(value = "/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthDto authenticationRequest)
//            throws Exception {
//
//        String username = authenticationRequest.getUsername();
//        String password;
//        password = authenticationRequest.getPassword();
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//        }
//        catch (BadCredentialsException ex) {
//            throw new Exception("Incorrect username or password", ex);
//        }
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(username);
//        final String jwt = jwtService.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }
//}