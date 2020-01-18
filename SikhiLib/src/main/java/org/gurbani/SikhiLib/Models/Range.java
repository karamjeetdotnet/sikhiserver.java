package org.gurbani.SikhiLib.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Range {

	public Range() {
		// TODO Auto-generated constructor stub
	}
	public String getStartLine() {
		return startLine;
	}
	public void setStartLine(String startLine) {
		this.startLine = startLine;
	}
	public String getEndLine() {
		return endLine;
	}
	public void setEndLine(String endLine) {
		this.endLine = endLine;
	}
	@JsonProperty("start_line")
	private String startLine;
	@JsonProperty("end_line")
	private String endLine;
}
