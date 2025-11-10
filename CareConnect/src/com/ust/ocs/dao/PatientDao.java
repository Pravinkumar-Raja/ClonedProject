package com.ust.ocs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.ust.ocs.bean.AppointmentBean;
import com.ust.ocs.bean.DoctorBean;
import com.ust.ocs.bean.PatientBean;
import com.ust.ocs.service.Patient;

public class PatientDao implements Patient{

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
