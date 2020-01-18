package org.gurbani.SikhiLib.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bani extends Locale {

	public Bani() {
	}
	
	public List<Range> getLines() {
		return lines;
	}
	public void setLines(List<Range> lines) {
		this.lines = lines;
	}
	
	@JsonProperty("lines")
	private List<Range> lines;
}
