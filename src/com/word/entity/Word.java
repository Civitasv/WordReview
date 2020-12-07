package com.word.entity;

public class Word {

	private int id;
	private String word;
	private String translation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	@Override
	public String toString() {
		return "Word [word=" + word + ", translation=" + translation + "]";
	}
	public Word(String word, String translation) {
		super();
		this.word = word;
		this.translation = translation;
	}
	public Word() {
		super();
	}
	
}
