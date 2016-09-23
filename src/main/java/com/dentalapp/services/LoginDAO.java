package com.dentalapp.services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dentalapp.dao.beans.User;
import com.dentalapp.services.LoginDAO;
import com.dentalapp.utility.CustomerRowMapper;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Component

public interface LoginDAO {

	/**
	 * This method will create new users
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean createNewUser(String userName,String password);

	/**
	 * This method will validate user credentials 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User validateCredentials(String userName);

	class LoginService implements LoginDAO {

		@Autowired
		private DataSource dataSource;

		private JdbcTemplate jdbcTemplate;

		/* 
		 * @see com.dentalapp.services.LoginDAO#createNewUser(java.lang.String, java.lang.String)
		 */
		public boolean createNewUser(String userName, String password) {
			// TODO Auto-generated method stub
			String SQL = "insert into logindetail (EMAIL_ID, PASSWORD) values (?, ?)"; 
			try{
				jdbcTemplate.update( SQL, userName, password);
			}catch(Exception e){
				return false;
			}
			System.out.println("userName = " + userName + " Password = " + password);
			return true;
		}

		public User validateCredentials(String userName) {
			String SQL = "select *from logindetail where EMAIL_ID = ?";  
			User customer = null;
			try{
				customer = (User)jdbcTemplate.queryForObject(
						SQL, new Object[] {userName}, new CustomerRowMapper());
				if(customer!=null){
					return customer;
				}
			}
			catch(EmptyResultDataAccessException exc){
				return customer;
			}
			// TODO Auto-generated method stub
			return customer;
		}

		/**
		 * @return the jdbcTemplate
		 */
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		/**
		 * @param jdbcTemplate the jdbcTemplate to set
		 */
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		/**
		 * @return the dataSource
		 */
		public DataSource getDataSource() {
			return dataSource;
		}

		/**
		 * @param dataSource the dataSource to set
		 */
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			System.out.println("Autowire LoginDAO:-"+jdbcTemplate);
		}

	}

}



