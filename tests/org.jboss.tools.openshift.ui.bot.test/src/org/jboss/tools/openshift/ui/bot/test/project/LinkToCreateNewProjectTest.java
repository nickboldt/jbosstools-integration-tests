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
package org.jboss.tools.openshift.ui.bot.test.project;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jboss.reddeer.common.exception.RedDeerException;
import org.jboss.reddeer.common.wait.TimePeriod;
import org.jboss.reddeer.common.wait.WaitUntil;
import org.jboss.reddeer.common.wait.WaitWhile;
import org.jboss.reddeer.core.condition.ShellWithTextIsAvailable;
import org.jboss.reddeer.core.handler.TreeItemHandler;
import org.jboss.reddeer.swt.api.TreeItem;
import org.jboss.reddeer.swt.condition.WidgetIsEnabled;
import org.jboss.reddeer.swt.impl.button.FinishButton;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.tools.openshift.reddeer.utils.OpenShiftLabel;
import org.jboss.tools.openshift.reddeer.view.OpenShiftExplorerView;
import org.junit.After;
import org.junit.Test;

public class LinkToCreateNewProjectTest {
	
	private String projectName = "testproject";
	private boolean projectCreated = false;
	
	@Test
	public void createOpenShiftProjectViaLinkInExplorer() {
		OpenShiftExplorerView explorer = new OpenShiftExplorerView();
		TreeItem connectionItem = explorer.getOpenShift3Connection().getTreeItem();
		
		TreeItem newProjectLinkItem = null;
		try {
			newProjectLinkItem = connectionItem.getItem("No projects are available."
					+ " Click here to create a new project...");
		} catch (RedDeerException ex) {
			fail("There is no link to create a new project even connection does not have any project.");
		}
		
		TreeItemHandler.getInstance().click(newProjectLinkItem.getSWTWidget());
		
		try {
			new DefaultShell(OpenShiftLabel.Shell.CREATE_OS_PROJECT);
		} catch (RedDeerException ex) {
			fail("Create new OpenShift project shell has not been opened.");
		}
		
		new LabeledText(OpenShiftLabel.TextLabels.PROJECT_NAME).setText(
				projectName);

		new WaitUntil(new WidgetIsEnabled(new FinishButton()));
		
		new FinishButton().click();
		projectCreated = true;
		
		new WaitWhile(new ShellWithTextIsAvailable(OpenShiftLabel.Shell.CREATE_OS_PROJECT), TimePeriod.LONG);
		
		assertTrue("OpenShift project is not visible in OpenShift Explorer under the connection"
				+ " although it should have been created successfully and visible.",
				explorer.getOpenShift3Connection().projectExists(projectName));
	}
	
	@After
	public void deleteTestProject() {
		if (projectCreated) {
			new OpenShiftExplorerView().getOpenShift3Connection().getProject(projectName).delete();
		}
	}
}
