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
public class AgentRestController {

	@Autowired
	private AgentDAO agentDAO;
	private Agent agent;

	@GetMapping("/Agent")
	public List list() throws Exception {
		System.out.println("function inside agent rest");
		System.out.println(agent+" all the data");
		return agentDAO.list();
	}

	@GetMapping("/Agent/{agent_id}")
	public ResponseEntity getAgentById(@PathVariable("agent_id") int agent_id) {

		Agent ag1 = agentDAO.getAgentById(agent_id);
		if (ag1 == null) {
			return new ResponseEntity("No Agent found for ID " + agent_id, HttpStatus.NOT_FOUND);
		}


		return new ResponseEntity(ag1, HttpStatus.OK);
	}

	@PostMapping(value = "/post/Agent")
	public ResponseEntity addAgent(@RequestBody Agent agent) {
		System.out.println("funtion going to add ");
		System.out.println(agent);
		

		agentDAO.addAgent(agent);

		return new ResponseEntity(agent, HttpStatus.OK);
	}

	//@DeleteMapping("/delete/Agent/{agent_id}")
	//public ResponseEntity deleteAgent(@PathVariable int agent_id) throws SQLException {
	// if (null == agentDAO.deleteAgent(agent)) {
		// return new ResponseEntity("No Customer found for ID " + agent_id,
		// HttpStatus.NOT_FOUND);
		// }
		
		//agentDAO.deleteAgent(agent);
		//return new ResponseEntity(agent_id, HttpStatus.OK);

	//}
	
	@DeleteMapping("/delete/Agent/{agent_id}")
	public ResponseEntity deleteAgent(@PathVariable int agent_id) throws SQLException {
	// if (null == agentDAO.deleteAgent(agent)) {
		// return new ResponseEntity("No Customer found for ID " + agent_id,
		// HttpStatus.NOT_FOUND);
		// }
		
		agentDAO.deleteAgent(agent_id);
		return new ResponseEntity(agent_id, HttpStatus.OK);

	}

	@PutMapping("/put/Agent/{agent_id}")
	public ResponseEntity updateAgent(@PathVariable int agent_id, @RequestBody Agent agent) {
		
		// if (null == customer) {
		// return new ResponseEntity("No Customer found for ID " + id,
		// HttpStatus.NOT_FOUND);
		// }
		agentDAO.updateAgent(agent);
		return new ResponseEntity(agent, HttpStatus.OK);
	}
}