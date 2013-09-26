package org.kelvinst.psf_def;

import java.util.List;

public interface IProvider {

	List<IProject> getProjects();
	
	ProviderType getType();
	
}
