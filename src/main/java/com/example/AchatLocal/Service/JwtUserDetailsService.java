package com.example.AchatLocal.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AchatLocal.Model.Role;
import com.example.AchatLocal.Model.Utilisateur;
import com.example.AchatLocal.Repository.UtilisateurRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UtilisateurRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Utilisateur> user = repo.findByEmail(email);
		Role roles = user.get().getRole();
		if (user.isPresent()) {
			return new User(user.get().getEmail(),
					user.get().getPassword(),
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
	
	private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
		 Collection<Role> r = new ArrayList<>();
		 r.add(role);
        return getGrantedAuthorities(getPrivileges(r));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
 
        List<String> privileges = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getNom());
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
