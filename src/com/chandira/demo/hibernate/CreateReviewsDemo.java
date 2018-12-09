package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Course;
import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;
import com.chandira.demo.hibernate.entity.Review;


public class CreateReviewsDemo {

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
			
			// create the course
			Course course = new Course("Learning trojan");
			
			// add reviews
			course.addReview(new Review("This is going to be a awesome class"));
			course.addReview(new Review("Wow! I love it"));
			course.addReview(new Review("I would take this class again"));
		
			// begin the transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(course);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			session.close();
			sessionFactory.close();
		}
		

	}

}
