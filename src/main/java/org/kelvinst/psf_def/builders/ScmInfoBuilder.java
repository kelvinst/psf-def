package org.kelvinst.psf_def.builders;

public abstract class ScmInfoBuilder implements IScmInfoBuilder {

	public String getReference(String version, String repository, String path, String projectName, String branch) {
		String result = getReferenceFormat().replace("{version}", version);
		result = result.replace("{repository}", repository);
		result = result.replace("{path}", path);
		result = result.replace("{project-name}", projectName);
		result = result.replace("{branch}", branch);
		
		return result;
	}

}
