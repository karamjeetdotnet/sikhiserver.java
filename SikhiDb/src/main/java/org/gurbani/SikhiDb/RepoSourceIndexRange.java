package org.gurbani.SikhiDb;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.gurbani.SikhiDb.Entities.Locale;
import org.gurbani.SikhiDb.Entities.SourceIndexRange;

public class RepoSourceIndexRange extends DbContext<SourceIndexRange> {
	private Class<SourceIndexRange> entityClass;
	public RepoSourceIndexRange(Class<SourceIndexRange> entityClass) {
		super(entityClass);
		this.entityClass = entityClass;
	}
	//TODO: Implement static data model
	public SourceIndexRange findByName(String english, boolean isSubsection) {
		if(english == null) {
			return null;
		}
		CriteriaBuilder builder = session
				.getCriteriaBuilder();
		CriteriaQuery<SourceIndexRange> cq = builder.createQuery(entityClass);
		Root<SourceIndexRange> sIndex = cq.from(entityClass);
		Join<SourceIndexRange, Locale> sIndexLocale = sIndex.
				join("locale", JoinType.INNER);
		cq.select(sIndex);
		Predicate predicateNameEqual
		  = builder.equal(sIndexLocale.get("english"), english);
		Predicate precicateSIndex = null;
		if(isSubsection) {
			precicateSIndex = builder.isNotNull(sIndex.get("sourceIndexRange"));	
		} else {
			precicateSIndex = builder.isNull(sIndex.get("sourceIndexRange"));
		}
		cq.where(builder.and(predicateNameEqual, precicateSIndex));
		SourceIndexRange dataSI = session.createQuery(cq).
				getSingleResult();
		return dataSI;
	}
}
