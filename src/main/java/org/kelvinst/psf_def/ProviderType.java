package org.kelvinst.psf_def;

import org.kelvinst.psf_def.builders.CvsInfoBuilder;
import org.kelvinst.psf_def.builders.GitInfoBuilder;
import org.kelvinst.psf_def.builders.IScmInfoBuilder;
import org.kelvinst.psf_def.builders.SvnInfoBuilder;

public enum ProviderType {

	CVS("org.eclipse.team.cvs.core.cvsnature", new CvsInfoBuilder()),
	SVN("org.tigris.subversion.subclipse.core.svnnature", new SvnInfoBuilder()),
	GIT("org.eclipse.egit.core.GitProvider", new GitInfoBuilder());

	private String id;
	private IScmInfoBuilder scmInfoBuilder; 

	private ProviderType(String id, IScmInfoBuilder scmInfoBuilder) {
		this.id = id;
		this.scmInfoBuilder = scmInfoBuilder;
	}
	
	public String getId() {
		return id;
	}

	// TODO Search for another way to do this
	public IScmInfoBuilder getScmInfoBuilder() {
		return scmInfoBuilder;
	}

	public static ProviderType fromId(String attribute) {
		for (ProviderType value : values()) {
			if (value.id.equals(attribute)) {
				return value;
			}
		}
		return null;
	}

}
