package org.jboss.tools.seam.reddeer.wizards;

import org.jboss.reddeer.common.wait.TimePeriod;
import org.jboss.reddeer.common.wait.WaitUntil;
import org.jboss.reddeer.core.condition.ShellWithTextIsActive;
import org.jboss.reddeer.jface.wizard.WizardPage;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.combo.DefaultCombo;
import org.jboss.reddeer.swt.impl.combo.LabeledCombo;
import org.jboss.reddeer.swt.impl.group.DefaultGroup;
import org.jboss.reddeer.swt.impl.menu.ContextMenu;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.reddeer.swt.impl.tree.DefaultTreeItem;

public class SeamProjectFirstPage extends WizardPage{
	
	public void setProjectName(String name){
		new LabeledText("Project name:").setText(name);
	}
	
	public void activateFacet(String facet, String version){
		new PushButton("Modify...").click();
		new WaitUntil(new ShellWithTextIsActive("Project Facets"), TimePeriod.NORMAL);
		new DefaultTreeItem(facet).select();
		new DefaultTreeItem(facet).setChecked(true);
		if(version!=null){
			new ContextMenu("Change Version...").select();
			new WaitUntil(new ShellWithTextIsActive("Change Version"), TimePeriod.NORMAL);
			new LabeledCombo("Version:").setSelection(version);
			new PushButton("OK").click();
			new WaitUntil(new ShellWithTextIsActive("Project Facets"), TimePeriod.NORMAL);
		}
		new PushButton("OK").click();
		new WaitUntil(new ShellWithTextIsActive("New Seam Project"), TimePeriod.NORMAL);
	}
	
	public void setRuntime(String runtime){
		new DefaultCombo(new DefaultGroup("Target runtime")).setSelection(runtime);
	}
	
	public void setServer(String server){
		new DefaultCombo(new DefaultGroup("Target Server")).setSelection(server);
	}
}
