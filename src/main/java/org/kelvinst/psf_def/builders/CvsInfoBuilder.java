package org.kelvinst.psf_def.builders;

import org.apache.commons.lang.StringUtils;
import org.kelvinst.psf_def.IScmInfo;
import org.kelvinst.psf_def.ScmInfo;

public class CvsInfoBuilder implements IScmInfoBuilder {

	@Override
	public IScmInfo build(String reference) {
		String[] split = reference.split(",");
		
		String path = split[2];
		
		String name = split[3];
		if (name == null) {
			name = StringUtils.substringAfterLast(path, "/"); 
		}		
		
		String branch = split[4];
		if (branch == null) {
			branch = StringUtils.EMPTY;
		}
		
		return new ScmInfo(name, split[1], branch, path);
	}

}
