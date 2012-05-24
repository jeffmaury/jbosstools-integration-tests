/*******************************************************************************
 * Copyright (c) 2010-2012 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.archives.ui.bot.test;

import org.jboss.tools.archives.ui.bot.test.explorer.ProjectArchivesExplorer;
import org.jboss.tools.archives.ui.bot.test.view.ProjectArchivesView;
import org.jboss.tools.ui.bot.ext.RequirementAwareSuite;
import org.jboss.tools.ui.bot.ext.SWTTestExt;
import org.jboss.tools.ui.bot.ext.config.Annotations.Require;
import org.jboss.tools.ui.bot.ext.helper.ImportHelper;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author jjankovi
 *
 */
@Require(clearProjects = true, perspective = "Java")
@RunWith(RequirementAwareSuite.class)
@SuiteClasses({ ArchivesAllBotTests.class })
public class ArchivesTestBase extends SWTTestExt {

	protected ProjectArchivesView openProjectArchivesView() {
		ProjectArchivesView view = new ProjectArchivesView();
		view.show();
		return view;
	}
	
	protected ProjectArchivesView viewForProject(String projectName) {
		ProjectArchivesView view = openProjectArchivesView();
		projectExplorer.selectProject(projectName);
		return view;
	}
	
	protected ProjectArchivesExplorer explorerForProject(String projectName) {
		return new ProjectArchivesExplorer(projectName);
	}
	
	protected void assertItemExistsInView(ProjectArchivesView view, String... path) {
		assertTrue(view.itemExists(path));
	}
	
	protected void assertItemExistsInExplorer(ProjectArchivesExplorer explorer, String... path) {
		assertTrue(explorer.itemExists(path));
	}
	
	protected void assertItemNotExistsInView(ProjectArchivesView view, String... path) {
		assertFalse(view.itemExists(path));
	}
	
	protected void assertItemNotExistsInExplorer(ProjectArchivesExplorer explorer, String... path) {
		assertFalse(explorer.itemExists(path));
	}
	
	protected static void importProject(String projectName) {
		
		String location = "/resources/prj/" + projectName;
		importProject(projectName, location, projectName);
	}
	
	protected static void importProject(String projectName, 
			String projectLocation, String dir) {
		
		ImportHelper.importProject(projectLocation, dir, Activator.PLUGIN_ID);
		eclipse.addConfiguredRuntimeIntoProject(projectName, 
				configuredState.getServer().name);
	}
	
	protected static void importProjectWithoutRuntime(String projectName) {
		
		String location = "/resources/prj/" + projectName;
		importProjectWithoutRuntime(projectName, location, projectName);
	}
	
	protected static void importProjectWithoutRuntime(String projectName, 
			String projectLocation, String dir) {
		ImportHelper.importProject(projectLocation, dir, Activator.PLUGIN_ID);
	}
	
}
