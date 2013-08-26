package edu.gduf.liu.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import edu.gduf.liu.base.BaseDao;
import edu.gduf.liu.dao.UserDao;
import edu.gduf.liu.dao.impl.CntUserDaoImpl.UserRowMapper;
import edu.gduf.liu.entity.User;
import edu.gduf.liu.utils.SpringContextHolder;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao{

	public int countAll() {
		int count = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM user");
		/*int count=0;
		try {
			count = getUserCount();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return count;
	}

	public int insertUser(User user) {
		//return (Integer) saveBean(user);
		//return (Integer) hibernateTemplate.save(user);
		return jdbcTemplate.update("INSERT INTO USER(name,password,type) VALUES(?,?,?)",
				new Object[]{user.getName(),user.getPassword(),user.getType()});
	}
	public boolean insertBatch(List<User> list){
		final List<User> tempUsers=list;
		DataSource dataSource = (DataSource) SpringContextHolder.getBean("dataSource");
		Connection conn = DataSourceUtils.getConnection(dataSource);
		try {
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append("insert into user(name,password,type) values(?,?,?)");
			PreparedStatement pStatement = conn.prepareStatement(sql
					.toString());
			int i = 0;
			for (User user : tempUsers) {
				String name = user.getName();
				String password = user.getPassword();
				String type = user.getType();
				pStatement.setString(1, name);
				pStatement.setString(2, password);
				pStatement.setString(3, type);
				pStatement.addBatch();
				pStatement.clearParameters();
				if (i%1000==0||i==tempUsers.size()) {
					pStatement.executeBatch();
				}
			}
			//pStatement.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
		/*jdbcTemplate.execute(new ConnectionCallback<String>() {
			public String doInConnection(Connection conn) throws SQLException,
					DataAccessException {
				conn.setAutoCommit(false);
				StringBuilder sql = new StringBuilder();
				sql.append("insert into user(name,password,type) values(?,?,?)");
				//logger.info("sql:"+sql.toString());
				PreparedStatement pStatement = conn.prepareStatement(sql
						.toString());
				int i = 0;
				for (User user : tempUsers) {
					String name = user.getName();
					String password = user.getPassword();
					String type = user.getType();
					pStatement.setString(1, name);
					pStatement.setString(2, password);
					pStatement.setString(3, type);
					//System.out.println(pStatement);
					pStatement.addBatch();
					pStatement.clearParameters();
					if (i%1000==0||i==tempUsers.size()) {
						pStatement.executeBatch();
					}
					//System.out.println("insertBatch");
				}
				//pStatement.executeBatch();
				conn.commit();
				//创建调用存储过程的预定义SQL语句
                //String sql = "{call user_insert(?)}";
                //创建过程执行器
                //CallableStatement cstmt = conn.prepareCall(sql);
                //设置入参和出参
                //cstmt.setString(1, "wangwu");
                //cstmt.setInt(1, 100);
                //cstmt.setString(2, "111111");
                //cstmt.registerOutParameter(3, Types.BIGINT); //注册出参
                //cstmt.executeUpdate();
                //获取输出参数值（两种方式都行）
                //Long id = cstmt.getLong(3);
                //Long id = cstmt.getLong("out_id");
                //System.out.println("本次插入数据的id=" + id);
				return "success";
			}
		});*/
		return true;
	}
	public boolean insertBatchByJdbcTemplate(List<User> list){
		final List<User> tempUsers=list;
		String sql="insert into user(name,password,type) values(?,?,?)";
		  jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		  {
		   public void setValues(PreparedStatement ps,int i)throws SQLException
		   {
				String name = tempUsers.get(i).getName();
				String password = tempUsers.get(i).getPassword();
				String type = tempUsers.get(i).getType();
			    ps.setString(1, name);
			    ps.setString(2, password);
			    ps.setString(3, type);
		   }
		   public int getBatchSize()
		   {
		    return tempUsers.size();
		   }
		  });
		return true;
	}
	public boolean insertBatchByHibernate(List<User> list){
		//hibernateTemplate.bulkUpdate(hql, value);
		//hibernateTemplate.saveOrUpdateAll(list);
		return true;
	}
	public int updateUser(int id){
		String name = "abc";
		return jdbcTemplate.update("UPDATE USER SET name = ? WHERE id = ?", new Object[] {name, id});
	}

	public User getUser(String name) {
		return null;
	}

	public User getUser(int id) {
		String name = (String) jdbcTemplate.queryForObject("SELECT name FROM USER WHERE id = ?", new Object[] {id}, String.class);
		User user = new User();
		user.setId(id);
		user.setName(name);
		return user;
	}

	public List<User> getUsers() {
		//List<User> userList = hibernateTemplate.find("from User");
		/*User userBean = new User();
		return getBeansByBean(userBean);*/
		/*DataSource dataSource = (DataSource) SpringContextHolder.getBean("dataSource");
		Connection conn = DataSourceUtils.getConnection(dataSource);
		List<User> userList = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
		return userList;*/
		return findAllByRowMapperResultReader();
	}
	class UserRowMapper implements RowMapper<Object> {
	    public Object mapRow(ResultSet rs, int index) throws SQLException {
	    	User user = new User();
	    	user.setId(Integer.parseInt(rs.getString("id")));
	    	user.setName(rs.getString("name"));
	    	user.setPassword(rs.getString("password"));
	        return user;
	    }
	}

	public List<User> findAllByRowMapperResultReader() {
	    String sql = "SELECT * FROM user";
	    //String sql = "select id,doc_status,domain_id,user_name,password from cnt_user";
	    return jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new UserRowMapper()));
	}

}
