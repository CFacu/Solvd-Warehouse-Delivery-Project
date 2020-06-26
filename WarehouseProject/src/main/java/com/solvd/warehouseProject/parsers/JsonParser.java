package com.solvd.warehouseProject.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.warehouseProject.models.Deposit;
import com.solvd.warehouseProject.models.Warehouse;


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
	
	public static <T> void objectToJson(T object, String outputFilePath) {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		try {
			objectMapper.writeValue(new File(outputFilePath), object);
		} catch (JsonMappingException e) {
			LOGGER.error(e);
		} catch (JsonGenerationException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
	
    public static void jsonOutput(List<Deposit> deposits, String outputFilePath) throws IOException {
    	File output = new File(outputFilePath);
    	ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    	JsonGenerator g = objectMapper.getFactory().createGenerator(output, JsonEncoding.UTF8);
    	g.setPrettyPrinter(new MinimalPrettyPrinter("\n \n "));
    	Warehouse tmpWarehouse = new Warehouse();
    	for (Deposit dep: deposits) {
    		Warehouse warehouse = dep.getWarehouse();
    		if (tmpWarehouse.equals(warehouse)){
    			try {
					objectMapper.writeValue(g, dep.getOrderDetail());
					objectMapper.writeValue(g, dep.getVolumeDeposited());
					//objectMapper.writeValue(g, "volume deposited: "+dep.getVolumeDeposited()); Esto por si se quiere anteponer lo de "volume" y no aparezca solo el numero
				} catch (IOException e) {
					LOGGER.error(e);
				}
    		} else {
    			try {
    				objectMapper.writeValue(g, dep.getWarehouse());
    				objectMapper.writeValue(g, dep.getOrderDetail());
					objectMapper.writeValue(g, dep.getVolumeDeposited());
					//objectMapper.writeValue(g, "volume deposited: "+dep.getVolumeDeposited());
				} catch (IOException e) {
					LOGGER.error(e);
				}
    			tmpWarehouse = dep.getWarehouse();
    		}
    		
    	}
    }
}
