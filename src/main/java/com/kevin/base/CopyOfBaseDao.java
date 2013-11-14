package com.kevin.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
/*import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;*/
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class CopyOfBaseDao {
	protected static Logger logger;
	@Resource
	protected HibernateTemplate hibernateTemplate;
	@Resource
	protected JdbcTemplate jdbcTemplate;

	public CopyOfBaseDao() {
		logger = Logger.getLogger(getClass().getName());
	}

	public Serializable getBeanByBean(Serializable bean) {
		List list = hibernateTemplate.findByExample(bean);
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

	public List getBeansByBean(Serializable bean) {
		return hibernateTemplate.findByExample(bean);
	}

	public void updateBean(final Serializable bean){
		/*hibernateTemplate.execute(new HibernateCallback<Serializable>() {
			public Serializable doInHibernate(Session session) throws HibernateException,
					SQLException {
				Transaction transaction=session.beginTransaction();
				session.update(bean);
				session.flush();
				transaction.commit();
				return null;
			}
		});*/
	}

	public Serializable saveBean(final Serializable bean){
		/*return hibernateTemplate.execute(new HibernateCallback<Serializable>() {
			public Serializable doInHibernate(Session session) throws HibernateException,
					SQLException {
				Transaction transaction=session.beginTransaction();
				Serializable beanResult=session.save(bean);
				session.flush();
				transaction.commit();
				return beanResult;
			}
		});*/
		return null;
	}

	public void deleteBean(final Serializable bean){
		/*hibernateTemplate.execute(new HibernateCallback<Serializable>() {
			public Serializable doInHibernate(Session session) throws HibernateException,
					SQLException {
				Transaction transaction=session.beginTransaction();
				session.delete(bean);
				session.flush();
				transaction.commit();
				return null;
			}
		});*/
	}

	/**
	 * 取记录总数
	 * @return int
	 * @throws Exception
	 */
	public int getUserCount() throws Exception {
	    int count = 0;
	    String queryString = "select count(*) from User";
	    count = ((Integer) hibernateTemplate.iterate(queryString).next()).
	            intValue();
	    return count;
	}
}
