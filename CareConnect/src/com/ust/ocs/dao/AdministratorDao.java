package com.ust.ocs.dao;
import com.ust.ocs.bean.*;
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

public class AdministratorDao implements Administrator{
	static ArrayList <DoctorBean>al=new ArrayList<>();
	static ArrayList <DoctorBean>ar=new ArrayList<>();
	
	public Boolean login(CredentialBean creadential)
	{
		
		if(creadential.getUserID().equalsIgnoreCase("Admin")&&creadential.getPassword().equalsIgnoreCase("Admin@123"))
		{
		
			creadential.setLoginStatus(1);
			creadential.setUserType("Admin");
			return true;
		}
		return false;
	}
	
	@Override
	public String addDoctor(DoctorBean doctoerBean) {
		if(al.add(doctoerBean))
		{
			
			return "Doctor added Successfully";
		}
		
		return "Failed to Add";
		
		
		
		
	}

	@Override
	public Boolean modifyDoctor(DoctorBean doctorBean) {
		ar.add(doctorBean);
		boolean bool=true;
		if(al==ar)
		{
			bool=false;
		}
		return bool;
	}

	@Override
	public ArrayList<DoctorBean> viewAllDoctors() {
		for(DoctorBean d:al)
		{
			System.out.println(d);
//			JOptionPane.showMessageDialog(null, d);
		}
		
		return null;
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
		al.remove(doctorID);
		System.out.println("The Doctor Details Removed Successfully");
		JOptionPane.showMessageDialog(null, "Doctor Details removed Successfully");
		
		return 0;
	}

	@Override
	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate) {
		// TODO Auto-generated method stub
		return null;
	}
	

	}

