package com.kevin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import com.kevin.entity.User;
import com.kevin.page.Page;

@Repository
@Transactional
public interface UserMapper {

	/*@InsertProvider(method = "insert", type = UserTypeSqlBuilder.class)
	Integer insert(User entity); */
	@Insert("insert into user(name,password,type) values(#{name},#{password},#{type})")
	public void insertUser(User user);
	public void insertBatch(List<User> user);

	//public User getUser(String name, String password);
	/*@Select("SELECT id,name,password,type FROM user WHERE name = #{name} and password=#{password}")
	public User getUser(@Param("name") String name, @Param("password") String password);*/

	/*@Select("SELECT id,name,password,type FROM user "
			+ "WHERE name = #{name} and password=#{password}")
	public User getUser(User user);*/

	public List<User> getUser(User user);
	public List<User> getUsers(Page page);
	public List<User> getUsers2();

	@Select("SELECT count(*) FROM cnt_user")
	public int countAll();
}
