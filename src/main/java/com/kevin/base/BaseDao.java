package com.kevin.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDao {
	protected static Logger logger;
	@Resource
	protected JdbcTemplate jdbcTemplate;
	/*@Resource
	protected HibernateTemplate hibernateTemplate;*/

	public BaseDao() {
		logger = Logger.getLogger(getClass().getName());
	}

	@SuppressWarnings("rawtypes")
	@Deprecated
	public Serializable getBeanByBean(Serializable bean) {
		List list=new ArrayList<Serializable>();
		//List list = hibernateTemplate.findByExample(bean);
		/*try {
			beanResult = (Serializable) list.get(0);
		} catch (Exception e) {
			throw new DaoException("Get the first match record by bean fail!"
					+ e.getMessage());
		}*/
		if (0==list.size()) {
			return null;
		}else
		/*DetachedCriteria criteria = DetachedCriteria.forClass(Object.class);
		criteria.add(Restrictions.in("TExams", list)).add(Restrictions.eq("patype", 0));
		hibernateTemplate.findByCriteria(criteria);*/
		return (Serializable) list.get(0);
	}

	/*public List getBeansByBean(Serializable bean) {
		return hibernateTemplate.findByExample(bean);
	}*/
}
