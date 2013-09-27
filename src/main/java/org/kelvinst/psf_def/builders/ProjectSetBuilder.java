package org.kelvinst.psf_def.builders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.kelvinst.psf_def.IProject;
import org.kelvinst.psf_def.IProjectSet;
import org.kelvinst.psf_def.IProvider;
import org.kelvinst.psf_def.IScmInfo;
import org.kelvinst.psf_def.IWorkingSet;
import org.kelvinst.psf_def.Project;
import org.kelvinst.psf_def.ProjectSet;
import org.kelvinst.psf_def.Provider;
import org.kelvinst.psf_def.ProviderType;
import org.kelvinst.psf_def.utils.ProjectSetDocumentUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class ProjectSetBuilder {

	public static IProjectSet build(File file) {
		return build(ProjectSetDocumentUtils.newDocument(file));
	}

	public static IProjectSet build(Document document) {
		return build(document.getDocumentElement());
	}

	public static IProjectSet build(Element psf) {
		List<IProvider> providers = buildProviders(psf.getElementsByTagName(ProjectSetDocumentUtils.PROVIDER_TAG_NAME));
		
		List<IWorkingSet> workingSets = buildWorkingSets(psf);
		
		return new ProjectSet(providers, workingSets);
	}

	public static List<IProvider> buildProviders(NodeList providerNodes) {
		List<IProvider> result = new ArrayList<IProvider>(); 
		
		for (int i = 0; i < providerNodes.getLength(); i++) {
			result.add(buildProvider((Element) providerNodes.item(i)));
		}
		
		return result;
	}

	public static Provider buildProvider(Element providerTag) {
		ProviderType type = ProviderType.fromId(providerTag.getAttribute(ProjectSetDocumentUtils.PROVIDER_TYPE_ATTR_NAME));
		
		List<IProject> projects = buildProjects(type, providerTag.getElementsByTagName(ProjectSetDocumentUtils.PROJECT_TAG_NAME));
		
		return new Provider(projects, type);
	}

	public static List<IProject> buildProjects(ProviderType providerType, NodeList projectNodes) {
		List<IProject> result = new ArrayList<IProject>(); 
		
		for (int i = 0; i < projectNodes.getLength(); i++) {
		    result.add(buildProject(providerType, (Element) projectNodes.item(i)));	    
		}
		
		return result;
	}
	
	public static IProject buildProject(ProviderType providerType, Element projectTag) {
		IScmInfo scmInfo = providerType.getScmInfoBuilder().build(projectTag.getAttribute(ProjectSetDocumentUtils.PROJECT_SCM_INFO_ATTR_NAME));
		return new Project(scmInfo.getName(), scmInfo);
	}
	
	public static List<IWorkingSet> buildWorkingSets(Element psf) {
		return null;
	}
	
}
