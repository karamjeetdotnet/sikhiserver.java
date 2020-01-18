package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bani_index_range database table.
 * 
 */
@Entity
@Table(name="bani_index_range")
@NamedQuery(name="BaniIndexRange.findAll", query="SELECT b FROM BaniIndexRange b")
public class BaniIndexRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String end;

	private String start;

	//bi-directional many-to-one association to BaniIndex
	@ManyToOne
	@JoinColumn(name="bani_index_id")
	private BaniIndex baniIndex;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;

	public BaniIndexRange() {
	}
	public BaniIndexRange(String start, String end, FileSource fileSource) {
		this.start = start;
		this.end = end;
		this.fileSource = fileSource;
	}
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public BaniIndex getBaniIndex() {
		return this.baniIndex;
	}

	public void setBaniIndex(BaniIndex baniIndex) {
		this.baniIndex = baniIndex;
	}

	public FileSource getFileSource() {
		return this.fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

}