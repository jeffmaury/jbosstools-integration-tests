/*******************************************************************************
 * Copyright (c) 2007-2016 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v 1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.openshift.ui.bot.test.application.create;

import org.jboss.tools.openshift.reddeer.utils.DatastoreOS2;
import org.jboss.tools.openshift.reddeer.utils.v2.DeleteUtils;
import org.jboss.tools.openshift.reddeer.wizard.v2.ApplicationCreator;
import org.junit.After;
import org.junit.Test;

/**
 * Test capabilities of creating an application on downloadable cartridge.
 * 
 * @author mlabuda@redhat.com
 *
 */
public class ID406CreateApplicationOnDownloadableCartridgeTest {

	public static String downloadableURL = 
			"https://cartreflect-claytondev.rhcloud.com/github/smarterclayton/openshift-go-cart";
	private String applicationName = "gocart" + System.currentTimeMillis();
	
	@Test
	public void testCreateApplicatinOnDownloadableCartridge() {
		new ApplicationCreator(DatastoreOS2.USERNAME, DatastoreOS2.SERVER, DatastoreOS2.DOMAIN, false).
			createApplicationOnDownloadableCartridge(downloadableURL, applicationName, 
					false, false, true, null, (String[]) null);
	}
	
	@After
	public void deleteApplication() {
		new DeleteUtils(DatastoreOS2.USERNAME, DatastoreOS2.SERVER, DatastoreOS2.DOMAIN, applicationName,
				applicationName).perform();
	}
	
}
