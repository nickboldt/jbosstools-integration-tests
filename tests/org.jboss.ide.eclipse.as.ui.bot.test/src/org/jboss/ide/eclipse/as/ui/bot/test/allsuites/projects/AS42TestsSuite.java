package org.jboss.ide.eclipse.as.ui.bot.test.allsuites.projects;

import org.jboss.ide.eclipse.as.ui.bot.test.as42.CreateAS42Server;
import org.jboss.ide.eclipse.as.ui.bot.test.as42.DeleteServerAS42Server;
import org.jboss.ide.eclipse.as.ui.bot.test.as42.OperateAS42Server;
import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(RedDeerSuite.class)
@Suite.SuiteClasses({
		CreateAS42Server.class,
		OperateAS42Server.class,
		DeleteServerAS42Server.class,
})
public class AS42TestsSuite {

}
