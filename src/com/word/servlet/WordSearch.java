package com.word.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.word.dao.WordDao;
import com.word.dao.impl.WordDaoImpl;
import com.word.entity.Word;

@WebServlet("/search")
public class WordSearch extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WordDao wordDao = new WordDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int number = wordDao.getAll().size();
		Random random = new Random();
		int search = random.nextInt(number);
		if(search==0)
			search++;
		System.out.println(search);
		Word word = wordDao.query(search);
		System.out.println(word);
		JSONObject json = new JSONObject(word);
		resp.getWriter().print(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
