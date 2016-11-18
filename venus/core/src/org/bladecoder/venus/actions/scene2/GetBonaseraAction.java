package org.bladecoder.venus.actions.scene2;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.bladecoder.engine.actions.Action;
import com.bladecoder.engine.actions.ActionDescription;
import com.bladecoder.engine.model.VerbRunner;
import com.bladecoder.engine.util.Config;

@ActionDescription("Open the Bonasera Store Page")
public class GetBonaseraAction implements Action {

	@Override
	public boolean run(VerbRunner cb) {
		String fullgameURL = null;

		if (Gdx.app.getType() == ApplicationType.Desktop) {
			fullgameURL = Config.getProperty("fullgame_desktop_url", null);
		} else if (Gdx.app.getType() == ApplicationType.Android) {
			fullgameURL = Config.getProperty("fullgame_android_url", null);
		} else if (Gdx.app.getType() == ApplicationType.iOS) {
			fullgameURL = Config.getProperty("fullgame_ios_url", null);
		}
		
		if(fullgameURL != null)
			Gdx.net.openURI(fullgameURL);
		
		return false;
	}
}
