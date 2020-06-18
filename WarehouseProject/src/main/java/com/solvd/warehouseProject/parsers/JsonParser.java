package com.solvd.warehouseProject.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonParser {
	private final static Logger LOGGER = LogManager.getLogger(JsonParser.class);
	
	public static <T> void objectListToJson(List<T> objects, String outputFilePath) {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		try {
			objectMapper.writeValue(new File(outputFilePath), objects);
		} catch (JsonMappingException e) {
			LOGGER.error(e);
		} catch (JsonGenerationException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
}
