package com.kevin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.kevin.base.BaseDao;
import com.kevin.dao.CntUserDao;
import com.kevin.entity.CntUser;

@Repository("cntUserDao")
public class CntUserDaoImpl extends BaseDao implements CntUserDao {

	public int countAll() {
		int count = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM cnt_user");
		/*
		 * int count=0; try { count = getUserCount(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		return count;
	}

	public void insertCntUser(CntUser cntUser) {

	}

	public List<CntUser> getCntUsers() {
		return findAllByRowMapperResultReader();
	}

	class UserRowMapper implements RowMapper {
	    public Object mapRow(ResultSet rs, int index) throws SQLException {
	    	CntUser cntUser = new CntUser();
	    	cntUser.setId(rs.getString("id"));
	    	cntUser.setDoc_status(rs.getString("doc_status"));
	    	cntUser.setDomain_id(rs.getString("domain_id"));
	    	cntUser.setUser_name(rs.getString("user_name"));
	    	cntUser.setPassword(rs.getString("password"));
	        return cntUser;
	    }
	}

	public List findAllByRowMapperResultReader() {
	    String sql = "SELECT * FROM cnt_user";
	    //String sql = "select id,doc_status,domain_id,user_name,password from cnt_user";
	    return jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new UserRowMapper()));
	}

}
