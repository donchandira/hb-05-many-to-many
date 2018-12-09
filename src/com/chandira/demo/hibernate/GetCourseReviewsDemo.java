package com.chandira.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chandira.demo.hibernate.entity.Course;
import com.chandira.demo.hibernate.entity.Instructor;
import com.chandira.demo.hibernate.entity.InstructorDetail;
import com.chandira.demo.hibernate.entity.Review;


public class GetCourseReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
		
			// begin the transaction
			session.beginTransaction();

			// get the course
			Course course = session.get(Course.class, 10);
			
			// get the reviews
			System.out.println(course);
			
			System.out.println(course.getReviews());
			// save the instructor
			// session.save();
			
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
