package com.example.AchatLocal.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.Utilisateur;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UtilisateurService serv;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur user = serv.findByEmail(email);
		String roles = user.getRole();
		if (user != null) {
			return new User(user.getEmail(),
					user.getPassword(),
					true,
					true,
					true,
					true,
					getAuthorities(roles)
					);
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		 Collection<String> r = new ArrayList<>();
		 r.add(role);
        return getGrantedAuthorities(getPrivileges(r));
    }

    private List<String> getPrivileges(Collection<String> roles) {
 
        List<String> privileges = new ArrayList<>();
        for (String role : roles) {
            privileges.add(role);
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
