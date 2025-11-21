package com.ust.ocs.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.CredentialBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;
import com.ust.ocs.dao.AdministratorDao;
import com.ust.ocs.dao.PatientDao;

public class LoginPatient {
	
	public static String choice, id,password,ch;
	public static boolean b;

	public static ArrayList <DoctorBean>al=new ArrayList<>();
	public static DoctorBean d;
	
public static void main(String[] args) {
		PatientDao pd=new PatientDao();
		CredentialBean cb=new CredentialBean();
		d=new DoctorBean();
			AdministratorDao ad=new AdministratorDao();
			AppointmentBean ab=new AppointmentBean();
			Scanner s=new Scanner(System.in);
			id=JOptionPane.showInputDialog("Enter the Login Id");
			cb.setUserID(id);
			password=JOptionPane.showInputDialog("Enter the Password");
			cb.setPassword(password);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			
			pd.loginPatient(cb);
			if(cb.getLoginStatus()==1)
			{
				JOptionPane.showMessageDialog(null, "Logged in Successfully");
				System.out.println("Login Successful");
				
				
				
				System.out.println(".............Welcome to CareConnect..............");
				System.out.println("Home     about      Contact       Profile");
				System.out.println("Logged in as Admin");
				System.out.println("Options You Have");
				System.out.println("AD-001 -> Add Doctor Details");
				System.out.println("AD-002 -> View Doctor Details");
				System.out.println("AD-003 -> Modify Doctor Details");
				System.out.println("AD-004 -> Delete Doctor Details");
				System.out.println("AD-005 -> Appointment");
				System.out.println("Exit");
				System.out.println("Enter the Option You want to perform");
				ch=s.next();
			}
			else
			{
				
			}
			
			
	}

}
