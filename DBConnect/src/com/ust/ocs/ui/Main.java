package com.ust.ocs.ui;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.*;
import com.ust.ocs.dao.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pk","root","pass@word1");
//		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
//		ps.setInt(1, 101);
//		ps.setString(2, "Vishwa");
//		ps.setInt(3, 45000);
//		int i=ps.executeUpdate();
//		System.out.println(i+" record inserted successfully")
		
//		
//		int id=Integer.parseInt(JOptionPane.showInputDialog("Enter the id"));
//		String name=JOptionPane.showInputDialog("Enter the name");
//		int salary=Integer.parseInt(JOptionPane.showInputDialog("Enter the salary"));
//		EmployeeBean eb=new EmployeeBean();
//		eb.setId(id);
//		eb.setName(name);
//		eb.setSalary(salary);
//		JOptionPane.showMessageDialog(null, AdministratorDao.addEmp(eb)+" inserted successfully");
//		
//		JOptionPane.showMessageDialog(null, AdministratorDao.updateEmp(eb)+" updated successfully");
//		int eid=Integer.parseInt(JOptionPane.showInputDialog("Enter the id"));
//		JOptionPane.showMessageDialog(null, AdministratorDao.deleteEmployee(eid)+" deleted Successfully");
//		JOptionPane.showMessageDialog(null, AdministratorDao.selectEmployee(eid));
		
		ArrayList<EmployeeBean> al=AdministratorDao.selectAll();
		String str="";
		for(EmployeeBean e:al)
		{
		str+=e.getId()+" "+e.getName()+" "+e.getSalary()+"\n";
		}
		JOptionPane.showMessageDialog(null, str);

//			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID"));
//			EmployeeBean e1=AdministratorDao.selectEmployeeById(id);
		//JOptionPane.showMessageDialog(null, e1.getId()+" "+e1.getName()+" "+e1.getSalary());
			//JOptionPane.showMessageDialog(null, AdministratorDao.deleteEmployee(id)+" record deleted successfully...");
			//	String name=JOptionPane.showInputDialog("Enter Employee Name");
//			int salary=Integer.parseInt(JOptionPane.showInputDialog("Enter Salary"));
//			EmployeeBean eb=new EmployeeBean();
//			eb.setId(id);
//			eb.setName(name);
//			eb.setSalary(salary);
			//JOptionPane.showMessageDialog(null, AdministratorDao.addEmployee(eb)+" record inserted successfully...");
//			JOptionPane.showMessageDialog(null,AdministratorDao.updateEmployee(eb)+" record updated successfully....");
	}

}
