package mapStates;

import world.worldLoader;

public class TeotihuaState extends Map {

	public TeotihuaState() {
		super();
		mapStr= worldLoader.loadFileAsString("Map/TeotihuaState.txt");
		init();
	}

}
