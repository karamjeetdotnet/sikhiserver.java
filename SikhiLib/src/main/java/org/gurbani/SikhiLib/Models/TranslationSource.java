package org.gurbani.SikhiLib.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranslationSource extends Locale {

	public TranslationSource() {
		// TODO Auto-generated constructor stub
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	@JsonProperty("source")
	String Source;

	@JsonProperty("language")
	String Language;
}
