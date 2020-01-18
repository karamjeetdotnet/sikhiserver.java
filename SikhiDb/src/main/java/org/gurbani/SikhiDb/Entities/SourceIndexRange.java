package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the source_index_range database table.
 * 
 */
@Entity
@Table(name="source_index_range")
@NamedQuery(name="SourceIndexRange.findAll", query="SELECT s FROM SourceIndexRange s")
public class SourceIndexRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	private String description;

	@Column(name="end_page")
	private Long endPage;

	@Column(name="start_page")
	private Long startPage;

	//bi-directional many-to-one association to BaniText
	@OneToMany(mappedBy="sourceIndexRange1")
	private List<BaniText> baniTexts1;

	//bi-directional many-to-one association to BaniText
	@OneToMany(mappedBy="sourceIndexRange2")
	private List<BaniText> baniTexts2;

	//bi-directional many-to-one association to SourceIndex
	@ManyToOne
	@JoinColumn(name="source_index_id")
	private SourceIndex sourceIndex;

	//bi-directional many-to-one association to Locale
	@ManyToOne(cascade = CascadeType.ALL)
	private Locale locale;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	//bi-directional many-to-one association to SourceIndexRange
	@ManyToOne
	@JoinColumn(name="source_index_range_id")
	private SourceIndexRange sourceIndexRange;

	//bi-directional many-to-one association to SourceIndexRange
	@OneToMany(mappedBy="sourceIndexRange")
	private List<SourceIndexRange> sourceIndexRanges;

	public SourceIndexRange() {
		this.sourceIndexRanges = new ArrayList<SourceIndexRange>();
	}
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getEndPage() {
		return this.endPage;
	}

	public void setEndPage(Long endPage) {
		this.endPage = endPage;
	}

	public long getStartPage() {
		return this.startPage;
	}

	public void setStartPage(Long startPage) {
		this.startPage = startPage;
	}

	public List<BaniText> getBaniTexts1() {
		return this.baniTexts1;
	}

	public void setBaniTexts1(List<BaniText> baniTexts1) {
		this.baniTexts1 = baniTexts1;
	}

	public BaniText addBaniTexts1(BaniText baniTexts1) {
		getBaniTexts1().add(baniTexts1);
		baniTexts1.setSourceIndexRange1(this);

		return baniTexts1;
	}

	public BaniText removeBaniTexts1(BaniText baniTexts1) {
		getBaniTexts1().remove(baniTexts1);
		baniTexts1.setSourceIndexRange1(null);

		return baniTexts1;
	}

	public List<BaniText> getBaniTexts2() {
		return this.baniTexts2;
	}

	public void setBaniTexts2(List<BaniText> baniTexts2) {
		this.baniTexts2 = baniTexts2;
	}

	public BaniText addBaniTexts2(BaniText baniTexts2) {
		getBaniTexts2().add(baniTexts2);
		baniTexts2.setSourceIndexRange2(this);

		return baniTexts2;
	}

	public BaniText removeBaniTexts2(BaniText baniTexts2) {
		getBaniTexts2().remove(baniTexts2);
		baniTexts2.setSourceIndexRange2(null);

		return baniTexts2;
	}

	public SourceIndex getSourceIndex() {
		return this.sourceIndex;
	}

	public void setSourceIndex(SourceIndex sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public FileSource getFileSource() {
		return this.fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

	public SourceIndexRange getSourceIndexRange() {
		return this.sourceIndexRange;
	}

	public void setSourceIndexRange(SourceIndexRange sourceIndexRange) {
		this.sourceIndexRange = sourceIndexRange;
	}

	public List<SourceIndexRange> getSourceIndexRanges() {
		return this.sourceIndexRanges;
	}

	public void setSourceIndexRanges(List<SourceIndexRange> sourceIndexRanges) {
		this.sourceIndexRanges = sourceIndexRanges;
	}

	public SourceIndexRange addSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().add(sourceIndexRange);
		sourceIndexRange.setSourceIndexRange(this);

		return sourceIndexRange;
	}

	public SourceIndexRange removeSourceIndexRange(SourceIndexRange sourceIndexRange) {
		getSourceIndexRanges().remove(sourceIndexRange);
		sourceIndexRange.setSourceIndexRange(null);

		return sourceIndexRange;
	}

}