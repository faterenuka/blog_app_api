package com.blog.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.entity.User;
import com.blog.exception.ApiException;
import com.blog.payloads.JWTAuthResponse;
import com.blog.payloads.JwtAuthRequest;
import com.blog.payloads.UserDTO;
import com.blog.repository.UserRepo;
import com.blog.security.JWTTokenHelper;
import com.blog.service.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {


	@Autowired
	private JWTTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping("login")
	public ResponseEntity<JWTAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
		this.authenticate(request.getUserName(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUserName());
		String token = this.jwtTokenHelper.generateToken(userDetails);

		JWTAuthResponse response = new JWTAuthResponse();
		response.setToken(token);
		response.setUser(this.mapper.map((User) userDetails, UserDTO.class));
		return new ResponseEntity<JWTAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			this.authenticationManager.authenticate(authenticationToken);

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Detials !!");
			throw new ApiException("Invalid username or password !!");
		}

	}

	// register new user api

	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO registeredUser = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDTO>(registeredUser, HttpStatus.CREATED);
	}

	// get loggedin user data
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/current-user/")
	public ResponseEntity<UserDTO> getUser(Principal principal) {
		User user = this.userRepo.findByEmail(principal.getName()).get();
		return new ResponseEntity<UserDTO>(this.mapper.map(user, UserDTO.class), HttpStatus.OK);
	}
}
