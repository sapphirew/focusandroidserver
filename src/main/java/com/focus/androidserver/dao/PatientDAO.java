package com.focus.androidserver.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.focus.androidserver.model.PatientModel;
import com.focus.androidserver.model.UserModel;
import com.focus.androidserver.server.JdbcUtil;

public class PatientDAO {
	
	private static Logger log = Logger.getLogger(PatientDAO.class);
	
	public static ArrayList<PatientModel> getPatientsByUid(int uid){
		ArrayList<PatientModel> result = new ArrayList<>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select p.patientid, med_no, patient_name, patient_address,"
					+ "patient_phone_number, gender, isfinished, age, a.uid from patients p, patientsassigns a"
					+ " where p.patientid = a.patientid and a.uid = " + uid;
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result.add(new PatientModel(rs.getInt(1),rs. getInt(2), rs.getString(3), rs.getString(4),
							rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)));
				}
			} catch (Exception e) {
				log.error("Statement in patients search by uid error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("patients search by uid error", e);
			e.printStackTrace();
			result = null;
		}

		return result;

	}
	
	public static ArrayList<PatientModel> getPatientIdAndUIdByUId(int uid){
		ArrayList<PatientModel> result = new ArrayList<>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select p.patientid from patients p, patientsassigns a"
					+ " where p.patientid = a.patientid and a.uid = " + uid;
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result.add(new PatientModel(rs.getInt(1), uid));
				}
			} catch (Exception e) {
				log.error("Statement in patientids search by uid error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("patientids search by uid error", e);
			e.printStackTrace();
			result = null;
		}

		return result;

	}
	public static ArrayList<Integer> getPatientIdByUId(int uid){
		ArrayList<Integer> result = new ArrayList<>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select p.patientid from patients p, patientsassigns a"
					+ " where p.patientid = a.patientid and a.uid = " + uid;
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result.add(rs.getInt(1));
				}
			} catch (Exception e) {
				log.error("Statement in patientids search by uid error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("patientids search by uid error", e);
			e.printStackTrace();
			result = null;
		}

		return result;

	}
	public static ArrayList<PatientModel> getPatientIdAndAgeByUId(int uid){
		ArrayList<PatientModel> result = new ArrayList<>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select p.patientid, dob from patients p, patientsassigns a"
					+ " where p.patientid = a.patientid and a.uid = " + uid;
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
			    LocalDate today = LocalDate.now();
				while (rs.next()){
//					System.out.println(rs.getDate(2));
				    Instant instant = Instant.ofEpochMilli(rs.getDate(2).getTime());
				    LocalDate date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
					Period p = Period.between(date, today);
					result.add(new PatientModel(rs.getInt(1), uid, p.getYears()));
				}
			} catch (Exception e) {
				log.error("Statement in patientids, age search by uid error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("patientids, age search by uid error", e);
			e.printStackTrace();
			result = null;
		}

		return result;

	}
}
