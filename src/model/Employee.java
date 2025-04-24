package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Employee {

	String employeeID;
	String employeeName;
	String role;
	String phone;
	String email;
	String address;
	LocalDate hireDate;
	Double salary;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(String employeeID, String employeeName, String role, String phone, String email, String address,
			LocalDate hireDate, Double salary) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.hireDate = hireDate;
		this.salary = salary;
	}


	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}


	@Override
	public int hashCode() {
		return Objects.hash(employeeID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeID, other.employeeID);
	}


	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", role=" + role + ", phone="
				+ phone + ", email=" + email + ", address=" + address + ", hireDate=" + hireDate + ", salary=" + salary
				+ "]";
	}
}
