package com.ust.ocs.service;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;

import java.util.*;
public interface Administrator {
	
	public String addDoctor(DoctorBean doctoerBean) ;
	public Boolean modifyDoctor(DoctorBean doctorBean);
	public ArrayList<DoctorBean> viewAllDoctors() ;
	public int removeDoctor(String doctorID);
	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date) ;
	public Map <PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate);
	


}
