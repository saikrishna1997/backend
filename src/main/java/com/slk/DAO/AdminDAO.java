package com.slk.DAO;

import com.slk.model.Admin;

public interface AdminDAO {
	public boolean login(String username, String password) throws Exception;

}
