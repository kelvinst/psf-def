package org.kelvinst.psf_def.tests;

import org.kelvinst.psf_def.IProject;
import org.kelvinst.psf_def.ProviderType;
import org.kelvinst.psf_def.builders.ProjectSetBuilder;
import org.w3c.dom.Document;

public class ProjectSetBuilderTestUtils {

	public static IProject buildNewProject(Document document, ProviderType type) {
		return ProjectSetBuilder.buildProject(type, ProjectSetDocumentTestUtils.newProjectElement(document, type));
	}

	public static IProject buildNewProject(Document document, ProviderType type, String reference) {
		return ProjectSetBuilder.buildProject(type, ProjectSetDocumentTestUtils.newProjectElement(document, reference));
	}

}
