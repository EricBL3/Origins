package mapStates;

import world.worldLoader;

public class TenochState extends Map {

	public TenochState() {
		super();
		mapStr= worldLoader.loadFileAsString("Map/TenochState.txt");
		init();
	}


}
