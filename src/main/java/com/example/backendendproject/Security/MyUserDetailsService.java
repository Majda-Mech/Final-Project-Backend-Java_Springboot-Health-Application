package com.example.backendendproject.Security;//package com.example.endprojectsmechapplication.Security;
//
//import com.example.endprojectsmechapplication.Services.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    private final UserService userService;
//    public MyUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//
////    @Override
////    public UserDetails loadUserByUsername(String username) {
////        UserDto userDto = userService.getUser(username);
////        String password = userDto.getPassword();
////        String[] roles = userDto.getRoles();
////        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
////        for (Role authority: roles) {
////            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
////        }
////
////        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
////    }
//}