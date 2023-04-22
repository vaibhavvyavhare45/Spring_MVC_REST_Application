package com.prowings.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.prowings.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveStudent(Student student) {

		Session ses = sessionFactory.openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(student);
		tx.commit();

		ses.close();

	}

	@Override
	public Student getStudentById(int id) {
		Student s1;
		Session ses1 = sessionFactory.openSession();
		Transaction tx = ses1.beginTransaction();
		s1 =  (Student)ses1.get(Student.class, id);
		tx.commit();
		ses1.close();
		return s1;
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Student> studlist = null;
		try {

			tx = session.beginTransaction();
			Query<Student> query = session.createQuery("from Student");
			studlist = query.list();
			tx.commit();

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace(System.err);
		} finally {
			session.close();
			return studlist;
		}

	}

	@Override
	public void deleteStudentById(int id) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Student s = session.get(Student.class, id);
		System.out.println("delete record");
		session.delete(s);
		tr.commit();
		session.close();
	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
		session.close();

	}

	@Override
	public List<Student> getStudentFilterByBranch(String branch) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
	javax.persistence.Query query=session.createQuery("from Student s where s.branch.branch= :branch");
		List<Student> list=query.setParameter("branch",branch ).getResultList();
		tx.commit();
		return list;
	}

	

}
