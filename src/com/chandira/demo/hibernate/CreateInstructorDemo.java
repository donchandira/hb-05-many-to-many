package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Course;
import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {

			// begin the transaction
			session.beginTransaction();
			
			// get the instructor from db
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			// create some courses
			Course tempCourse1 = new Course("Air Guitar - the ultimate guide");
			Course tempCourse2 = new Course("The pinball masterclass");
			
			// add courses to instructor
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.close();
			sessionFactory.close();
		}
		

	}

}
