package com.websystique.springmvc.dao;

import java.math.BigDecimal;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.websystique.springmvc.model.User;

public class UserDaoImplTest extends EntityDaoImplTest {
	
	@Autowired
	UserDao userDao;
	
	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("User.xml"));
		return dataSet;
	}
	
	/* In case you need multiple datasets (mapping different tables) and you do prefer to keep them in separate XML's
	@Override
	protected IDataSet getDataSet() throws Exception {
	  IDataSet[] datasets = new IDataSet[] {
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Benefits.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Departements.xml"))
	  };
	  return new CompositeDataSet(datasets);
	}
	*/
	
	@Test
	public void findById(){
		Assert.assertNotNull(userDao.findById(1));
		Assert.assertNull(userDao.findById(3));
	}

	@Test
	public void saveEmployee(){
		userDao.saveUser(getSampleUser());
		Assert.assertEquals(userDao.findAllUsers().size(), 3);
	}
	
	@Test
	public void findAllUsers() {
		Assert.assertEquals(userDao.findAllUsers().size(), 2);
	}

	private User getSampleUser() {
		User user = new User();
		user.setAge(24);
		user.setName("maven");
		user.setSalary(new BigDecimal(3209423));
		return user;
	}
	
	
}
