package org.kelvinst.psf_def.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ProjectSetDocumentUtils {

	public static final String PROJECT_SCM_INFO_ATTR_NAME = "reference";
	public static final String PROJECT_TAG_NAME = "project";
	public static final String PROVIDER_TYPE_ATTR_NAME = "id";
	public static final String PROVIDER_TAG_NAME = "provider";

	public static Document newDocument(File file) {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
		} catch (Exception e) {
			throw new IllegalStateException("Error parsing project set file: ".concat(file.getAbsolutePath()), e);
		}
	}

}
