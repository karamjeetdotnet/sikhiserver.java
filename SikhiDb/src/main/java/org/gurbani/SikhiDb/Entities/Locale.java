package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locale database table.
 * 
 */
@Entity
@NamedQuery(name="Locale.findAll", query="SELECT l FROM Locale l")
public class Locale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	private String english;

	@Lob
	private String gurmukhi;

	@Lob
	private String internatinal;

	//bi-directional many-to-one association to BaniIndex
	@OneToMany(mappedBy="locale")
	private List<BaniIndex> baniIndexs;

	//bi-directional many-to-one association to Language
	@OneToMany(mappedBy="locale")
	private List<Language> languages;

	//bi-directional many-to-one association to SourceIndex
	@OneToMany(mappedBy="locale")
	private List<SourceIndex> sourceIndexs;

	//bi-directional many-to-one association to SourceIndexRange
	@OneToMany(mappedBy="locale")
	private List<SourceIndexRange> sourceIndexRanges;

	//bi-directional many-to-one association to TranslationSource
	@OneToMany(mappedBy="locale")
	private List<TranslationSource> translationSources;

	//bi-directional many-to-one association to Writer
	@OneToMany(mappedBy="locale")
	private List<Writer> writers;

	public Locale() {
	}
	public Locale(String english, String gurmukhi, String international) {
		this.english = english;
		this.gurmukhi = gurmukhi;
		this.internatinal = international;
	}
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnglish() {
		return this.english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getGurmukhi() {
		return this.gurmukhi;
	}

	public void setGurmukhi(String gurmukhi) {
		this.gurmukhi = gurmukhi;
	}

	public String getInternatinal() {
		return this.internatinal;
	}

	public void setInternatinal(String internatinal) {
		this.internatinal = internatinal;
	}

	public List<BaniIndex> getBaniIndexs() {
		return this.baniIndexs;
	}

	public void setBaniIndexs(List<BaniIndex> baniIndexs) {
		this.baniIndexs = baniIndexs;
	}

	public BaniIndex addBaniIndex(BaniIndex baniIndex) {
		getBaniIndexs().add(baniIndex);
		baniIndex.setLocale(this);

		return baniIndex;
	}

	public BaniIndex removeBaniIndex(BaniIndex baniIndex) {
		getBaniIndexs().remove(baniIndex);
		baniIndex.setLocale(null);

		return baniIndex;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language addLanguage(Language language) {
		getLanguages().add(language);
		language.setLocale(this);

		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		language.setLocale(null);

		return language;
	}

	public List<SourceIndex> getSourceIndexs() {
		return this.sourceIndexs;
	}

	public void setSourceIndexs(List<SourceIndex> sourceIndexs) {
		this.sourceIndexs = sourceIndexs;
	}

	public SourceIndex addSourceIndex(SourceIndex sourceIndex) {
		getSourceIndexs().add(sourceIndex);
		sourceIndex.setLocale(this);

		return sourceIndex;
	}

	public SourceIndex removeSourceIndex(SourceIndex sourceIndex) {
		getSourceIndexs().remove(sourceIndex);
		sourceIndex.setLocale(null);

		return sourceIndex;
	}

	public List<SourceIndexRange> getSourceIndexRanges() {
		return this.sourceIndexRanges;
	}

	public void setSourceIndexRanges(List<SourceIndexRange> sourceIndexRanges) {
		this.sourceIndexRanges = sourceIndexRanges;
	}

	public SourceIndexRange addSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().add(sourceIndexRange);
		sourceIndexRange.setLocale(this);

		return sourceIndexRange;
	}

	public SourceIndexRange removeSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().remove(sourceIndexRange);
		sourceIndexRange.setLocale(null);

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
		translationSource.setLocale(this);

		return translationSource;
	}

	public TranslationSource removeTranslationSource(TranslationSource translationSource) {
		getTranslationSources().remove(translationSource);
		translationSource.setLocale(null);

		return translationSource;
	}

	public List<Writer> getWriters() {
		return this.writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

	public Writer addWriter(Writer writer) {
		getWriters().add(writer);
		writer.setLocale(this);

		return writer;
	}

	public Writer removeWriter(Writer writer) {
		getWriters().remove(writer);
		writer.setLocale(null);

		return writer;
	}

}