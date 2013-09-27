package org.kelvinst.psf_def;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.kelvinst.psf_def.tests.ProjectSetBuilderTestUtils;
import org.kelvinst.psf_def.tests.ProjectSetDocumentTestUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProjectSetBuilderTest {

	public static IProject buildProject(ProviderType providerType, Element projectTag) {
		IScmInfo scmInfo = providerType.getScmInfoBuilder().build(projectTag.getAttribute("reference"));
		return new Project(scmInfo.getName(), scmInfo);
	}

	public Document document;
	
	@Before
	public void before() {
		document = ProjectSetDocumentTestUtils.newDocument();
	}

	@Test
	public void testBuildProjectGit() {
		IProject project = ProjectSetBuilderTestUtils.buildNewProject(document, ProviderType.GIT);

		Assert.assertEquals("repository", project.getScmInfo().getRepository());
		Assert.assertEquals("branch", project.getScmInfo().getBranch());
		Assert.assertEquals("path/project-name", project.getScmInfo().getPath());
		Assert.assertEquals("project-name", project.getScmInfo().getName());
	}

	@Test
	public void testBuildProjectSvn() {
		IProject project = ProjectSetBuilderTestUtils.buildNewProject(document, ProviderType.SVN);

		Assert.assertEquals("", project.getScmInfo().getRepository());
		Assert.assertEquals("", project.getScmInfo().getBranch());
		Assert.assertEquals("path/project-name", project.getScmInfo().getPath());
		Assert.assertEquals("project-name", project.getScmInfo().getName());
	}
	
	@Test
	public void testBuildProjectCvs() {
		IProject project = ProjectSetBuilderTestUtils.buildNewProject(document, ProviderType.CVS);

		Assert.assertEquals("repository", project.getScmInfo().getRepository());
		Assert.assertEquals("branch", project.getScmInfo().getBranch());
		Assert.assertEquals("path/project-name", project.getScmInfo().getPath());
		Assert.assertEquals("project-name", project.getScmInfo().getName());
	}
	
}
