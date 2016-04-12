package com.focus.androidserver.business;

import java.util.ArrayList;

import com.focus.androidserver.dao.PatientDAO;
import com.focus.androidserver.dao.UserDAO;
import com.focus.androidserver.model.PatientModel;

public class DatabaseService {
	
	public static String getSinglePass(String userName){
		String result = UserDAO.getSinglePass(userName);
		return result;
	}
	
	public static String userExists(String userName){
		String result = UserDAO.userExists(userName);
		return result;
	}
	
	public static ArrayList<PatientModel> getPatientsByUid(int uid){
		ArrayList<PatientModel> result = PatientDAO.getPatientsByUid(uid);
		return result;
	}
	
	public static int getIdByUsername(String userName){
		int result = UserDAO.getIdByUsername(userName);
		return result;
	}
	public static ArrayList<Integer> getPatientIdByUId(int uid){
		ArrayList<Integer> result = PatientDAO.getPatientIdByUId(uid);
		return result;
	}
	public static ArrayList<PatientModel> getPatientIdAndAgeByUId(int uid){
		ArrayList<PatientModel> result = PatientDAO.getPatientIdAndAgeByUId(uid);
		return result;
	}
	
}
