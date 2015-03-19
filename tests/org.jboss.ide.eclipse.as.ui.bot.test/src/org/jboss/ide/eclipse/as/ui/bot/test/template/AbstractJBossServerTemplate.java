package org.jboss.ide.eclipse.as.ui.bot.test.template;

import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement;
import org.jboss.ide.eclipse.as.reddeer.server.view.JBossServer;
import org.jboss.ide.eclipse.as.reddeer.server.view.JBossServerView;
import org.jboss.ide.eclipse.as.ui.bot.test.matcher.ConsoleContainsTextMatcher;
import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.eclipse.condition.ConsoleHasNoChange;
import org.jboss.reddeer.eclipse.ui.console.ConsoleView;
import org.jboss.reddeer.junit.requirement.inject.InjectRequirement;
import org.jboss.reddeer.swt.wait.TimePeriod;
import org.jboss.reddeer.swt.wait.WaitUntil;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Common ancestor for server tests that provides some common functionality shared
 * between tests (e.g check console for error, inject requirement, etc.)
 * 
 * @author Lucia Jelinkova
 *
 */
public abstract class AbstractJBossServerTemplate {
	
	private static final Logger log = Logger.getLogger(AbstractJBossServerTemplate.class);

	@InjectRequirement
	protected ServerRequirement requirement;

	protected JBossServerView view;
	
	@Before
	public void openServersView(){
		view = new JBossServerView();
		view.open();		
	}
	
	protected String getServerName() {
		return requirement.getServerNameLabelText(requirement.getConfig());
	} 
	
	protected JBossServer getServer() {
		return view.getServer(getServerName());
	}
	
	protected void clearConsole(){
		ConsoleView consoleView = new ConsoleView();
		consoleView.open();
		consoleView.clearConsole();		
	}
	
	protected boolean ignoreExceptionInConsole(){
		return false;
	}
	
	protected void assertNoException(String message) {
		if (ignoreExceptionInConsole()){
			log.step("Ignore any exception in console");
			return;
		}
		
		log.step("Check exception in console");
		ConsoleView consoleView = new ConsoleView();
		consoleView.open();
		consoleView.toggleShowConsoleOnStandardOutChange(false);
		
		new WaitUntil(new ConsoleHasNoChange(), TimePeriod.LONG);
		assertThat(message, consoleView, not(new ConsoleContainsTextMatcher("Exception")));

		consoleView.close();
	}
}
