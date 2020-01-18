package org.gurbani.SikhiDb.MetaModel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.gurbani.SikhiDb.Entities.Locale;
import org.gurbani.SikhiDb.Entities.SourceIndex;

@StaticMetamodel(SourceIndex.class)
public abstract class SourceIndex_ {
	public static volatile SingularAttribute<SourceIndex, Locale> locale;
}