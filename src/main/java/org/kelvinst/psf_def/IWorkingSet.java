package org.kelvinst.psf_def;

import java.util.List;

public interface IWorkingSet {

	WorkingSetType getType();
	
	List<IWorkingSetItem> getItems();
	
}
