package com.word.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.word.dao.WordDao;
import com.word.entity.Word;
import com.word.mysql.DBHelper;

public class WordDaoImpl implements WordDao {
	@Override
	public int insert(Word word) {
		String sql = "insert into word (word,translation) values (?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBHelper.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word.getWord());
			pstmt.setString(2, word.getTranslation());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return -1;
	}

	@Override
	public void delete() {

	}

	@Override
	public Word query(int id) {
		String sql = "select * from word where id="+ id;
		System.out.println(sql);
		Word word = new Word();
		try (Connection conn = DBHelper.getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();) {

			if (rs.next()) {
				word.setTranslation(rs.getString("translation"));
				word.setWord(rs.getString("word"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return word;
	}

	@Override
	public List<Word> getAll() {
		List<Word> list = new ArrayList<Word>();
		String sql = "select *from word";
		try (Connection conn = DBHelper.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				Word word = new Word();
				word.setTranslation(rs.getString("translation"));
				word.setWord(rs.getString("word"));
				list.add(word);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
