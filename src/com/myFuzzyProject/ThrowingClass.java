package com.myFuzzyProject;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class ThrowingClass {
	public static void main(String[] args) throws Exception {
		String filename = "thrower.fcl";
		FIS fis = FIS.load(filename, true);

		if (fis == null) {
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

		// Set inputs
		fb.setVariable("angle", 45);
		fb.setVariable("distance", 21);

		// Evaluate
		fb.evaluate();
		JFuzzyChart.get().chart(fis.getFunctionBlock("thrower"));
		// Show output variable's chart
		fb.getVariable("veloZero").defuzzify();
		// Print ruleSet
		System.out.println(fb);
		System.out.println("veloZero: " + fb.getVariable("veloZero").getValue());

	}

}
