package com.solvd.warehouseProject.parsers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JaxbParser {
private final static Logger LOGGER = LogManager.getLogger(JaxbParser.class);
	
	public static <T> T jaxbXmlToObject(Class<T> genericClass, String inputFilePath) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(genericClass);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			T object = genericClass.cast(unmarshaller.unmarshal(new File(inputFilePath)));
			return object;
		} catch (JAXBException e){
			LOGGER.error(e);
		}
		return null;
	}
	
	public static <T> void jaxbObjectToXml(Class<T> genericClass, T t, String outputFilePath) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(genericClass);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //output format with linefeeds and indentation
			marshaller.marshal(t, new File(outputFilePath));
		} catch (JAXBException e) {
			LOGGER.error(e);
		}
	}
}

