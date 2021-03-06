package org.jboss.ide.eclipse.as.ui.bot.test.as3;

import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerReqType;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.ide.eclipse.as.ui.bot.test.template.OperateServerTemplate;
import org.jboss.reddeer.requirements.server.ServerReqState;

/**
 * @see OperateServerTemplate
 * @author Lucia Jelinkova
 *
 */
@JBossServer(state=ServerReqState.STOPPED, type=ServerReqType.AS3_2)
public class OperateAS3Server extends OperateServerTemplate {

	@Override
	public String getWelcomePageText() {
		return "JBoss Management";
	}
	
	@Override
	protected boolean ignoreExceptionInConsole(){
		return true;
	}
}
