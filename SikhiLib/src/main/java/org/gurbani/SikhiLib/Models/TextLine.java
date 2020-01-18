package org.gurbani.SikhiLib.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class TextLine {

	public TextLine() {
		// TODO Auto-generated constructor stub
	}
	
	public String getGurbaniDbId() {
		return gurbaniDbId;
	}

	public void setGurbaniDbId(String gurbaniDbId) {
		this.gurbaniDbId = gurbaniDbId;
	}

	public long getSourcePage() {
		return sourcePage;
	}

	public void setSourcePage(long sourcePage) {
		this.sourcePage = sourcePage;
	}

	public Long getSourceLine() {
		return sourceLine;
	}

	public void setSourceLine(Long sourceLine) {
		this.sourceLine = sourceLine;
	}

	public String getGurmukhi() {
		return gurmukhi;
	}

	public void setGurmukhi(String gurmukhi) {
		this.gurmukhi = gurmukhi;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}

	public String getPronunciationInformation() {
		return pronunciationInformation;
	}

	public void setPronunciationInformation(String pronunciationInformation) {
		this.pronunciationInformation = pronunciationInformation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	@JsonProperty("translations")
	public void setTranslation(JsonNode translation) {
		this.translation = translation != null ? translation.toString() : "";
	}


	@JsonProperty("id")
	String gurbaniDbId;

	@JsonProperty("source_page")
	long sourcePage;

	@JsonProperty("source_line")
	Long sourceLine;

	@JsonProperty("gurmukhi")
	String gurmukhi;

	@JsonProperty("pronunciation")
	String pronunciation;

	@JsonProperty("pronunciation_information")
	String pronunciationInformation;

	@JsonProperty("type")
	String type;

	String translation;
}
