package com.fdesousa.android.WheresMyTrain.requests.LineStatus;

/******************************************************************************
 * Copyright 2011 Filipe De Sousa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *****************************************************************************/

import java.net.URI;

import com.fdesousa.android.WheresMyTrain.json.TflJsonHandler;
import com.google.gson.Gson;

/**
 * <b>LSHandler : TflJsonHandler</b>
 * <p>Handler of Line Status requests.<br/>
 * Used to parse JSON with GSON in a manner specific to Line Status.</p>
 * @author Filipe De Sousa
 * @version 0.7
 */
public class LSHandler extends TflJsonHandler {
	private LSContainer linesstatus;

	/**
	 * Constructor. Sets the URI of the request
	 * @param uri - the URI of the data to fetch
	 */
	public LSHandler(URI uri) {
		super(uri);
	}

	/**
	 * Simple getter, return the container the JSON was parsed into
	 * @return New SPContainer instance with the fetched data
	 */
	public Object getContainer() {
		return linesstatus;
	}

	@Override
	protected void parseJson() {
		linesstatus = new Gson().fromJson(json, LSContainer.class);
	}
}
