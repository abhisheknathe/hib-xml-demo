package com.csp.mvn.hib_with_annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.classmate.AnnotationConfiguration;

/**
 * Hello world!
 *
 */
public class App {

	@Autowired
	private static SessionFactory factory;

	public static void main(String[] args) {
		System.out.println("Hello World!");

		factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);

		Session session = factory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		
		for(int i=1; i<25 ;i++) {
			Employee e = new Employee("ddd", "dfdf", i);
			session.save(e);
		}

		

		

		tx.commit();

		session.close();

	}

}
