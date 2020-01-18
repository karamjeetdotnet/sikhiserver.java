package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the source_index database table.
 * 
 */
@Entity
@Table(name="source_index")
@NamedQuery(name="SourceIndex.findAll", query="SELECT s FROM SourceIndex s")
public class SourceIndex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="english_page_name")
	private String englishPageName;

	@Column(name="gurmukhi_page_name")
	private String gurmukhiPageName;

	private int length;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	//bi-directional many-to-one association to Locale
	@ManyToOne(cascade = CascadeType.ALL)
	private Locale locale;

	//bi-directional many-to-one association to SourceIndexRange
	@OneToMany(mappedBy="sourceIndex", cascade = CascadeType.ALL)
	private List<SourceIndexRange> sourceIndexRanges;

	//bi-directional many-to-one association to TranslationSource
	@OneToMany(mappedBy="sourceIndex")
	private List<TranslationSource> translationSources;

	public SourceIndex() {
		this.sourceIndexRanges = new ArrayList<SourceIndexRange>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnglishPageName() {
		return this.englishPageName;
	}

	public void setEnglishPageName(String englishPageName) {
		this.englishPageName = englishPageName;
	}

	public String getGurmukhiPageName() {
		return this.gurmukhiPageName;
	}

	public void setGurmukhiPageName(String gurmukhiPageName) {
		this.gurmukhiPageName = gurmukhiPageName;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
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

	public List<SourceIndexRange> getSourceIndexRanges() {
		return this.sourceIndexRanges;
	}

	public void setSourceIndexRanges(List<SourceIndexRange> sourceIndexRanges) {
		this.sourceIndexRanges = sourceIndexRanges;
	}

	public SourceIndexRange addSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().add(sourceIndexRange);
		sourceIndexRange.setSourceIndex(this);

		return sourceIndexRange;
	}

	public SourceIndexRange removeSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().remove(sourceIndexRange);
		sourceIndexRange.setSourceIndex(null);

		return sourceIndexRange;
	}

	public List<TranslationSource> getTranslationSources() {
		return this.translationSources;
	}

	public void setTranslationSources(List<TranslationSource> translationSources) {
		this.translationSources = translationSources;
	}

	public TranslationSource addTranslationSource(TranslationSource translationSource) {
		getTranslationSources().add(translationSource);
		translationSource.setSourceIndex(this);

		return translationSource;
	}

	public TranslationSource removeTranslationSource(TranslationSource translationSource) {
		getTranslationSources().remove(translationSource);
		translationSource.setSourceIndex(null);

		return translationSource;
	}

}