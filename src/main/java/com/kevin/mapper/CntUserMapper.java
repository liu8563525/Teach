package com.kevin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import com.kevin.entity.CntUser;
import com.kevin.page.Page;

@Repository("cntUserMapper")
@Transactional
public interface CntUserMapper {

	public CntUser getCntUser(String doc_status);
	public List<CntUser> getCntUser(CntUser cntUser);
	public List<CntUser> getCntUsers(Page page);
	public List<CntUser> getCntUsers2();

	@Select("SELECT count(*) FROM cnt_user")
	public int countAll();
}
