package com.fdesousa.android.WheresMyTrain.requests.DetailedPredictions;

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

import java.util.ArrayList;
import java.util.List;

/**
 * <b>DPPlatform</b>
 * <p>Instance of Platform in Detailed Predictions requests.<br/>
 * Stores an instance of Platform from Detailed Predictions request JSON syntax.</p>
 * @author Filipe De Sousa
 * @version 0.7
 */
public class DPPlatform {
	public String platformname;
	public String platformnumber;
	public List<DPTrain> trains = new ArrayList<DPTrain>();
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		
		out.append("\n\t\tplatformname:");
		out.append(platformname);
		out.append("\n\t\tplatformnumber:");
		out.append(platformnumber);
		out.append("\n\t\ttrains:{");
		
		for (DPTrain train : trains) {
			out.append(train.toString());
		}
		
		out.append("\n\t\t}");
		
		return out.toString();
	}
}
