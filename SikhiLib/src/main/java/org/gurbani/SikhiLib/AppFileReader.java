package org.gurbani.SikhiLib;

import java.io.File;
import java.io.IOException;

import org.gurbani.SikhiLib.Models.Bani;
import org.gurbani.SikhiLib.Models.Locale;
import org.gurbani.SikhiLib.Models.Source;
import org.gurbani.SikhiLib.Models.Text;
import org.gurbani.SikhiLib.Models.TranslationSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 * @param <T>
 *
 */
public class AppFileReader
{
	ObjectMapper mapper;
    public AppFileReader() {
    	mapper = new ObjectMapper();
    } 
    private String fileContent;
    private Object[] fileObject;
    public void getInstance(File file) {
    	try {
			fileContent = mapper.readTree(file).toString();
	    	switch (file.getName()) {
				case "banis.json":
					fileObject = mapper.readValue(file, Bani[].class);
					break;
				case "languages.json":
				case "writers.json":
					fileObject = mapper.readValue(file, Locale[].class);
					break;
				case "sources.json":
					fileObject = mapper.readValue(file, Source[].class);
					break;
				case "translation_sources.json":
					fileObject = mapper.readValue(file, TranslationSource[].class);
					break;
				default:
					fileObject = mapper.readValue(file, Text[].class);
					break;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	public String getFileContent() {
		return fileContent;
	}
	public Object[] getFileObject() {
		return fileObject;
	}
    
}
