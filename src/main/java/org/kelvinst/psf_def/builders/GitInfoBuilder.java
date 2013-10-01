package org.kelvinst.psf_def.builders;

import org.apache.commons.lang3.StringUtils;
import org.kelvinst.psf_def.IScmInfo;
import org.kelvinst.psf_def.ScmInfo;

public class GitInfoBuilder extends ScmInfoBuilder {

	@Override
	public IScmInfo build(String reference) {
		String[] split = reference.split(",");

		String repository = split[1];
		String path = split[3];
		
		String name = "";
		if (path.contains("/")) {
			name = StringUtils.substringAfterLast(path, "/"); 
		} else if (path.equals(".")) {
			name = StringUtils.substringAfterLast(repository, "/");
		} else {
			name = path;
		}
		
		return new ScmInfo(name, repository, split[2], path);
	}

	@Override
	public String getReferenceFormat() {
		return "{version},{repository},{branch},{path}";
	}

}
