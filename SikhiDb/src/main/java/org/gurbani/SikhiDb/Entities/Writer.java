package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the writer database table.
 * 
 */
@Entity
@NamedQuery(name="Writer.findAll", query="SELECT w FROM Writer w")
public class Writer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to BaniText
	@OneToMany(mappedBy="writer")
	private List<BaniText> baniTexts;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	//bi-directional many-to-one association to Locale
	@ManyToOne(cascade = CascadeType.ALL)
	private Locale locale;

	public Writer() {
	}
	public Writer(String writerName) {
	}
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<BaniText> getBaniTexts() {
		return this.baniTexts;
	}

	public void setBaniTexts(List<BaniText> baniTexts) {
		this.baniTexts = baniTexts;
	}

	public BaniText addBaniText(BaniText baniText) {
		getBaniTexts().add(baniText);
		baniText.setWriter(this);

		return baniText;
	}

	public BaniText removeBaniText(BaniText baniText) {
		getBaniTexts().remove(baniText);
		baniText.setWriter(null);

		return baniText;
	}

	public FileSource getFileSource() {
		return this.fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}