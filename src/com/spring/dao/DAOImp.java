package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.User;

public class DAOImp implements DAO {

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user(name,age,city) VALUES (?,?,?)";
		jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getCity());
	}

	@Override
	public List<User> viewAllUser() {
		List<User> list = jdbcTemplate.query("SELECT * FROM user",new RowMapper<User>(){
			public User mapRow(ResultSet rs, int row) throws SQLException{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setCity(rs.getString(4));
				return user;
			}
		});
		return list;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT * FROM user WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user SET name=?, age=?, city=? WHERE id=?";
		jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getCity(),user.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		jdbcTemplate.update(sql,id);
	}
	
	

}
