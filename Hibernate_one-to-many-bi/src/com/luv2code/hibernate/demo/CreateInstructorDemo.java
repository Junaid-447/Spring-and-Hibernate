package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				addAnnotatedClass(Course.class).
				buildSessionFactory();
		
		Session ses = session.getCurrentSession();
		
		try {
			Instructor theInstructor=
					new Instructor("Heith", "Keith", "heith@gmail");
			
			InstructorDetail theInstructorDetail =
					new InstructorDetail("www.youtube.heither/junaid", "Music");
			
			theInstructor.setInstructordetail(theInstructorDetail);
			
			ses.beginTransaction();
			
			ses.save(theInstructor);
			
			ses.getTransaction().commit();

			System.out.println("Done");
		}
		finally {
			
			System.out.println("Got an Exception!!!");
		}

	}

}
