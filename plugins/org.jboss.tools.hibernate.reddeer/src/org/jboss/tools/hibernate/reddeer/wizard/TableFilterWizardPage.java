package org.jboss.tools.hibernate.reddeer.wizard;

import org.jboss.reddeer.jface.wizard.WizardPage;
import org.jboss.reddeer.swt.condition.TreeHasChildren;
import org.jboss.reddeer.swt.impl.button.FinishButton;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.combo.LabeledCombo;
import org.jboss.reddeer.swt.impl.group.DefaultGroup;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.reddeer.swt.impl.tree.DefaultTree;
import org.jboss.reddeer.common.wait.WaitUntil;

/**
 * New Reverse Engineering Table wizard page
 * @author Jiri Peterka
 *
 */
public class TableFilterWizardPage extends WizardPage {

	/**
	 * Sets console configuration for reveng 
	 * @param cfgName console name
	 */
	public void setConsoleConfiguration(String cfgName) {
		new LabeledCombo("Console configuration:").setSelection(cfgName);
	}
	
	/**
	 * Refreshes database schema
	 */
	public void refreshDatabaseSchema() {
		new PushButton("Refresh").click();
		DefaultGroup group = new DefaultGroup("Database schema:");
		DefaultTree tree = new DefaultTree(group);
		new WaitUntil(new TreeHasChildren(tree));
	}
	
	/**
	 * Sets parent folder for reveng
	 * @param folder given folder name
	 */
	public void setParentFolder(String folder) {
		new LabeledText("Parent folder:").setText(folder);
	}
	
	/**
	 * Clicks finish button
	 */
	public void finish() {
		new FinishButton().click(); 
	}

	/**
	 * Press include button
	 */
	public void pressInclude() {
		new PushButton("Include...").click();	
	}
}
