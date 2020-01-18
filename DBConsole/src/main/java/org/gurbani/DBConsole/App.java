package org.gurbani.DBConsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.gurbani.SikhiDb.RepoBaniIndex;
import org.gurbani.SikhiDb.RepoBaniText;
import org.gurbani.SikhiDb.RepoDbSystemInfo;
import org.gurbani.SikhiDb.RepoFileSource;
import org.gurbani.SikhiDb.RepoLanguage;
import org.gurbani.SikhiDb.RepoSourceIndex;
import org.gurbani.SikhiDb.RepoSourceIndexRange;
import org.gurbani.SikhiDb.RepoTranslationSource;
import org.gurbani.SikhiDb.RepoWriter;
import org.gurbani.SikhiDb.Entities.BaniIndex;
import org.gurbani.SikhiDb.Entities.BaniIndexRange;
import org.gurbani.SikhiDb.Entities.BaniText;
import org.gurbani.SikhiDb.Entities.BaniTextLine;
import org.gurbani.SikhiDb.Entities.DbSystemInfo;
import org.gurbani.SikhiDb.Entities.FileSource;
import org.gurbani.SikhiDb.Entities.Language;
import org.gurbani.SikhiDb.Entities.SourceIndex;
import org.gurbani.SikhiDb.Entities.SourceIndexRange;
import org.gurbani.SikhiDb.Entities.Writer;
import org.gurbani.SikhiLib.AppFileReader;
import org.gurbani.SikhiLib.Models.Bani;
import org.gurbani.SikhiLib.Models.Locale;
import org.gurbani.SikhiLib.Models.Range;
import org.gurbani.SikhiLib.Models.Section;
import org.gurbani.SikhiLib.Models.Source;
import org.gurbani.SikhiLib.Models.Text;
import org.gurbani.SikhiLib.Models.TextLine;
import org.gurbani.SikhiLib.Models.TranslationSource;


/**
 * Hello world!
 *
 */
