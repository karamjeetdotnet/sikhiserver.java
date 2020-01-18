package org.gurbani.SikhiLib.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Section extends Locale {

	public Section() {
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Long getStartPage() {
		return StartPage;
	}

	public void setStartPage(Long startPage) {
		StartPage = startPage;
	}

	public Long getEndPage() {
		return EndPage;
	}

	public void setEndPage(Long endPage) {
		EndPage = endPage;
	}

	public List<Section> getSubSections() {
		return SubSections;
	}

	public void setSubSections(List<Section> subSections) {
		SubSections = subSections;
	}

	@JsonProperty("description")
	private String Description;

	@JsonProperty("start_page")
	private Long StartPage;

	@JsonProperty("end_page")
	private Long EndPage;

	@JsonProperty("subsections")
	private List<Section> SubSections;
}
