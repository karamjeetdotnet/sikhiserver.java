package org.gurbani.SikhiLib.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source extends Locale {

	public Source() {
	}

	public Integer getLength() {
		return Length;
	}

	public void setLength(Integer length) {
		Length = length;
	}

	public String getEnglishPageName() {
		return EnglishPageName;
	}

	public void setEnglishPageName(String englishPageName) {
		EnglishPageName = englishPageName;
	}

	public String getGurmukhiPageName() {
		return GurmukhiPageName;
	}

	public void setGurmukhiPageName(String gurmukhiPageName) {
		GurmukhiPageName = gurmukhiPageName;
	}

	public List<Section> getSections() {
		return Sections;
	}

	public void setSections(List<Section> sections) {
		Sections = sections;
	}

	@JsonProperty("length")
	Integer Length;

	@JsonProperty("page_name_english")
	String EnglishPageName;

	@JsonProperty("page_name_gurmukhi")
	String GurmukhiPageName;

	@JsonProperty("sections")
	List<Section> Sections;
}
