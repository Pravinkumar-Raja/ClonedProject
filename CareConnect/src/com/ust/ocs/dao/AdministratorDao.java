package com.ust.ocs.dao;
import com.ust.ocs.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import com.ust.ocs.main.*;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.CredentialBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;
import com.ust.ocs.service.Administrator;
import java.util.*
;public class AdministratorDao implements Administrator{
	static ArrayList <DoctorBean>al=new ArrayList<>();
	static ArrayList <DoctorBean>ar=new ArrayList<>();
	
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ArrayList<DoctorBean> sd=new ArrayList<DoctorBean>();
	
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/careconnect","root","pass@word1");
			
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println(cnf);
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return con;
	}
	
	public int login(CredentialBean creadential)
	{
		
//		if(creadential.getUserID().equalsIgnoreCase("Admin")&&creadential.getPassword().equalsIgnoreCase("Admin@123"))
//		{
//		
//			creadential.setLoginStatus(1);
//			creadential.setUserType("Admin");
//			return true;
//		}
		int i=0;
		try {
			ps=con.prepareStatement("select * from ocs_tbl_credentials");
//			ps.setString(1, creadential.getUserID());
//			ps.setString(2, creadential.getPassword());
		
			rs=ps.executeQuery();
			if(rs.getString("USERID").equals(creadential.getUserID())&& rs.getString("PASSWORD").equals(creadential.getPassword()))
			{
				i=1;
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public String addDoctor(DoctorBean doctoerBean) {
//		if(al.add(doctoerBean))
//		{
//			
//			return "Doctor added Successfully";
//		}
//		
//		return "Failed to Add";
//		
//		
		java.util.Date d1=Login.d.getDateOfBirth();
		java.sql.Date sqlDate=new java.sql.Date(d1.getTime());
		java.util.Date d2=Login.d.getDateOfJoining();
		java.sql.Date sqlDate2=new java.sql.Date(d2.getTime());
		int i=0;
		try {
			ps=con.prepareStatement("insert into OCS_TBL_DOCTOR values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, doctoerBean.getDoctorID());
			ps.setString(2, doctoerBean.getDoctorName());
			ps.setDate(3, sqlDate);
			ps.setDate(4, sqlDate2);
			ps.setString(5, doctoerBean.getGender());
			ps.setString(6, doctoerBean.getQualification());
			ps.setString(7, doctoerBean.getSpecialization());
			ps.setInt(8, doctoerBean.getYearsOfExperience());
			ps.setString(9, doctoerBean.getStreet());
			ps.setString(10, doctoerBean.getLocation());
			ps.setString(11, doctoerBean.getState());
			ps.setString(12, doctoerBean.getCity());
			ps.setString(13, doctoerBean.getPincode());
			ps.setString(14, doctoerBean.getContactNumber());
			ps.setString(15, doctoerBean.getEmailID());
			i=ps.executeUpdate();
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			
		}
		String i1=String.valueOf(i);
		if(i1.equals("1")){
			return "Doctor Added Successfully";
		}
		return "Failed to add ";
		
	}

	@Override
	public ArrayList<DoctorBean> viewAllDoctors() {
		
	try {
		DoctorBean d=new DoctorBean();
		ps=con.prepareStatement("select * from OCS_TBL_DOCTOR");
		rs=ps.executeQuery();
		while(rs.next())
		{
			d.setDoctorID(rs.getString(1));
			d.setDoctorName(rs.getString(2));
			d.setDateOfBirth(rs.getDate(3));
			d.setDateOfJoining(rs.getDate(4));
			d.setGender(rs.getString(5));
			d.setQualification(rs.getString(6));
			d.setSpecialization(rs.getString(7));
			d.setYearsOfExperience(rs.getInt(8));
			d.setStreet(rs.getString(9));
			d.setLocation(rs.getString(10));
			d.setState(rs.getString(11));
			d.setCity(rs.getString(12));
			d.setPincode(rs.getString(13));
			d.setContactNumber(rs.getString(14));
			d.setEmailID(rs.getString(15));
			
		}
		sd.add(d);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		return sd;
	}
	
	@Override
	public Boolean modifyDoctor(DoctorBean doctorBean) {
//		ar.add(doctorBean);
		boolean bool=true;
//		if(al==ar)
//		{
//			bool=false;
//		}
		DoctorBean dr=new DoctorBean();
		
		if(dr.getDoctorID().equals(""))
		{
			
		}
		return bool;
		
		
		
	}

	

	@Override
	public int removeDoctor(String doctorID) {
	
//		for(int i=0;i<al.size();i++)
//		{
//		if(al.get(i).equals(doctorID))
//		{
//			al.remove(doctorID);
//			
//		}
//		}
//		al.remove(doctorID);
//		System.out.println("The Doctor Details Removed Successfully");
//		
		int i=0;
		try {
			ps=con.prepareStatement("delete from OCS_TBL_DOCTOR where DOCTORID=?");
			ps.setString(1,doctorID);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1)
		{
			JOptionPane.showMessageDialog(null, "Doctor Details removed Successfully");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Failed to remove the doctor details");
		}
		return 0;
	}

	@Override
	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date) {
//		ArrayList<DoctorBean> sg=new ArrayList<DoctorBean>();
//		int i=0;
//		java.sql.Date e=new java.sql.Date(date.getTime());
//		
//		AppointmentBean ab=new AppointmentBean();
//		try {
//			ps=con.prepareStatement("select * from OCS_TBL_LEAVE where DATE=?");
//		ps.setDate(1, e);
//		i=ps.executeUpdate();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		ArrayList<DoctorBean> add=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps1=null,ps2=null,ps3=null,ps4=null;
		ResultSet rs1=null,rs2=null,rs3=null,rs4=null;
		try
		{
			con=getCon();
			String q1="Select problem from patient where patientid=?";	
			ps1=con.prepareStatement(q1);
			ps1.setString(1, "patientid");
			rs1=ps1.executeQuery();
			
			String problem =null;
			{
				if(rs1.next())
				{
					problem=rs1.getString("problem");
					
				}
				else
				{
					return add;
				}
			}
			
			
			String q2="Select * from OCS_TBL_DOCTOR where specialization=?";
			ps1=con.prepareStatement(q2);
			ps2.setString(1, problem);
			rs2=ps2.executeQuery();
			ArrayList<DoctorBean> match=new ArrayList<>();
			while(rs2.next())
			{
				match.add(new DoctorBean(rs2.getString("doctorid"),rs2.getString("doctorname"),rs2.getString("specialization"),rs2.getString("contact")));
			}
		}catch(Exception e)
		{
			
		}
		
		return null;
	}

	@Override
	public Map<PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate) {
		// TODO Auto-generated method stub
		return null;
	}
	

	}

