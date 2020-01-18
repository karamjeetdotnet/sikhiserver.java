package org.gurbani.SikhiDb;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.gurbani.SikhiDb.Entities.Locale;
import org.gurbani.SikhiDb.Entities.SourceIndex;

public class RepoSourceIndex extends DbContext<SourceIndex> {

	Class<SourceIndex> entityClass;
	public RepoSourceIndex(Class<SourceIndex> entityClass) {
		super(entityClass);
		this.entityClass = entityClass;
	}
	//TODO: Implement static data model
	public SourceIndex getFindByName(String english) {
		session.getTransaction().begin();
		CriteriaBuilder builder = session
				.getCriteriaBuilder();
		CriteriaQuery<SourceIndex> cq = builder.createQuery(entityClass);
		Root<SourceIndex> sIndex = cq.from(entityClass);
		Join<SourceIndex, Locale> sIndexLocale = sIndex.
				join("locale", JoinType.INNER);
		cq.select(sIndex);
		cq.where(builder.equal(sIndexLocale.get("english"), english));
		SourceIndex dataSI = session.createQuery(cq).
				getSingleResult();
		session.getTransaction().commit();
		return dataSI;
	}
}
