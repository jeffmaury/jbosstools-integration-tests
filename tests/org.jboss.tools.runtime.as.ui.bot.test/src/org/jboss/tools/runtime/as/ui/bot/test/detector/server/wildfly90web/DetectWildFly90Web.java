package org.jboss.tools.runtime.as.ui.bot.test.detector.server.wildfly90web;

import java.util.Arrays;
import java.util.List;

import org.jboss.reddeer.requirements.jre.JRERequirement.JRE;
import org.jboss.tools.runtime.as.ui.bot.test.RuntimeProperties;
import org.jboss.tools.runtime.as.ui.bot.test.entity.Runtime;
import org.jboss.tools.runtime.as.ui.bot.test.template.DetectRuntimeTemplate;

public class DetectWildFly90Web extends DetectRuntimeTemplate {

	public static final String SERVER_ID = "wildfly-web-9.0";
	
	public static final String SERVER_NAME = "WildFly-Web 9.0";
	
	@Override
	protected String getPathID() {
		return SERVER_ID;
	}
	
	@Override
	protected List<Runtime> getExpectedRuntimes() {
		Runtime expectedServer = new Runtime();
		expectedServer.setName(SERVER_NAME);
		expectedServer.setVersion("9.0");
		expectedServer.setType("WildFly-Web");
		expectedServer.setLocation(RuntimeProperties.getInstance().getRuntimePath(SERVER_ID));
		return Arrays.asList(expectedServer);
	}
}
