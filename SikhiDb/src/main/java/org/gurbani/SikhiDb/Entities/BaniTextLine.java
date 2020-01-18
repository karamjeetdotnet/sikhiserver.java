package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bani_text_line database table.
 * 
 */
@Entity
@Table(name="bani_text_line")
@NamedQuery(name="BaniTextLine.findAll", query="SELECT b FROM BaniTextLine b")
public class BaniTextLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="gurbani_db_id")
	private String gurbaniDbId;

	@Lob
	private String gurmukhi;

	@Lob
	private String pronunciation;

	@Lob
	@Column(name="pronunciation_information")
	private String pronunciationInformation;

	@Column(name="source_line")
	private Long sourceLine;

	@Column(name="source_page")
	private Long sourcePage;

	@Lob
	private String translation;

	//bi-directional many-to-one association to BaniText
	@ManyToOne
	@JoinColumn(name="bani_text_id")
	private BaniText baniText;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	private String initial;
	
	public BaniTextLine() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
		
	public String getGurbaniDbId() {
		return this.gurbaniDbId;
	}

	public void setGurbaniDbId(String gurbaniDbId) {
		this.gurbaniDbId = gurbaniDbId;
	}

	public String getGurmukhi() {
		return this.gurmukhi;
	}

	public void setGurmukhi(String gurmukhi) {
		this.gurmukhi = gurmukhi;
	}

	public String getPronunciation() {
		return this.pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}

	public String getPronunciationInformation() {
		return this.pronunciationInformation;
	}

	public void setPronunciationInformation(String pronunciationInformation) {
		this.pronunciationInformation = pronunciationInformation;
	}

	public Long getSourceLine() {
		return this.sourceLine;
	}

	public void setSourceLine(Long sourceLine) {
		this.sourceLine = sourceLine;
	}

	public Long getSourcePage() {
		return this.sourcePage;
	}

	public void setSourcePage(Long sourcePage) {
		this.sourcePage = sourcePage;
	}

	public String getTranslation() {
		return this.translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public BaniText getBaniText() {
		return this.baniText;
	}

	public void setBaniText(BaniText baniText) {
		this.baniText = baniText;
	}

	public FileSource getFileSource() {
		return this.fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

}