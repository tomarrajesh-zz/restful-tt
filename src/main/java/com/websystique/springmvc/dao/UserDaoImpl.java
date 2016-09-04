package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}
	
	@Override
	public void updateUser(User user) {
		update(user);
	} 

//	public void deleteEmployeeBySsn(String ssn) {
//		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
//		query.setString("ssn", ssn);
//		query.executeUpdate();
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	@Override
	public User findUserByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (User) criteria.uniqueResult();
	}


}
