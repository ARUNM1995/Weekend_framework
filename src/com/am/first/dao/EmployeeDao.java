package com.am.first.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.am.first.dto.Employee;

public class EmployeeDao {

	
	
	public void save(Employee employee) {
		
		//System.out.println(employee);
			Configuration configuration = new Configuration();
			configuration.configure("prop.xml");
			configuration.addAnnotatedClass(Employee.class);
			
			SessionFactory buildSessionFactory = configuration.buildSessionFactory();
			
			Session openSession = buildSessionFactory.openSession();
			
			Transaction beginTransaction = openSession.beginTransaction();
			openSession.save(employee);
			
			beginTransaction.commit();
			
	}
	
	
	
	public void getEmployee(Long id) {
		Configuration configuration = new Configuration();
		configuration.configure("prop.xml");
		configuration.addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session s = sessionFactory.openSession();
		
		try {
			Employee employee = s.get(Employee.class, id);
			System.out.println("result--"+employee);
		}catch (HibernateException he) {
			System.err.println("error accoured"+he.getMessage());
		}finally {
			s.close();
			sessionFactory.close();
		}
			
		//Transaction transaction = s.beginTransaction();
		
		
		
	}
}
