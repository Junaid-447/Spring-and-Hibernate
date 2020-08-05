package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


public class CreateCourseDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			
			ses.beginTransaction();
			
			int id=1;
			Instructor inst = ses.get(Instructor.class, id);
			
			Course c1 = new Course("The Jungle Book");
			Course c2 = new Course("The Mowgli");
			
			inst.add(c1);
			inst.add(c2);
			
			ses.save(c1);
			ses.save(c2);
			
			ses.getTransaction().commit();

			System.out.println("Done");
		}
		finally {
			
			System.out.println("Got an Exception!!!");
		}

	}

}
