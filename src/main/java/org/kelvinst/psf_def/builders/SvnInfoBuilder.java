package org.kelvinst.psf_def.builders;

import org.apache.commons.lang.StringUtils;
import org.kelvinst.psf_def.IScmInfo;
import org.kelvinst.psf_def.ScmInfo;

public class SvnInfoBuilder implements IScmInfoBuilder {

	@Override
	public IScmInfo build(String reference) {
		String[] split = reference.split(",");

		String path = split[1];
		
		String name = split[2];
		if (name == null) {
			name = StringUtils.substringAfterLast(path, "/");
		}
		
		return new ScmInfo(name, StringUtils.EMPTY, StringUtils.EMPTY, path);
	}

}
