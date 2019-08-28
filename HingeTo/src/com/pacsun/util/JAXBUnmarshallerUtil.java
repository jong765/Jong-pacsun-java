package com.pacsun.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBUnmarshallerUtil {

	public Object getJAXBObject(Class<?> className, String fullXmlFileName)
			throws JAXBException {

		InputStream inputStream = null;
		Object object = null;

		try {

			inputStream = new FileInputStream(fullXmlFileName);
			object = getUnmarshaller(className).unmarshal(inputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return object;
	}

	private Unmarshaller getUnmarshaller(Class<?> className)
			throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(className);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		return jaxbUnmarshaller;
	}

}
