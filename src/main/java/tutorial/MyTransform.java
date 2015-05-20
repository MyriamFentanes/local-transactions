package tutorial;

import java.util.logging.Logger;

public class MyTransform {
	private static final transient Logger LOGGER = Logger
			.getLogger(MyTransform.class.getName());
	private boolean verbose = true;
	private String prefix = "MyTransform";

	public String transform(String body) throws java.lang.Exception {
		// should be printed n times due to redeliveries
		LOGGER.info("message body = " + body);
		// force rollback
//		LOGGER.info("Not forcing exception" + body);
//		return "Nuevo test";
		
		throw new java.lang.Exception("test");
	}
	
	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
