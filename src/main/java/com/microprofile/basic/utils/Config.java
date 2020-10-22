/**
 * 
 */
package com.microprofile.basic.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.microprofile.qualifier.PropertyQualifier;

/**
 * @author Davi Maçana
 *
 */
@Singleton
public class Config {

	@Inject
    @PropertyQualifier(key="message.welcome")
    public String WELCOME;
 
    @Inject
    @PropertyQualifier(key="message.welcome", container = false, fileName = "config.properties")
    public String WELCOME_EXTERNAL_FILE;
 
    @Inject
    @PropertyQualifier(key="path.download")
    public String PATH_DOWNLOAD;
 
    @Inject
    @PropertyQualifier(key="path.upload")
    public String PATH_UPLOAD;
}
