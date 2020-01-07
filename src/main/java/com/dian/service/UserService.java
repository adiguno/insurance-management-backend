package com.dian.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dian.model.Role;
import com.dian.model.User;
import com.dian.repository.RoleRepository;
import com.dian.repository.UserRepository;
import com.dian.security.JwtProvider;

/**
 * @author guodi
 *
 */

@Service
public class UserService {
	
    private static final Logger logger = LogManager.getLogger(UserService.class);
	
	public final UserRepository userRepository;
	private final RoleRepository roleRepository;

	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	private JwtProvider jwtProvider;
	

    @Autowired
    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    /**
     * Sign in a user into the application, with JWT-enabled authentication
     *
     * @param username  username
     * @param password  password
     * @return Optional of the Java Web Token, empty otherwise
     */
    public Optional<String> signin(String username, String password) {
    	logger.debug("New user attempting to sign in");
        Optional<String> token = Optional.empty();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username, user.get().getRoles()));
            } catch (AuthenticationException e){
            	logger.debug("Log in failed for user: {}", username);
            	logger.debug("Log in failed for password: {}", password);
            }
        }
        return token;
    }

    /**
     * Create a new branch manager user in the database.
     *
     * @param username username
     * @param password password
     * @param firstName first name
     * @param lastName last name
     * @return Optional of user, empty if the user already exists.
     */
    public Optional<User> signupBranchManager(String username, String password) {
    	logger.debug("New bm user attempting to sign up");
        Optional<User> user = Optional.empty();
        if (!userRepository.findByUsername(username).isPresent()) {
            Optional<Role> role = roleRepository.findByRoleName("ROLE_BM");
            user = Optional.of(userRepository.save(new User(username,
                            passwordEncoder.encode(password),
                            role.get())));
        }
        return user;
    }
    public Optional<User> signupAgent(String username, String password) {
    	logger.debug("New agent user attempting to sign up");
        Optional<User> user = Optional.empty();
        if (!userRepository.findByUsername(username).isPresent()) {
            Optional<Role> role = roleRepository.findByRoleName("ROLE_CSR");
            user = Optional.of(userRepository.save(new User(username,
                            passwordEncoder.encode(password),
                            role.get())));
        }
        return user;
    }
    public Optional<User> signupCustomer(String username, String password) {
    	logger.debug("New customer user attempting to sign up");
        Optional<User> user = Optional.empty();
        if (!userRepository.findByUsername(username).isPresent()) {
            Optional<Role> role = roleRepository.findByRoleName("ROLE_C");
            user = Optional.of(userRepository.save(new User(username,
                            passwordEncoder.encode(password),
                            role.get())));
        }
        return user;
    }
    
    public List<User> getAll() {
    	List<User> allUser = new ArrayList<>();
    	userRepository.findAll().forEach(allUser::add);
        return allUser;
    }
	
}
