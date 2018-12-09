package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Course;
import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;


public class CreateCoursesDemo {

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
			
			// create the objects 
			Instructor instructor = new Instructor("Susan", "Pubhlic", "susan.me@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("http://yourtube.com", "Gaming");
			
			// associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			// begin the transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(instructor);
			
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
