package org.kelvinst.psf_def.builders;

import org.kelvinst.psf_def.IScmInfo;

public interface IScmInfoBuilder {

	IScmInfo build(String reference);
	
	// TODO Give a little power-up to these reference builders
	String getReferenceFormat();
	
	String getReference(String version, String repository, String path, String projectName, String branch);	

}
