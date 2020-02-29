package de.jangerber.videoanalysis.services;

import de.jangerber.videoanalysis.entities.Customer;
import de.jangerber.videoanalysis.exception.UsernameExistsException;
import de.jangerber.videoanalysis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer = userRepo.findByUsername(userName);
        if (customer == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(), getAuthority(customer));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Customer customer) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        customer.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public Customer getUserByName(String username) {
        Customer customer = userRepo.findByUsername(username);
        return customer;
    }

    public Customer registerNewUserAccount(Customer customer) throws UsernameExistsException {
        if (usernameExist(customer.getUsername())) {
            throw new UsernameExistsException(
                    "There is an account with that user name:" + customer.getUsername());
        }

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return userRepo.save(customer);
    }

    private boolean usernameExist(String username) {
        Customer customer = userRepo.findByUsername(username);
        return customer != null;
    }
}
