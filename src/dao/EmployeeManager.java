package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import connectDB.Connected;
import model.Employee;

public class EmployeeManager {
	
	private Connection con = Connected.getConnection();
	private PreparedStatement stmt;
	
	//hàm đổi từ localdate sang date
	public static java.sql.Date localDateToSqlDate(LocalDate localDate) {
	    return (localDate != null) ? java.sql.Date.valueOf(localDate) : null;
	}
	
	//hàm đổi từ date thành localdate
	public static LocalDate sqlDateToLocalDate(java.sql.Date sqlDate) {
	    return (sqlDate != null) ? sqlDate.toLocalDate() : null;
	}

	
	//lấy danh sách nhân viên
	public ArrayList<Employee> getListEmployee(){
		ArrayList<Employee> list = new ArrayList<Employee>();
		String sql = "select * from Employee";
		
		try {
			stmt = con.prepareStatement(sql);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				Employee employee  = new Employee();
				employee.setEmployeeID(res.getString("EmployeeID"));
				employee.setEmployeeName(res.getString("EmployeeName"));
				employee.setAddress(res.getString("Address"));
				employee.setEmail(res.getString("Email"));
				employee.setRole(res.getString("Role"));
				employee.setPhone("Phone");
				employee.setHireDate(sqlDateToLocalDate(res.getDate("HireDate")));
				employee.setSalary(res.getDouble("Salary"));
				
				list.add(employee);
			}
			
		} catch (SQLException e) {
			System.err.println("Không thể lấy danh sách nhân viên: " + e.getMessage());
		}
		return list;
	}

	//tìm nhân viên
	public ArrayList<Employee> findEmployee(String keyID, String keyName){
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		String sql = "select * from Employee where EmployeeID like ? or EmployeeName like ?";
		String findID = null;
		String findName = null;
		
		try {
			stmt  = con.prepareStatement(sql);
			if(keyID != null && !keyID.isEmpty()) {
				findID = keyID;
			}
			if(keyName != null && !keyName.isEmpty()) {
				findName = "%"+keyName+"%";
			}
			stmt.setString(1, findID);
			stmt.setString(2, findName);
			
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				Employee employee  = new Employee();
				employee.setEmployeeID(res.getString("EmployeeID"));
				employee.setEmployeeName(res.getString("EmployeeName"));
				employee.setAddress(res.getString("Address"));
				employee.setEmail(res.getString("Email"));
				employee.setRole(res.getString("Role"));
				employee.setPhone("Phone");
				employee.setHireDate(sqlDateToLocalDate(res.getDate("HireDate")));
				employee.setSalary(res.getDouble("Salary"));
				
				listEmp.add(employee);
			}
		} catch (SQLException e) {
			System.err.println("Không thể tìm nhân viên: " + e.getMessage());
		}
		return listEmp;
	}
	
	
	//xoá nhân viên
	public boolean deleteEmployee(String keyID) {
		String sql = "delete from Employee where EmployeeID like ?";
		try {
			if(keyID != null && !keyID.isEmpty()) {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, keyID);
				ResultSet res = stmt.executeQuery();
				return true;
			}
			
		} catch (SQLException e) {
			System.err.println("Không thể xoá nhân viên: " + e.getMessage());
		}
		return false;
	}
	

	//cập nhật nhân viên
	public boolean updateEmployee(String keyID, Employee nv){
		String sql ="update Employee set EmployeeID = ?, EmployeeName = ?, Role = ?, Phone = ?, Email = ?, Address = ?, HireDate = ?, Salary = ?";
		try {
			if(keyID != null & !keyID.isEmpty()) {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, nv.getEmployeeID());
				stmt.setString(2, nv.getEmployeeName());
				stmt.setString(3, nv.getRole());
				stmt.setString(4, nv.getPhone());
				stmt.setString(5, nv.getEmail());
				stmt.setString(6, nv.getAddress());
				stmt.setDate(7, localDateToSqlDate(nv.getHireDate()));
				stmt.setDouble(8, nv.getSalary());
				
				ResultSet res = stmt.executeQuery();
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Can not update for: " + keyID + ": " + e.getMessage());
		}
		return false;
	}
	
}
