package com.focus.androidserver.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.focus.androidserver.model.UserModel;
import com.focus.androidserver.server.JdbcUtil;


public class UserDAO {
	private static Logger log = Logger.getLogger(UserDAO.class);
	
	public static ArrayList<UserModel> getAllUsers(){
		ArrayList<UserModel> result = new ArrayList<UserModel>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select * from users";
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8),
							rs.getString(9), 
							rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13)));
				}
			} catch (Exception e) {
				log.error("Statement in users search error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("users search error", e);
			e.printStackTrace();
			result = null;
		}

		return result;

	}
	
	public static String getNameById(int id){
		UserModel result = new UserModel();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select * from users where id = " + id;
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result = new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8),
							rs.getString(9), 
							rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
				}
			} catch (Exception e) {
				log.error("Statement in users search error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("users search error", e);
			e.printStackTrace();
			result = null;
		}

		return result.getFirstName() + " " + result.getLastName();

	}
	
	/**
	 * @param userName
	 * @return
	 */
	public static String userExists(String userName){
		String result = "";
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select loginid from users where loginid = '" + userName +"'";
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result = rs.getString(1);
				}
			} catch (Exception e) {
				log.error("Statement in users search error", e);
				e.printStackTrace();
				result = null;
			}

		}
		 catch (Exception e) {
			log.error("users search error", e);
			e.printStackTrace();
			result = null;
		}
		if (result == "") result = "NOT EXIST";
		return result;
	}
	
	public static String getSinglePass(String userName){
        String result = "";
        try {
            Connection con = JdbcUtil.getConnection();
            String sql= "select password from users where loginid = '" + userName +"'";
            try {
                Statement st = con.createStatement();
                System.out.println(sql);
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    result = rs.getString(1);
                }
            } catch (Exception e) {
                log.error("Statement in users search error" + e);
                e.printStackTrace();
                result = "";
            }

        }
        catch (Exception e) {
            log.error("users search error" + e);
            e.printStackTrace();
            result = "";
        }
        System.out.println("Userdao: "+result);
        if (result.length() == 0) return "NOT EXIST";

        return result;
    }
	public static int getIdByUsername(String userName){
        int result = 0;
        try {
            Connection con = JdbcUtil.getConnection();
            String sql= "select id from users where loginid = '" + userName + "'";
            try {
                Statement st = con.createStatement();
                System.out.println(sql);
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    result = rs.getInt(1);
                }
            } catch (Exception e) {
                log.error("Statement in users search error" + e);
                e.printStackTrace();
                result = 0;
            }

        }
        catch (Exception e) {
            log.error("users search error" + e);
            e.printStackTrace();
            result = 0;
        }
        System.out.println("Userdao uid: "+result);

        return result;
    }
	public static ArrayList<UserModel> getPatientsAndVolunteers(){
		ArrayList<UserModel> result = new ArrayList<UserModel>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select * from users where usertype = 'patient' or usertype = 'volunteer'";
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8),
							rs.getString(9), 
							rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13)));
				}
			} catch (Exception e) {
				log.error("Statement in users search error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("users search error", e);
			e.printStackTrace();
			result = null;
		}

		return result;
	}
	public static ArrayList<UserModel> getPatientsAndVolunteersWithQuestions(){
		ArrayList<UserModel> result = new ArrayList<UserModel>();
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql= "select * from users where usertype = 'patient' or usertype = 'volunteer'";
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
			    ResultSet rs = st.executeQuery(sql);
				while (rs.next()){
					result.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), 
							rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8),
							rs.getString(9), 
							rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13)));
				}
			} catch (Exception e) {
				log.error("Statement in users search error", e);
				e.printStackTrace();
				result = null;
			}

			}
		 catch (Exception e) {
			log.error("users search error", e);
			e.printStackTrace();
			result = null;
		}

		return result;

	}
}
