package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the bani_index database table.
 * 
 */
@Entity
@Table(name="bani_index")
@NamedQuery(name="BaniIndex.findAll", query="SELECT b FROM BaniIndex b")
public class BaniIndex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	//bi-directional many-to-one association to Locale
	@ManyToOne(cascade = CascadeType.ALL)
	private Locale locale;
	
	//bi-directional many-to-one association to BaniIndexRange
	@OneToMany(mappedBy="baniIndex", cascade = CascadeType.ALL)
	private List<BaniIndexRange> baniIndexRanges;

	public BaniIndex() {
		this.baniIndexRanges = new ArrayList<BaniIndexRange>();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<BaniIndexRange> getBaniIndexRanges() {
		return this.baniIndexRanges;
	}

	public void setBaniIndexRanges(List<BaniIndexRange> baniIndexRanges) {
		this.baniIndexRanges = baniIndexRanges;
	}

	public BaniIndexRange addBaniIndexRange(BaniIndexRange baniIndexRange) {
		getBaniIndexRanges().add(baniIndexRange);
		baniIndexRange.setBaniIndex(this);

		return baniIndexRange;
	}

	public BaniIndexRange removeBaniIndexRange(BaniIndexRange baniIndexRange) {
		getBaniIndexRanges().remove(baniIndexRange);
		baniIndexRange.setBaniIndex(null);

		return baniIndexRange;
	}

}