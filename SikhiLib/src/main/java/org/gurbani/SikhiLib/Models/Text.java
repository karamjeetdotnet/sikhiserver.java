package org.gurbani.SikhiLib.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text {

	public Text() {
	}

	public String getGurbaniDbId() {
		return GurbaniDbId;
	}

	public void setGurbaniDbId(String gurbaniDbId) {
		GurbaniDbId = gurbaniDbId;
	}

	public Long getSttmId() {
		return SttmId;
	}

	public void setSttmId(Long sttmId) {
		SttmId = sttmId;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public String getSubSection() {
		return SubSection;
	}

	public void setSubSection(String subSection) {
		SubSection = subSection;
	}

	public List<TextLine> getLines() {
		return Lines;
	}

	public void setLines(List<TextLine> lines) {
		Lines = lines;
	}

	@JsonProperty("writer")
	private String Writer;

	@JsonProperty("section")
	private String Section;

	@JsonProperty("subsection")
	private String SubSection;

	@JsonProperty("lines")
	private List<TextLine> Lines;

	@JsonProperty("id")
	private String GurbaniDbId;

	@JsonProperty("sttm_id")
	private Long SttmId;

}
