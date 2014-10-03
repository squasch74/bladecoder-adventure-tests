package org.bladecoder.venus.actions.scene2;

import java.util.HashMap;

import com.bladecoder.engine.BladeEngine;
import com.bladecoder.engine.actions.Action;
import com.bladecoder.engine.actions.ActionCallback;
import com.bladecoder.engine.actions.Param;
import com.bladecoder.engine.model.World;
import com.bladecoder.engine.ui.UI;

public class LeaveAction implements Action {
	public static final String INFO = "Restarts the game";
	public static final Param[] PARAMS = {};

	@Override
	public void setParams(HashMap<String, String> params) {
	}

	@Override
	public boolean run(ActionCallback cb) {
		World.getInstance().newGame();

		UI ui = BladeEngine.getAppUI();

		World.getInstance().pause();

		ui.setCurrentScreen(UI.Screens.CREDIT_SCREEN);
		
		return false;
	}

	@Override
	public String getInfo() {
		return INFO;
	}

	@Override
	public Param[] getParams() {
		return PARAMS;
	}
}
