/**
 * 
 */
package com.microprofile.basic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Davi Maçana
 *
 */
@Singleton
public class FileDao {

	@Inject
	private Config config;

	public boolean save(File file) {

		File fileToSave = new File(config.PATH_UPLOAD + "/" + file.getName());
		try (InputStream input = new FileInputStream(file)) {
			Files.copy(input, fileToSave.toPath());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public File find(String fileName) {

		File file = new File(config.PATH_DOWNLOAD + "/" + fileName);
		if (file.exists() && file.isFile()) {
			return file;
		}
		return null;
	}
}
