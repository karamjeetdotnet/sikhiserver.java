package org.gurbani.SikhiDb;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.gurbani.SikhiDb.Entities.Locale;
import org.gurbani.SikhiDb.Entities.Writer;

public class RepoWriter extends DbContext<Writer> {
	private Class<Writer> entityClass;
	public RepoWriter(Class<Writer> entityClass) {
		super(entityClass);
		this.entityClass = entityClass;
	}

	public Writer findByName(String writer) {
		CriteriaBuilder builder = session
				.getCriteriaBuilder();
		CriteriaQuery<Writer> cq = builder.createQuery(entityClass);
		Root<Writer> sIndex = cq.from(entityClass);
		Join<Writer, Locale> sIndexLocale = sIndex.
				join("locale", JoinType.INNER);
		cq.select(sIndex);
		cq.where(builder.equal(sIndexLocale.get("english"), writer));
		Writer dataSI = session.createQuery(cq).
				getSingleResult();
		return dataSI;
	}

}
