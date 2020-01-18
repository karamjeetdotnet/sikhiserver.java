package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the translation_source database table.
 * 
 */
@Entity
@Table(name="translation_source")
@NamedQuery(name="TranslationSource.findAll", query="SELECT t FROM TranslationSource t")
public class TranslationSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String language;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	//bi-directional many-to-one association to Locale
	@ManyToOne(cascade = CascadeType.ALL)
	private Locale locale;

	//bi-directional many-to-one association to SourceIndex
	@ManyToOne
	@JoinColumn(name="source_index_id")
	private SourceIndex sourceIndex;

	public TranslationSource() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public SourceIndex getSourceIndex() {
		return this.sourceIndex;
	}

	public void setSourceIndex(SourceIndex sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

}