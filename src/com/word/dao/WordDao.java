package com.word.dao;

import java.util.List;

import com.word.entity.Word;

public interface WordDao {

	// ����
	public int insert(Word word);

	// ɾ��
	public void delete();

	// Ѱ��
	public Word query(int id);
	
	//��������
	public List<Word> getAll();
}
