package com.ust.ocs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JOptionPane;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.CredentialBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;
import com.ust.ocs.service.Patient;

public class PatientDao implements Patient{

	
	 private static Connection con = AdministratorDao.getCon();
	    private static PreparedStatement ps;
	    private static ResultSet rs;
	public int loginPatient(CredentialBean creadential)
	{
		int isLoggedin=0;
        try {
            // SQL query to check the patient credentials
            String sql = "SELECT * FROM ocs_tbl_credentials WHERE USERID = ? AND PASSWORD = ? AND  USERTYPE = 'User'";
            ps = con.prepareStatement(sql);
            ps.setString(1, creadential.getUserID());
            ps.setString(2, creadential.getPassword());

            rs = ps.executeQuery();
            if (rs.next()) {
                // Login successful if userID and password match
                isLoggedin = 1;
            } else {
                // If no matching credentials, redirect to registration
                System.out.println("Invalid credentials. Please register.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLoggedin;
    }

	
//	public boolean redirectToRegistration(PatientBean patient, String password) {
//	   
//	    JOptionPane.showMessageDialog(null, "Please fill in your details to register as a patient.");
//	    boolean isRegistered = false;
//        try {
//            // Generate unique Patient ID if userID is not provided
//            if (patient.getUserID() == null || patient.getUserID().isEmpty()) {
//                patient.setUserID(generatePatientID()); // Set generated userID if not provided
//            }
//
//            // Insert the user credentials into ocs_tbl_credentials
//            String sqlCredentials = "INSERT INTO ocs_tbl_credentials (USERID, PASSWORD, USERTYPE, LOGINSTATUS) "
//                                    + "VALUES (?, ?, 'user', 1)";
//            ps = con.prepareStatement(sqlCredentials);
//            ps.setString(1, patient.getUserID()); // Use the patient ID or provided userID
//            ps.setString(2, password); // Store the password
//
//            int credentialResult = ps.executeUpdate();
//
//            // If credentials are inserted successfully, store patient details
//            if (credentialResult > 0) {
//                String sqlPatient = "INSERT INTO ocs_tbl_patients (patientid, userID, appointmentDate, ailmentType, ailmentDetails, diagnosisHistory) "
//                                    + "VALUES (?, ?, ?, ?, ?, ?)";
//                ps = con.prepareStatement(sqlPatient);
//                ps.setString(1, patient.getPatientID());
//                ps.setString(2, patient.getUserID()); // Use the patient ID or provided userID
//                ps.setDate(3, new java.sql.Date(patient.getAppointmentDate().getTime()));
//                ps.setString(4, patient.getAilmentType());
//                ps.setString(5, patient.getAilmentDetails());
//                ps.setString(6, patient.getDiagnosisHistory());
//
//                int patientResult = ps.executeUpdate();
//
//                if (patientResult > 0) {
//                    isRegistered = true;
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isRegistered;
//    }
	   

	    // Register method
	    public boolean register(PatientBean patient, String password) {
	    	 JOptionPane.showMessageDialog(null, "Please fill in your details to register as a patient.");
	    	    boolean isRegistered = false;
	    	    try {
	    	        // Generate unique Patient ID if not already provided
	    	        if (patient.getUserID() == null || patient.getUserID().isEmpty()) {
	    	            patient.setUserID(generatePatientID()); // Set generated userID if not provided
	    	        }

	    	        // Ensure USERID is not too long (truncate to 10 characters if needed)
	    	        if (patient.getUserID().length() > 10) {
	    	            patient.setUserID(patient.getUserID().substring(0, 10)); // Truncate to 10 characters
	    	        }

	    	        // Insert the user credentials into ocs_tbl_credentials
	    	        String sqlCredentials = "INSERT INTO ocs_tbl_credentials (USERID, PASSWORD, USERTYPE, LOGINSTATUS) "
	    	                                + "VALUES (?, ?, 'user', 1)";
	    	        ps = con.prepareStatement(sqlCredentials);
	    	        ps.setString(1, patient.getUserID());  // Use truncated userID
	    	        ps.setString(2, password);  // Store the password

	    	        int credentialResult = ps.executeUpdate();

	    	        // If credentials are inserted successfully, store patient details
	    	        if (credentialResult > 0) {
	    	            // Ensure PATIENTID doesn't exceed the column size (e.g., VARCHAR(50))
	    	            if (patient.getPatientID().length() > 50) {
	    	                patient.setPatientID(patient.getPatientID().substring(0, 50)); // Truncate if necessary
	    	            }

	    	            String sqlPatient = "INSERT INTO ocs_tbl_patient (patientid, userID, appointment_Date, ailment_Type, ailment_Details, diagnosis_History) "
	    	                                + "VALUES (?, ?, ?, ?, ?, ?)";
	    	            ps = con.prepareStatement(sqlPatient);
	    	            ps.setString(1, patient.getPatientID());  // Use generated or provided patientID
	    	            ps.setString(2, patient.getUserID());  // Use the userID for patient
	    	            ps.setDate(3, new java.sql.Date(patient.getAppointmentDate().getTime()));
	    	            ps.setString(4, patient.getAilmentType());
	    	            ps.setString(5, patient.getAilmentDetails());
	    	            ps.setString(6, patient.getDiagnosisHistory());

	    	            int patientResult = ps.executeUpdate();

	    	            if (patientResult > 0) {
	    	                isRegistered = true;
	    	            }
	    	        }

	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	    }
	    	    return isRegistered;
	    	}

	    	// Method to generate a unique Patient ID (shorter version)
	    	private String generatePatientID() {
	    	    // Use a shorter format that doesn't exceed the column size (e.g., 50 characters max)
	    	    String patientID = "PAT" + System.currentTimeMillis(); // Generates a long string with current timestamp

	    	    // Ensure the ID doesn't exceed 50 characters
	    	    if (patientID.length() > 50) {
	    	        patientID = patientID.substring(0, 50); // Truncate if necessary
	    	    }

	    	    return patientID;
	    	}
	

	@Override
	public String addAilmentDetails(PatientBean patientBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyAilmentDetails(PatientBean patientBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PatientBean> viewAilmentDetails(String patientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestforAppointment(String doctorID, Date appointmentDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
