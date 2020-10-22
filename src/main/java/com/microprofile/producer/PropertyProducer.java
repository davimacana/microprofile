/**
 * 
 */
package com.microprofile.producer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.xml.bind.PropertyException;

import com.microprofile.qualifier.PropertyQualifier;

/**
 * @author Davi Maçana
 *
 */
public class PropertyProducer {

	@PropertyQualifier
	@Produces
	public String readProperty(InjectionPoint point) throws PropertyException {
		String key = point.getAnnotated().getAnnotation(PropertyQualifier.class).key();
		if (point.getAnnotated().getAnnotation(PropertyQualifier.class).container()) {
			String value = System.getProperty(key);
			if (Objects.nonNull(value)) {
				return value;
			}
		}
		// point.getAnnotated().getAnnotation(Property.class).fileName()
		return readFromPath(key);
	}

	private String readFromPath(String key) throws PropertyException {
		Properties properties = new Properties();
		try (InputStream in = new FileInputStream(readPathConfigurationStore(properties))) {
			properties.load(in);
			return properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PropertyException("Error to read property.");
		}
	}

	private String readPathConfigurationStore(Properties configStore) throws PropertyException {
		try (InputStream stream = PropertyProducer.class.getResourceAsStream("/configurationStore.properties")) {
			configStore.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PropertyException("Error to read property.");
		}
		return configStore.getProperty("path");
	}
}
