package es.ugr.osgiliath.problem;

import java.util.Properties;

public interface ProblemParameters {
	
	public static final String NAME = "problem.name";
	public static final String OPTIMUM = "problem.optimum";
	public void setup(Properties props);
	public Object getParameter(String key);
	//public boolean toMaximize();
}
