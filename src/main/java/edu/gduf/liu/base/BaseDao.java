package edu.gduf.liu.base;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {
	protected static Logger logger;
	@Resource
	protected JdbcTemplate jdbcTemplate;

	public BaseDao() {
		logger = Logger.getLogger(getClass().getName());
	}
}
