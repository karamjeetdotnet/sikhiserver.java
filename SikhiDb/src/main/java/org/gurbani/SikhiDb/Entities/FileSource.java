package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the file_source database table.
 * 
 */
@Entity
@Table(name="file_source")
@NamedQuery(name="FileSource.findAll", query="SELECT f FROM FileSource f")
public class FileSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	private String content;

	@Column(name="file_name")
	private String fileName;

	private String source;

	//bi-directional many-to-one association to BaniIndex
	@OneToMany(mappedBy="fileSource")
	private List<BaniIndex> baniIndexs;

	//bi-directional many-to-one association to BaniIndexRange
	@OneToMany(mappedBy="fileSource")
	private List<BaniIndexRange> baniIndexRanges;

	//bi-directional many-to-one association to BaniText
	@OneToMany(mappedBy="fileSource")
	private List<BaniText> baniTexts;

	//bi-directional many-to-one association to BaniTextLine
	@OneToMany(mappedBy="fileSource")
	private List<BaniTextLine> baniTextLines;

	//bi-directional many-to-one association to Language
	@OneToMany(mappedBy="fileSource")
	private List<Language> languages;

	//bi-directional many-to-one association to SourceIndex
	@OneToMany(mappedBy="fileSource")
	private List<SourceIndex> sourceIndexs;

	//bi-directional many-to-one association to SourceIndexRange
	@OneToMany(mappedBy="fileSource")
	private List<SourceIndexRange> sourceIndexRanges;

	//bi-directional many-to-one association to TranslationSource
	@OneToMany(mappedBy="fileSource")
	private List<TranslationSource> translationSources;

	//bi-directional many-to-one association to Writer
	@OneToMany(mappedBy="fileSource")
	private List<Writer> writers;

	public FileSource() {
	}
	public FileSource(long id) {
		super();
		this.id = id;
	}
	public FileSource(String content, String fileName, String source) {
		super();
		this.content = content;
		this.fileName = fileName;
		this.source = source;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<BaniIndex> getBaniIndexs() {
		return this.baniIndexs;
	}

	public void setBaniIndexs(List<BaniIndex> baniIndexs) {
		this.baniIndexs = baniIndexs;
	}

	public BaniIndex addBaniIndex(BaniIndex baniIndex) {
		getBaniIndexs().add(baniIndex);
		baniIndex.setFileSource(this);

		return baniIndex;
	}

	public BaniIndex removeBaniIndex(BaniIndex baniIndex) {
		getBaniIndexs().remove(baniIndex);
		baniIndex.setFileSource(null);

		return baniIndex;
	}

	public List<BaniIndexRange> getBaniIndexRanges() {
		return this.baniIndexRanges;
	}

	public void setBaniIndexRanges(List<BaniIndexRange> baniIndexRanges) {
		this.baniIndexRanges = baniIndexRanges;
	}

	public BaniIndexRange addBaniIndexRange(BaniIndexRange baniIndexRange) {
		getBaniIndexRanges().add(baniIndexRange);
		baniIndexRange.setFileSource(this);

		return baniIndexRange;
	}

	public BaniIndexRange removeBaniIndexRange(BaniIndexRange baniIndexRange) {
		getBaniIndexRanges().remove(baniIndexRange);
		baniIndexRange.setFileSource(null);

		return baniIndexRange;
	}

	public List<BaniText> getBaniTexts() {
		return this.baniTexts;
	}

	public void setBaniTexts(List<BaniText> baniTexts) {
		this.baniTexts = baniTexts;
	}

	public BaniText addBaniText(BaniText baniText) {
		getBaniTexts().add(baniText);
		baniText.setFileSource(this);

		return baniText;
	}

	public BaniText removeBaniText(BaniText baniText) {
		getBaniTexts().remove(baniText);
		baniText.setFileSource(null);

		return baniText;
	}

	public List<BaniTextLine> getBaniTextLines() {
		return this.baniTextLines;
	}

	public void setBaniTextLines(List<BaniTextLine> baniTextLines) {
		this.baniTextLines = baniTextLines;
	}

	public BaniTextLine addBaniTextLine(BaniTextLine baniTextLine) {
		getBaniTextLines().add(baniTextLine);
		baniTextLine.setFileSource(this);

		return baniTextLine;
	}

	public BaniTextLine removeBaniTextLine(BaniTextLine baniTextLine) {
		getBaniTextLines().remove(baniTextLine);
		baniTextLine.setFileSource(null);

		return baniTextLine;
	}

	public List<Language> getLanguages() {
		return this.languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language addLanguage(Language language) {
		getLanguages().add(language);
		language.setFileSource(this);

		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		language.setFileSource(null);

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
		sourceIndex.setFileSource(this);

		return sourceIndex;
	}

	public SourceIndex removeSourceIndex(SourceIndex sourceIndex) {
		getSourceIndexs().remove(sourceIndex);
		sourceIndex.setFileSource(null);

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
		sourceIndexRange.setFileSource(this);

		return sourceIndexRange;
	}

	public SourceIndexRange removeSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().remove(sourceIndexRange);
		sourceIndexRange.setFileSource(null);

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
		translationSource.setFileSource(this);

		return translationSource;
	}

	public TranslationSource removeTranslationSource(TranslationSource translationSource) {
		getTranslationSources().remove(translationSource);
		translationSource.setFileSource(null);

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
		writer.setFileSource(this);

		return writer;
	}

	public Writer removeWriter(Writer writer) {
		getWriters().remove(writer);
		writer.setFileSource(null);

		return writer;
	}

}