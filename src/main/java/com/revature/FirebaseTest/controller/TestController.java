package com.revature.FirebaseTest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

@RestController
@CrossOrigin
public class TestController {

	@PostMapping("")
	public String test(HttpServletRequest req ) {
		try {
			System.out.println(req.getHeader("auth"));
			FirebaseAuth.getInstance().verifyIdToken(req.getHeader("auth"));
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed!";
		}
		return "Success";
	}
}
