package com.bladecoder.advtest;

import com.bladecoder.engine.BladeEngine;

import android.os.Bundle; 
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFiles;
import com.badlogic.gdx.Gdx;

public class AndroidLauncher extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = false;
        cfg.useCompass = false;
        //cfg.numSamples = 2;
        cfg.useImmersiveMode = true;
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        
        initialize(new AndroidEngine(), cfg);
    }

    class AndroidEngine extends BladeEngine {
	    @Override
	    public void create() {
            if(BuildConfig.EXPANSION_FILE_VERSION > 0)
    	    	((AndroidFiles)Gdx.files).setAPKExpansion(BuildConfig.EXPANSION_FILE_VERSION, 0);
		
		    super.create();
	    }
    }
}