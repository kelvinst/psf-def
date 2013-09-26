package org.kelvinst.psf_def;

import java.util.List;

public interface IProjectSet {

	List<IProvider> getProviders();
	
	List<IWorkingSet> getWorkingSets();
	
}
