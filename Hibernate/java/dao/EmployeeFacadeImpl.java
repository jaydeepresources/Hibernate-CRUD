package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateConfigurations;

import model.Employee;

public class EmployeeFacadeImpl implements EmployeeFacade {

	HibernateConfigurations hibernateConfig;
	Transaction transaction;
	Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public EmployeeFacadeImpl(HibernateConfigurations hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
		this.setSession(hibernateConfig.getSession());
		this.setTransaction(hibernateConfig.getTransaction());
	}

	public void insert(Employee e) {
		transaction = session.beginTransaction();
		session.save(e);
		transaction.commit();
		System.out.println("Employee Saved");

	}

	public void update(Employee e) {

		transaction = session.beginTransaction();
		Employee temp = (Employee) session.get(Employee.class, e.getId());
		temp.setName(e.getName());
		temp.setSalary(e.getSalary());
		session.update(temp);
		transaction.commit();
		System.out.println("Employee Updated");

	}

	public void delete(Employee e) {
		transaction = session.beginTransaction();
		Employee temp = (Employee) session.get(Employee.class, e.getId());
		session.delete(temp);
		
		transaction.commit();
		System.out.println("Employee Deleted");

	}

	public void view() {

		transaction = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		transaction.commit();

	}
}
