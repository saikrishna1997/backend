package com.slk.DAO;

import com.slk.model.Admin;
import com.slk.util.DButil;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class AdminDAOimpl implements AdminDAO {

	Connection connection = DButil.getConnection();

	public AdminDAOimpl() {
		connection = DButil.getConnection();
		System.out.println("connection" + connection);
	}

	// @Override
	public boolean login(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		Admin ad = new Admin();
		boolean flag= false;
		PreparedStatement stmt = connection.prepareStatement("select username,password from admin where username=?  and password=? ");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			//Admin ad = new Admin();
			//ad.setEmpId(rs.getInt(1));
			//ad.setName(rs.getString(2));
			//ad.setDOB(rs.getString(3));
			//ad.setPhone_num(rs.getInt(4));
			ad.setUsername(rs.getString(1));
			ad.setPassword(rs.getString(2));
			//ad.setRole(rs.getString(7));
			flag=true;
			
		}
		return flag;

	}

}
