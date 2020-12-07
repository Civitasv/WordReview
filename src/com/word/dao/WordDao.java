package com.word.dao;

import java.util.List;

import com.word.entity.Word;

public interface WordDao {

	// 插入
	public int insert(Word word);

	// 删除
	public void delete();

	// 寻找
	public Word query(int id);
	
	//单词总数
	public List<Word> getAll();
}
