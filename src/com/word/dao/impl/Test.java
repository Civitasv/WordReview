package com.word.dao.impl;

import com.word.dao.WordDao;
import com.word.entity.Word;

public class Test {

	static WordDao wordDao = new WordDaoImpl();
	public static void main(String[] args) {
		Word obj = new Word("huseb","test");
		wordDao.insert(obj);
	}
}
