package com.focus.androidserver.dao;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.focus.androidserver.model.AnswerModel;
import com.focus.androidserver.server.JdbcUtil;

public class AnswerDAO {
	private static Logger log = Logger.getLogger(AnswerDAO.class);
	
	public static void saveAnswer (AnswerModel answer){
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql = String.format("INSERT INTO user_ques_anws (uid, qid, answer, updatetime) "
					+ "VALUES ('%d', '%d', '%s', '%s')", 
					answer.getUid(), answer.getQid(), answer.getAnswer(), answer.getUpdatetime());
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
				int res = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			}
		} catch (Exception e) {
			log.error("Statement in answer by uid error", e);
			e.printStackTrace();
		}
	}

	public static void updateAnswer(AnswerModel answer) {
		try ( Connection con = JdbcUtil.getConnection()) {
			String sql = String.format("UPDATE user_ques_anws"
					+ "SET answer = '%s', updatetime = '%s' WHERE uid = '%d' and qid = '%d'", 
					answer.getUid(), answer.getQid(), answer.getAnswer(), answer.getUpdatetime());
			try (Statement st = con.createStatement()) {
				System.out.println(sql);
				int res = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			}
		} catch (Exception e) {
			log.error("Statement in answer by uid error", e);
			e.printStackTrace();
		}
		
	}
}
