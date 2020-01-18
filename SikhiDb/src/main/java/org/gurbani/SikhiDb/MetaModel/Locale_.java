package org.gurbani.SikhiDb.MetaModel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.gurbani.SikhiDb.Entities.Locale;

@StaticMetamodel(Locale.class)
public abstract class Locale_ {
	public static volatile SingularAttribute<Locale, String> english;
}