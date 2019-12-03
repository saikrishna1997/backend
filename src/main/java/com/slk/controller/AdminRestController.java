package com.slk.controller;

import com.slk.DAO.*;
import com.slk.model.*;
import com.slk.util.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class AdminRestController {
	@Autowired
	private AdminDAO adminDAO;
	private Admin admin;

	@GetMapping("/Admin/{username}/{password}")
	public ResponseEntity getAgentById(@PathVariable("username") String username ,@PathVariable("password") String password) throws Exception {
		boolean ad = adminDAO.login(username,password);
		return new ResponseEntity(ad, HttpStatus.OK);

	}

}
