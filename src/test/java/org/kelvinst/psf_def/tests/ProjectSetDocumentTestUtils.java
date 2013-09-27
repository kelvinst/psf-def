package org.kelvinst.psf_def.tests;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.kelvinst.psf_def.ProviderType;
import org.kelvinst.psf_def.utils.ProjectSetDocumentUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProjectSetDocumentTestUtils {

	public static Document newDocument() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException("Error creating new test document: ", e);
		}
	}

	public static Element newProjectElement(Document document) {
		return document.createElement(ProjectSetDocumentUtils.PROJECT_TAG_NAME);
	}

	public static Element newProjectElement(Document document, ProviderType providerType) {
		return newProjectElement(document, 
				providerType.getScmInfoBuilder().getReference("1.0", "repository", "path/project-name", "project-name", "branch"));
	}

	public static Element newProjectElement(Document document, String reference) {
		Element projectTag = newProjectElement(document);
		
		projectTag.setAttribute(ProjectSetDocumentUtils.PROJECT_SCM_INFO_ATTR_NAME, reference);
		
		return projectTag;
	}
	
}
