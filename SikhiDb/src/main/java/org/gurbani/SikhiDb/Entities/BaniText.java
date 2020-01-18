package org.gurbani.SikhiDb.Entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the bani_text database table.
 * 
 */
@Entity
@Table(name="bani_text")
@NamedQuery(name="BaniText.findAll", query="SELECT b FROM BaniText b")
public class BaniText implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="gurbani_db_id")
	private String gurbaniDbId;
	
	@Column(name="sttm_id")
	private Long sttmId;

	//bi-directional many-to-one association to FileSource
	@ManyToOne
	@JoinColumn(name="file_source_id")
	private FileSource fileSource;
	
	//bi-directional many-to-one association to SourceIndexRange
	@ManyToOne
	@JoinColumn(name="section_source_id")
	private SourceIndexRange sourceIndexRange1;

	//bi-directional many-to-one association to Writer
	@ManyToOne(cascade = CascadeType.ALL)
	private Writer writer;

	//bi-directional many-to-one association to SourceIndexRange
	@ManyToOne
	@JoinColumn(name="subsection_source_id")
	private SourceIndexRange sourceIndexRange2;

	//bi-directional many-to-one association to BaniTextLine
	@OneToMany(mappedBy="baniText", cascade = CascadeType.ALL)
	private List<BaniTextLine> baniTextLines;

	public BaniText() {
		baniTextLines = new ArrayList<BaniTextLine>();
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

	public Long getSttmId() {
		return this.sttmId;
	}

	public void setSttmId(Long sttmId) {
		this.sttmId = sttmId;
	}

	public FileSource getFileSource() {
		return this.fileSource;
	}

	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

	public SourceIndexRange getSourceIndexRange1() {
		return this.sourceIndexRange1;
	}

	public void setSourceIndexRange1(SourceIndexRange sourceIndexRange1) {
		this.sourceIndexRange1 = sourceIndexRange1;
	}

	public Writer getWriter() {
		return this.writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public SourceIndexRange getSourceIndexRange2() {
		return this.sourceIndexRange2;
	}

	public void setSourceIndexRange2(SourceIndexRange sourceIndexRange2) {
		this.sourceIndexRange2 = sourceIndexRange2;
	}

	public List<BaniTextLine> getBaniTextLines() {
		return this.baniTextLines;
	}

	public void setBaniTextLines(List<BaniTextLine> baniTextLines) {
		this.baniTextLines = baniTextLines;
	}

	public BaniTextLine addBaniTextLine(BaniTextLine baniTextLine) {
		getBaniTextLines().add(baniTextLine);
		baniTextLine.setBaniText(this);

		return baniTextLine;
	}

	public BaniTextLine removeBaniTextLine(BaniTextLine baniTextLine) {
		getBaniTextLines().remove(baniTextLine);
		baniTextLine.setBaniText(null);

		return baniTextLine;
	}

}