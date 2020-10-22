package mapStates;

import world.worldLoader;

public class ForestState extends Map {

	public ForestState() {
		// TODO Auto-generated constructor stub
		super();
		mapStr= worldLoader.loadFileAsString("Map/ForestState.txt");
		init();
	}

}
