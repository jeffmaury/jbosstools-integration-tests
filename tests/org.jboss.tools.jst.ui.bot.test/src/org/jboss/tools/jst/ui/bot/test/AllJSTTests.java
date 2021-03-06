/******************************************************************************* 
 * Copyright (c) 2015 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package org.jboss.tools.jst.ui.bot.test;

import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.tools.jst.ui.bot.test.bower.BowerInitTest;
import org.jboss.tools.jst.ui.bot.test.bower.BowerUpdateTest;
import org.jboss.tools.jst.ui.bot.test.npm.NpmInitTest;
import org.jboss.tools.jst.ui.bot.test.npm.NpmShortcutsTest;
import org.jboss.tools.jst.ui.bot.test.tern.TernCodeAssistTest;
import org.jboss.tools.jst.ui.bot.test.tern.TernModulesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(RedDeerSuite.class)
@Suite.SuiteClasses({
	// Bower Tests
	BowerInitTest.class,
	BowerUpdateTest.class,
	
	// Npm Tests
	NpmInitTest.class,
	NpmShortcutsTest.class,
	
	//Tern Tests
	TernCodeAssistTest.class,
	TernModulesTest.class
	
	// ...
	
})
public class AllJSTTests {

}
