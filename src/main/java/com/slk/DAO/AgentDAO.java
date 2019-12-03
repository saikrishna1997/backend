package com.slk.DAO;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.slk.model.*;
@RestController
public interface AgentDAO {
     void addAgent(Agent agent);
	
    public void updateAgent(Agent agent);
	
	//public void   deleteAgent(Agent agent) ;
	int deleteAgent(int id) throws SQLException;
	
	public List<Agent> list() throws Exception;
	
	
	Agent getAgentById(int id);

	
	
	
	
}
