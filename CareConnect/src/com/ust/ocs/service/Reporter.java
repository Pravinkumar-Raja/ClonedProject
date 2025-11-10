package com.ust.ocs.service;
import com.ust.ocs.bean.*;
import java.util.*;
public interface Reporter {
	
	public ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
	public ArrayList<DoctorBean> intimateAdmin(Date date, String status);
	

}
