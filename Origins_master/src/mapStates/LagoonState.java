package mapStates;

import world.worldLoader;

public class LagoonState extends Map{

	public LagoonState() {
		super();
		mapStr= worldLoader.loadFileAsString("Map/LagoonState.txt");
		init();
	}

}