public class App 
{
	final static String BaniPath = "G:/Storage Space/visualStudio/startuped/database-master/database-master/data/";
	static AppFileReader fileReader;
	static List<BaniIndex> baniIndices = new ArrayList<BaniIndex>();
    static List<BaniIndexRange> baniIndexRanges = new ArrayList<BaniIndexRange>();
    static List<BaniText> baniTexts = new ArrayList<BaniText>();
    static List<BaniTextLine> baniTextLines = new ArrayList<BaniTextLine>();
    static List<FileSource> fileSources = new ArrayList<FileSource>();
    static List<Language> languages = new ArrayList<Language>();
    static List<org.gurbani.SikhiDb.Entities.Locale> locales = new ArrayList<org.gurbani.SikhiDb.Entities.Locale>();
    static List<SourceIndex> sourceIndices = new ArrayList<SourceIndex>();
    static List<SourceIndexRange> sourceIndexRanges = new ArrayList<SourceIndexRange>();
    static List<org.gurbani.SikhiDb.Entities.TranslationSource> translationSources = new ArrayList<org.gurbani.SikhiDb.Entities.TranslationSource>();
    static List<Writer> writers = new ArrayList<Writer>();
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Import Initialized");
        fileReader = new AppFileReader();
        List<File> filePaths = new ArrayList<File>();
        listf(BaniPath, filePaths);
        filePaths.forEach(x -> {
			try {
				ProcessFileContent(x);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        
        DbSystemInfo sysInfo = new DbSystemInfo();
        sysInfo.setDatetime(new Date());
        sysInfo.setInformation("Data Initialized");
        new RepoDbSystemInfo(DbSystemInfo.class).
        	save(sysInfo);
        System.out.println("completed!!!");
    }
    public static void listf(String directoryName, List<File> files) {
        File directory = new File(directoryName);
        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if(fList != null) {
        	Arrays.stream(fList).filter(x -> x.isFile()).forEach(x -> files.add(x));
        	Arrays.stream(fList).filter(x -> x.isDirectory()).forEach(x -> listf(x.getAbsolutePath(), files));
        }
    }

    static void ProcessFileContent(File file) throws IOException {
		fileReader.getInstance(file);
    	String sourceDirectory = file.getParentFile().getName();
    	sourceDirectory = sourceDirectory.equals("data") ? "ROOT": sourceDirectory;
		String fullDirectory = file.getAbsolutePath();
		String fileName = file.getName();
		String fileContent = fileReader.getFileContent();
		
		FileSource fileSource = new FileSource(fileContent, fileName, sourceDirectory);
    	new RepoFileSource(FileSource.class).
			save(fileSource);
		switch (fileName) {
			case "banis.json":
				ProcessBanis((Bani[])fileReader.getFileObject(), fileSource);
				break;
			case "languages.json":
			case "writers.json":
				ProcessLanguages((Locale[])fileReader.getFileObject(), (fileName.equals("writers.json")), fileSource);
				break;
			case "sources.json":
				ProcessSources((Source[])fileReader.getFileObject(), fileSource);
				break;
			case "translation_sources.json":
				ProcessTranslationSources((TranslationSource[])fileReader.getFileObject(), fileSource);
				break;
			default:
				ProcessBaniDirectory((Text[])fileReader.getFileObject(), fileSource);
				break;
		}
    }
    static void ProcessTranslationSources(TranslationSource[] translationSources, FileSource fileSource) {
		for (TranslationSource translationSource : translationSources) {
	    	RepoSourceIndex repoSouceIndex = new RepoSourceIndex(SourceIndex.class);
			org.gurbani.SikhiDb.Entities.Locale dLocale =
    				new org.gurbani.SikhiDb.Entities.Locale(translationSource.getEnglishName(),
    						translationSource.getGurmukhiName(),
    						translationSource.getInternationalName());
			org.gurbani.SikhiDb.Entities.TranslationSource ts =
					new org.gurbani.SikhiDb.Entities.TranslationSource();
			ts.setLocale(dLocale);
			ts.setFileSource(fileSource);
			ts.setLanguage(translationSource.getLanguage());
			ts.setSourceIndex(repoSouceIndex.
					getFindByName(translationSource.getSource()));
			App.translationSources.add(ts);
		}
		new RepoTranslationSource(org.gurbani.SikhiDb.Entities.TranslationSource.class).
			saveAll(App.translationSources);
	}
	static void ProcessSources(Source[] sources, FileSource fileSource) {
		for (Source source : sources) {
			org.gurbani.SikhiDb.Entities.Locale dLocale =
    				new org.gurbani.SikhiDb.Entities.Locale(source.getEnglishName(),
    						source.getGurmukhiName(),
    						source.getInternationalName());
			SourceIndex sIndex = new SourceIndex();
			sIndex.setEnglishPageName(source.getEnglishPageName());
			sIndex.setGurmukhiPageName(source.getEnglishPageName());
			sIndex.setFileSource(fileSource);
			sIndex.setLength(source.getLength());
			sIndex.setLocale(dLocale);
			ProcessSourceRanges(sIndex, null, source.getSections(), fileSource);
			sourceIndices.add(sIndex);
		}
		new RepoSourceIndex(SourceIndex.class).
			saveAll(sourceIndices);
	}
	static void ProcessSourceRanges(SourceIndex sIndex, SourceIndexRange sIndexRange, List<Section> sections,
			FileSource fileSource) {
		if (sections == null)
            sections = new ArrayList<Section>();
		for (Section section : sections) {
			org.gurbani.SikhiDb.Entities.Locale dLocale =
    				new org.gurbani.SikhiDb.Entities.Locale(section.getEnglishName(),
    						section.getGurmukhiName(),
    						section.getInternationalName());
			
			SourceIndexRange dIndexRange = new SourceIndexRange();
			dIndexRange.setDescription(section.getDescription());
			dIndexRange.setEndPage(section.getEndPage());
			dIndexRange.setStartPage(section.getStartPage());
			dIndexRange.setFileSource(fileSource);
			dIndexRange.setLocale(dLocale);
			dIndexRange.setSourceIndexRange(sIndexRange);
			ProcessSourceRanges(sIndex, dIndexRange, section.getSubSections(), fileSource);
			sIndex.addSourceIndexRange(dIndexRange);
		}
	}
	static void ProcessLanguages(Locale[] jsonLocales, Boolean isWriter, FileSource fileSource) {
		for (Locale jsonLocale : jsonLocales) {
			org.gurbani.SikhiDb.Entities.Locale dLocale =
    				new org.gurbani.SikhiDb.Entities.Locale(jsonLocale.getEnglishName(),
    						jsonLocale.getGurmukhiName(),
    						jsonLocale.getInternationalName());
			if(isWriter) {
				Writer writer = new Writer();
				writer.setLocale(dLocale);
				writer.setFileSource(fileSource);
				writers.add(writer);
			} else {
				Language language = new Language();
				language.setLocale(dLocale);
				language.setFileSource(fileSource);
				languages.add(language);
			}
		}
		if(isWriter) {
			new RepoWriter(Writer.class).
				saveAll(writers);
		} else {
			new RepoLanguage(Language.class).
				saveAll(languages);
		}
	}
	static void ProcessBaniDirectory(Text[] texts, FileSource fileSource) {
		RepoSourceIndexRange indexRange =
				new RepoSourceIndexRange(SourceIndexRange.class);
		indexRange.beginTransaction();
		baniTexts = new ArrayList<BaniText>();
		RepoWriter writer = new RepoWriter(Writer.class);
    	for (Text text : texts) {
			BaniText baniText = new BaniText();
			baniText.setFileSource(fileSource);
			baniText.setGurbaniDbId(text.getGurbaniDbId());
			baniText.setSttmId(text.getSttmId());
			baniText.setSourceIndexRange1(indexRange.findByName(text.getSection(), false));
			baniText.setSourceIndexRange2(indexRange.findByName(text.getSubSection(), true));
			baniText.setWriter(writer.findByName(text.getWriter()));
			for (TextLine textLine : text.getLines()) {
				BaniTextLine baniTextLine = new BaniTextLine();
				baniTextLine.setFileSource(fileSource);
				baniTextLine.setGurbaniDbId(textLine.getGurbaniDbId());
				baniTextLine.setGurmukhi(textLine.getGurmukhi());
				String gurmukhi = textLine.getGurmukhi();
				if(gurmukhi != null) {
					String[] gurWords = gurmukhi.split("\\s+");
					gurmukhi = "";
					for (String gurWord : gurWords) {
						if(!gurWord.isEmpty()) {
							gurmukhi += gurWord.charAt(0);
						}
					}
				}
				baniTextLine.setInitial(gurmukhi);
				baniTextLine.setPronunciation(textLine.getPronunciation());
				baniTextLine.setPronunciationInformation(textLine.getPronunciationInformation());
				baniTextLine.setSourceLine(textLine.getSourceLine());
				baniTextLine.setSourcePage(textLine.getSourcePage());
				baniTextLine.setTranslation(textLine.getTranslation());
				baniText.addBaniTextLine(baniTextLine);
			}
			baniTexts.add(baniText);
		}
    	indexRange.commitTransaction();
    	new RepoBaniText(BaniText.class).
    		saveAll(baniTexts);
    }
    static void ProcessBanis(Bani[] banis, FileSource fileSource) { 	
    	for (Bani bani : banis) { 
    		BaniIndex baniIndex = new BaniIndex();
    		org.gurbani.SikhiDb.Entities.Locale dLocale =
    				new org.gurbani.SikhiDb.Entities.Locale(bani.getEnglishName(),
    						bani.getGurmukhiName(),
    						bani.getInternationalName());
    		baniIndex.setLocale(dLocale);
    		baniIndex.setFileSource(fileSource);
    		for (Range range : bani.getLines()) {
    			baniIndex.addBaniIndexRange(
    					new BaniIndexRange(range.getStartLine(),
    							range.getEndLine(), fileSource));
			}
    		baniIndices.add(baniIndex);
		}
    	new RepoBaniIndex(BaniIndex.class).
    		saveAll(baniIndices);    	
    }
}
