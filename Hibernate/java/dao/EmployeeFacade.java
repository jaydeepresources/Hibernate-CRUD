package dao;

import model.Employee;

public interface EmployeeFacade {

	public void insert(Employee e);
	public void update(Employee e);
	public void delete(Employee e);
	public void view();
	
}
