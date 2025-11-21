package com.ust.ocs.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.*;
import com.ust.ocs.dao.*;

public class Login {
	public static String choice, id,password,ch;
	public static boolean b;
	public static ArrayList<DoctorBean>md=new ArrayList<DoctorBean>();
	public static ArrayList <DoctorBean>al=new ArrayList<>();
public static DoctorBean d;
	public static void main(String[] args) {
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
		PatientDao pd=new PatientDao();
//		if(cb.getUserID().equalsIgnoreCase("Admin")&&cb.getPassword().equalsIgnoreCase("Admin@123"))
//		{
//			cb.setLoginStatus(1);
//			cb.setUserType("Admin");
			int l=ad.loginAdmin(cb);

			if(l==1)
			{
				JOptionPane.showMessageDialog(null, "Logged in Successfully");
				System.out.println("Logged in Successfully");
			
		do {
		
			
			
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
		
		switch(ch)
		{
		case "AD-001": 
			//int n=Integer.parseInt(JOptionPane.showInputDialog("Enter the no of doctor needed"));
//		for(int i=0;i<n;i++)
//		{

			d.setDoctorID(JOptionPane.showInputDialog("Enter the Doctor id"));
			d.setDoctorName(JOptionPane.showInputDialog("Enter the Doctor Name"));
			d.setGender(JOptionPane.showInputDialog("Enter the Gender"));
			
			
				String dat=JOptionPane.showInputDialog("Enter the date of birth(yyyy/mm/dd)");
				java.util.Date dob = null;
				try {
					dob = sdf.parse(dat);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				java.sql.Date sqld=new java.sql.Date(dob.getTime());
				d.setDateOfBirth(dob);
		
//			d.setDateOfBirth(JOptionPane.showInputDialog("Enter the DOB (DD/MM/YYYY)"));
			
			d.setQualification(JOptionPane.showInputDialog("Enter the Qualification"));
			d.setSpecialization(JOptionPane.showInputDialog("Enter the Specification"));
			d.setYearsOfExperience(Integer.parseInt(JOptionPane.showInputDialog("Enter the Years of Experience ")));
			
			String dat2=JOptionPane.showInputDialog("Enter the date of joining(yyyy/mm/dd)");
			java.util.Date doj = null;
			try {
				doj = sdf.parse(dat2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			d.setDateOfJoining(doj);
			
			d.setStreet(JOptionPane.showInputDialog("Enter the Street"));
			d.setLocation(JOptionPane.showInputDialog("Enter the Location"));
			d.setState(JOptionPane.showInputDialog("Enter the State"));
			d.setCity(JOptionPane.showInputDialog("Enter the City"));
			d.setPincode(JOptionPane.showInputDialog("Enter the Pin code"));
			d.setContactNumber(JOptionPane.showInputDialog("Enter the Contact Number"));
			d.setEmailID(JOptionPane.showInputDialog("Enter the email id"));
			System.out.println(ad.addDoctor(d));
//			al.add(d);
			ad.addDoctor(d);
		
			
		//}
		
		break;
		case "AD-002": 
		md=ad.viewAllDoctors();
		al.addAll(md);
		for(DoctorBean al1:md)
		{
			System.out.println(al1);
		}

	
			break;
			
		case "AD-003": 	String str=JOptionPane.showInputDialog("Enter Yes or No");
		if(str.equalsIgnoreCase("Yes"))
		{	
			
			
			ch=JOptionPane.showInputDialog("Enter Doctor id");
			
			al.addAll(md);
	        boolean doctorFound = false;  // Flag to check if doctor is found
	        DoctorBean selectedDoctor = null;

	        // Check if doctor ID exists in the list
	        if (al != null && !al.isEmpty()) {
	            for (DoctorBean arr2 : al) {
	                System.out.println("Doctor ID: " + arr2.getDoctorID());  // Debug print: show doctor IDs in the list
	                if (arr2.getDoctorID().equals(ch)) {
	                    selectedDoctor = arr2;
	                    doctorFound = true;
	                    break;  // Break out of the loop once doctor is found
	                }
	            }
	        } else {
	            System.out.println("Doctor list is empty or null.");
	        }

				if(doctorFound)
				{
					do {
						choice=JOptionPane.showInputDialog("Enter the field (Name,Gender,DOB,Qualification,Specilization,YOE,DOJ,Street,Location,State,City,Pincode,CNo,Email,Exit");
						switch(choice)
						{
						case "Name": 
							selectedDoctor.setDoctorName(JOptionPane.showInputDialog("Enter the new name"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Gender":  selectedDoctor.setGender(JOptionPane.showInputDialog("Enter the new Gender"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "DOB": 
						String dat1=JOptionPane.showInputDialog("Enter the new date of birth(yyyy/mm/dd)");
							java.sql.Date dob1 = null;
							try {
								dob1 = (Date) sdf.parse(dat1);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							selectedDoctor.setDateOfBirth(dob1);
				        
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Qualification": selectedDoctor.setQualification(JOptionPane.showInputDialog("Enter the new Qualification"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Specialization": selectedDoctor.setSpecialization(JOptionPane.showInputDialog("Enter the new Specialization"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "YOE": selectedDoctor.setYearsOfExperience(Integer.parseInt(JOptionPane.showInputDialog("Enter the new YOE")));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "DOJ":  
						String dat21=JOptionPane.showInputDialog("Enter the date of joining (yyyy/mm/dd)");
							java.sql.Date doj1 = null;
							try {
								doj1 = (Date) sdf.parse(dat21);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							selectedDoctor.setDateOfJoining(doj1);
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Street":  selectedDoctor.setStreet(JOptionPane.showInputDialog("Enter the new Street"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Location":  selectedDoctor.setLocation(JOptionPane.showInputDialog("Enter the new Location"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "State":  selectedDoctor.setState(JOptionPane.showInputDialog("Enter the new State"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "City":  selectedDoctor.setCity(JOptionPane.showInputDialog("Enter the new City"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Pincode":  selectedDoctor.setPincode(JOptionPane.showInputDialog("Enter the new Pincode"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "CNo":  selectedDoctor.setContactNumber(JOptionPane.showInputDialog("Enter the new Contact No"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;
	
						case "Email":  selectedDoctor.setEmailID(JOptionPane.showInputDialog("Enter the new Email"));
						b=ad.modifyDoctor(selectedDoctor);
						if(b)
						{
							JOptionPane.showMessageDialog(null, "Modified the details Successfully");
							System.out.println("Modified the details Successfully");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to Modify");
						}
						break;	
						case "EXIT": System.exit(0);
						}
					}while(!choice.equalsIgnoreCase("Exit"));

				}
				

			}

		break;
		case "AD-004":	 String rm=JOptionPane.showInputDialog("Do you want to Remove (Yes or No)");
		if(rm.equalsIgnoreCase(rm))
		{
			String did=JOptionPane.showInputDialog("Enter the Doctor ID");
			ad.removeDoctor(did);
			
		}
		break;
		
		case "AD-005" : String pId=JOptionPane.showInputDialog("Enter the Patient id");
		ab.setPatientID(pId);
		
		String date=JOptionPane.showInputDialog("Enter the date");
		java.util.Date dt=null;
			try {
				dt=sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ab.setAppointmentDate(dt);
			ad.suggestDoctors(pId, dt);
			break;
			
//			String pId = JOptionPane.showInputDialog("Enter the Patient id");
//            ab.setPatientID(pId);
//
//            String date = JOptionPane.showInputDialog("Enter the date");
//            Date dt = null;
//            try {
//                dt = sdf.parse(date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            ab.setAppointmentDate(dt);
//            ad.suggestDoctors(pId, dt);
			//break;
		case "Exit": System.exit(0);
		}
		
		}while(!ch.equalsIgnoreCase("Exit"));
		
			}
			else if(pd.loginPatient(cb)==1){
					
				JOptionPane.showMessageDialog(null, "Logged in Successfully as user");
			}
			else if(pd.loginPatient(cb)==0)
			{
//				// Login failed (USERID doesn't exist), so we call the registration method
//			    JOptionPane.showMessageDialog(null, "User ID not found. Please register to continue.");
//			    PatientBean patientBean =new PatientBean();
//			    patientBean.setUserID("someUniqueUserID");  // or generate/set it if not already set
//			    patientBean.setPatientID("someUniquePatientID");  // set a patient ID if required
//			    patientBean.setAppointmentDate(new java.util.Date()); // or set a specific appointment date
//			    patientBean.setAilmentType("Ailment Type Example");
//			    patientBean.setAilmentDetails("Details about the ailment");
//			    patientBean.setDiagnosisHistory("Some previous diagnosis history");
//
//			    // Redirect to registration process (you can pass the patient data or handle accordingly)
//			    boolean registrationSuccess = pd.register(patientBean, cb.getPassword());
//			    
//			    if(registrationSuccess)
//			    {
//			    	JOptionPane.showMessageDialog(null, "Registration successful! You can now log in.");
//			    }
//			    else
//			    {
//			    	JOptionPane.showMessageDialog(null, "Registration failed. Please try again.");
//			    }
//			}else if (pd.loginPatient(cb) == 0) {
            // User not found, registration
            JOptionPane.showMessageDialog(null, "User ID not found. Please register to continue.");
            PatientBean patientBean = new PatientBean();
            patientBean.setUserID(JOptionPane.showInputDialog("UniqueUserID"));  // or generate/set it if not already set
            patientBean.setPatientID(JOptionPane.showInputDialog("UniquePatientID"));  // set a patient ID if required
            patientBean.setAppointmentDate(new java.util.Date()); // or set a specific appointment date

			String dat=JOptionPane.showInputDialog("Enter the date of birth(yyyy/mm/dd)");
			java.util.Date dob = null;
			try {
				dob = sdf.parse(dat);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			java.sql.Date sqld=new java.sql.Date(dob.getTime());
			patientBean.setAppointmentDate(dob);
            patientBean.setAilmentType(JOptionPane.showInputDialog("Ailment Type Example(Cardiology)"));
            patientBean.setAilmentDetails(JOptionPane.showInputDialog("Details about the ailment"));
            patientBean.setDiagnosisHistory(JOptionPane.showInputDialog("Some previous diagnosis history"));

            // Redirect to registration process
            boolean registrationSuccess = pd.register(patientBean, cb.getPassword());

            if (registrationSuccess) {
                JOptionPane.showMessageDialog(null, "Registration successful! You can now log in.");
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed. Please try again.");
            }
        }
			else
			{
				JOptionPane.showMessageDialog(null, "Login Failed");
				System.out.println("Retry again");
				
			}
			
			
			
		
		
	}
			
	

}
//}
