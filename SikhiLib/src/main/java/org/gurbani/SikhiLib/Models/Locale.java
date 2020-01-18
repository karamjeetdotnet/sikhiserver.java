package org.gurbani.SikhiLib.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Locale {

	public Locale() {
	}
	public String getGurmukhiName() {
		return gurmukhiName;
	}
	public void setGurmukhiName(String gurmukhiName) {
		this.gurmukhiName = gurmukhiName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getInternationalName() {
		return internationalName;
	}
	public void setInternationalName(String internationalName) {
		this.internationalName = internationalName;
	}

	@JsonProperty("name_gurmukhi")
	private String gurmukhiName;
	@JsonProperty("name_english")
	private String englishName;
	@JsonProperty("name_international")
	private String internationalName;
}
