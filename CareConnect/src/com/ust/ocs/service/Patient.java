package com.ust.ocs.service;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;
import java.util.*;

public interface Patient {
	public String addAilmentDetails(PatientBean patientBean);
	public boolean modifyAilmentDetails(PatientBean patientBean);
	public ArrayList<PatientBean> viewAilmentDetails(String patientID);
	public ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date); 
	public String requestforAppointment(String doctorID, Date appointmentDate);
	public Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date);
	
	
}
