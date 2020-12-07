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

@WebServlet("/add")
public class WordAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WordDao wordDao = new WordDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String word = req.getParameter("word");
		String translation = req.getParameter("translation");
		Word obj = new Word(word,translation);
		System.out.println(obj);
		wordDao.insert(obj);
		resp.getWriter().print("成功啦");
		//各种判断就不写了。
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
