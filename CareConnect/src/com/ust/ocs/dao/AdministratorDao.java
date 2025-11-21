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
	
	public int loginAdmin(CredentialBean creadential)
	{
		  int i = 0;
		    try {
		    	 ps = con.prepareStatement("SELECT * FROM ocs_tbl_credentials WHERE USERID = ? AND PASSWORD = ? AND  USERTYPE = 'Admin'");
		        ps.setString(1, creadential.getUserID());
		        ps.setString(2, creadential.getPassword());
		        
		        rs = ps.executeQuery();
		        if (rs.next()) {  // Check if the user exists
		            i = 1;  // User found, login successful
		            return i;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
		return 0;//login failed
	}
	
	@Override
	public String addDoctor(DoctorBean doctoerBean) {
		
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
		
		ps=con.prepareStatement("select * from OCS_TBL_DOCTOR");
		rs=ps.executeQuery();
		while(rs.next())
		{
			DoctorBean d=new DoctorBean();
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
			sd.add(d);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		return sd;
	}
	
	@Override
	public Boolean modifyDoctor(DoctorBean doctorBean) {
	    boolean isUpdated = false;
	    StringBuilder sql = new StringBuilder("UPDATE OCS_TBL_DOCTOR SET ");
	    boolean hasUpdates = false;  // To track if there are any fields to update

	    // Check which fields are non-null and append the respective SQL clauses
	    if (doctorBean.getDoctorName() != null) {
	        sql.append("doctorname = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getDateOfBirth() != null) {
	        sql.append("dateofbirth = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getDateOfJoining() != null) {
	        sql.append("dateofjoining = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getGender() != null) {
	        sql.append("gender = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getQualification() != null) {
	        sql.append("qualification = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getSpecialization() != null) {
	        sql.append("specialization = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getYearsOfExperience() > 0) {
	        sql.append("yearsofexperience = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getStreet() != null) {
	        sql.append("street = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getLocation() != null) {
	        sql.append("location = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getState() != null) {
	        sql.append("state = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getCity() != null) {
	        sql.append("city = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getPincode() != null) {
	        sql.append("pincode = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getContactNumber() != null) {
	        sql.append("contactnumber = ?, ");
	        hasUpdates = true;
	    }
	    if (doctorBean.getEmailID() != null) {
	        sql.append("emailid = ?, ");
	        hasUpdates = true;
	    }

	    // If there are fields to update, remove the trailing comma and add WHERE condition
	    if (hasUpdates) {
	        sql.setLength(sql.length() - 2);  // Remove the last comma and space
	        sql.append(" WHERE doctorid = ?");

	        try {
	            ps = con.prepareStatement(sql.toString());

	            // Set the parameters dynamically based on which fields were updated
	            int parameterIndex = 1;  // Index to set parameters in the PreparedStatement

	            if (doctorBean.getDoctorName() != null) {
	                ps.setString(parameterIndex++, doctorBean.getDoctorName());
	            }
	            if (doctorBean.getDateOfBirth() != null) {
	                ps.setDate(parameterIndex++, new java.sql.Date(doctorBean.getDateOfBirth().getTime()));
	            }
	            if (doctorBean.getDateOfJoining() != null) {
	                ps.setDate(parameterIndex++, new java.sql.Date(doctorBean.getDateOfJoining().getTime()));
	            }
	            if (doctorBean.getGender() != null) {
	                ps.setString(parameterIndex++, doctorBean.getGender());
	            }
	            if (doctorBean.getQualification() != null) {
	                ps.setString(parameterIndex++, doctorBean.getQualification());
	            }
	            if (doctorBean.getSpecialization() != null) {
	                ps.setString(parameterIndex++, doctorBean.getSpecialization());
	            }
	            if (doctorBean.getYearsOfExperience() > 0) {
	                ps.setInt(parameterIndex++, doctorBean.getYearsOfExperience());
	            }
	            if (doctorBean.getStreet() != null) {
	                ps.setString(parameterIndex++, doctorBean.getStreet());
	            }
	            if (doctorBean.getLocation() != null) {
	                ps.setString(parameterIndex++, doctorBean.getLocation());
	            }
	            if (doctorBean.getState() != null) {
	                ps.setString(parameterIndex++, doctorBean.getState());
	            }
	            if (doctorBean.getCity() != null) {
	                ps.setString(parameterIndex++, doctorBean.getCity());
	            }
	            if (doctorBean.getPincode() != null) {
	                ps.setString(parameterIndex++, doctorBean.getPincode());
	            }
	            if (doctorBean.getContactNumber() != null) {
	                ps.setString(parameterIndex++, doctorBean.getContactNumber());
	            }
	            if (doctorBean.getEmailID() != null) {
	                ps.setString(parameterIndex++, doctorBean.getEmailID());
	            }

	            // Set the doctorID at the end for the WHERE clause
	            ps.setString(parameterIndex, doctorBean.getDoctorID());

	            // Execute the update
	            int rowsAffected = ps.executeUpdate();

	            if (rowsAffected > 0) {
	                isUpdated = true;  // If at least one row was updated, the update was successful
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isUpdated;  // Return true if the doctor details were successfully updated, otherwise false
	}

//	public Boolean modifyDoctor(DoctorBean doctorBean) {
////		ar.add(doctorBean);
//		boolean bool=true;
////		if(al==ar)
////		{
////			bool=false;
////		}
//		DoctorBean dr=new DoctorBean();
//		
//		if(dr.getDoctorID().equals(""))
//		{
//			
//		}
//		return bool;
//		
//		
//		
//	}

	

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
//		ArrayList<DoctorBean> add=new ArrayList<>();
//		Connection con=null;
//		PreparedStatement ps1=null,ps2=null,ps3=null,ps4=null;
//		ResultSet rs1=null,rs2=null,rs3=null,rs4=null;
//		try
//		{
//			con=getCon();
//			String q1="Select problem from patient where patientid=?";	
//			ps1=con.prepareStatement(q1);
//			ps1.setString(1, "patientid");
//			rs1=ps1.executeQuery();
//			
//			String problem =null;
//			{
//				if(rs1.next())
//				{
//					problem=rs1.getString("problem");
//					
//				}
//				else
//				{
//					return add;
//				}
//			}
//			
//			
//			String q2="Select * from OCS_TBL_DOCTOR where specialization=?";
//			ps2=con.prepareStatement(q2);
//			ps2.setString(1, problem);
//			rs2=ps2.executeQuery();
//			ArrayList<DoctorBean> match=new ArrayList<>();
//			DoctorBean db=new DoctorBean();
//			db.setDoctorID(rs2.getString("doctorid"));
//			db.setDoctorName(rs2.getString("doctorname"));
//			db.setDateOfBirth(rs2.getDate("dateofbirth"));
//			db.setDateOfJoining(rs2.getDate("dateofjoining"));
//			db.setGender(rs2.getString("gender"));
//			db.setSpecialization(rs2.getString("specialization"));
//			db.setQualification(rs2.getString("qualification"));
//			db.setYearsOfExperience(rs2.getInt("yearsofexperience"));
//			db.setStreet(rs2.getString("street"));
//			db.setLocation(rs2.getString("location"));
//			db.setCity(rs2.getString("city"));
//			db.setState(rs2.getString("state"));
//			db.setPincode(rs2.getString("pincode"));
//			db.setContactNumber(rs2.getString("contactNumber"));
//			db.setEmailID(rs2.getString("emailid"));
//			
//			
//		      while (rs2.next()) {
//		    	  
//		    	  match.add(rs2.getString("doctorid"));
//		    	  
//		      }
//			
//			
//			String q3="";
//			ps3=con.prepareStatement(q3);
//			ps3.setString(1, null);
//			rs3=ps3.executeQuery();
//			
//		}catch(Exception e)
//		{
//			
//		}
		
		    ArrayList<DoctorBean> matchedDoctors = new ArrayList<>();  // To store matching doctors
		    Connection con = null;
		    PreparedStatement ps1 = null, ps2 = null;
		    ResultSet rs1 = null, rs2 = null;

		    try {
		        con = getCon();  // Get database connection

		        // 1. Get the ailment type of the patient based on the patient ID
		        String query1 = "SELECT ailment_type FROM patient WHERE patientid = ?";
		        ps1 = con.prepareStatement(query1);
		        ps1.setString(1, patientId);  // Set the patient ID
		        rs1 = ps1.executeQuery();

		        String ailmentType = null;
		        if (rs1.next()) {
		            ailmentType = rs1.getString("ailment_type");  // Get the ailment type
		        } else {
		            // If no patient found, return empty list
		            return matchedDoctors;
		        }

		        // 2. Find doctors who specialize in the patient's ailment type
		        String query2 = "SELECT * FROM OCS_TBL_DOCTOR WHERE specialization = ?";
		        ps2 = con.prepareStatement(query2);
		        ps2.setString(1, ailmentType);  // Set the ailment type as specialization
		        rs2 = ps2.executeQuery();

		        // 3. Loop through the result and add matching doctors to the list
		        while (rs2.next()) {
		            DoctorBean doctor = new DoctorBean();
		            doctor.setDoctorID(rs2.getString("doctorid"));
		            doctor.setDoctorName(rs2.getString("doctorname"));
		            doctor.setSpecialization(rs2.getString("specialization"));
		            doctor.setContactNumber(rs2.getString("contactNumber"));
		            doctor.setEmailID(rs2.getString("emailid"));
		            doctor.setYearsOfExperience(rs2.getInt("yearsofexperience"));
		            matchedDoctors.add(doctor);  // Add doctor to the list
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        // Close resources to prevent memory leaks
		        try {
		            if (rs1 != null) rs1.close();
		            if (rs2 != null) rs2.close();
		            if (ps1 != null) ps1.close();
		            if (ps2 != null) ps2.close();
		            if (con != null) con.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return matchedDoctors;  // Return the list of matching doctors
		}


	@Override
	public Map<PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate) {
		    Map<PatientBean, AppointmentBean> patientsByDate = new HashMap<>();
		    try {
		        String q = "SELECT * FROM OCS_TBL_APPOINTMENT WHERE appointmentDate = ?";
		        ps = con.prepareStatement(q);
		        ps.setDate(1, new java.sql.Date(appointmentDate.getTime()));  // Set the appointment date parameter
		        rs = ps.executeQuery();

		        while (rs.next()) {
		            AppointmentBean appointment = new AppointmentBean();
		            appointment.setAppointmentID(rs.getString("appointmentID"));
		            appointment.setDoctorID(rs.getString("doctorID"));
		            appointment.setPatientID(rs.getString("patientID"));
		            appointment.setAppointmentDate(rs.getDate("appointmentDate"));

		            // Assuming you have a way to fetch patient details, e.g., by patientID
		            PatientBean patient = new PatientBean();
		            patient.setPatientID(rs.getString("patientID"));
		            // Set other patient details...

		            patientsByDate.put(patient, appointment);  // Add to map
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return patientsByDate;
		}


	}

