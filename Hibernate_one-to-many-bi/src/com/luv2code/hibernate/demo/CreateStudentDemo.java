package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;


public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			System.out.println("Creating new Student Object");
			Student student1 = new Student("NewJunaid","NewCharaniya","charaniya@gmal.com");
			Student student2 = new Student("Akshata","Malghan","akshata@gmal.com");
			Student student3 = new Student("Albert","Santos","albert@gmal.com");
			ses.beginTransaction();
			ses.save(student1);
			ses.save(student2);
			ses.save(student3);
			ses.getTransaction().commit();
			Student std = ses.get(Student.class, student1.getId());
			
			
			System.out.println("Done");
		}
		finally {
			
		}

	}

}
