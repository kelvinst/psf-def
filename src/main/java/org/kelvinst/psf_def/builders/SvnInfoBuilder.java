package org.kelvinst.psf_def.builders;

import org.apache.commons.lang.StringUtils;
import org.kelvinst.psf_def.IScmInfo;
import org.kelvinst.psf_def.ScmInfo;

public class SvnInfoBuilder extends ScmInfoBuilder {

	@Override
	public IScmInfo build(String reference) {
		String[] split = reference.split(",");

		return new ScmInfo(split[2], StringUtils.EMPTY, StringUtils.EMPTY, split[1]);
	}

	@Override
	public String getReferenceFormat() {
		return "{version},{path},{project-name}";
	}

}
