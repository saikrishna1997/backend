package com.slk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.slk.model.Customer;
import com.slk.util.DButil;
@RestController
public class CustomerDAOimpl implements CustomerDAO {

	//@Override
		// TODO Auto-generated method stub
		Connection connection = null;

		public CustomerDAOimpl() {
			connection = DButil.getConnection();
			System.out.println("connection" + connection);
		}

		//@Override
		public List<Customer> getAllCustomers() throws Exception {
			// TODO Auto-generated method stub
			List<Customer> cst = new ArrayList<Customer>();
			PreparedStatement ps = null;
			ResultSet rs1 = null;

			try {

				PreparedStatement stmt = connection.prepareStatement("select * from customer");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {

					Customer cst1 = new Customer();
					cst1.setAccount_no(rs.getInt(1));
					cst1.setName(rs.getString(2));
					cst1.setDob(rs.getString(3));
					cst1.setPhone_no(rs.getInt(4));
					cst1.setUsername(rs.getString(5));
					cst1.setPassword(rs.getString(6));
					cst1.setBalance(rs.getFloat(7));
					cst1.setBranch_id(rs.getLong(8));
					cst1.setLoan_id(rs.getString(9));
					cst1.setType_id(rs.getString(10));
					cst1.setAadhar_no(rs.getLong(11));
					cst1.setPan_no(rs.getString(12));

					System.out.println(rs.getInt(1) + " " + rs.getString(2));

					cst.add(cst1);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
			return cst;
		}
	}


