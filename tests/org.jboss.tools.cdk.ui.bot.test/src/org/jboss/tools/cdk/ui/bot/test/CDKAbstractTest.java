/******************************************************************************* 
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.tools.cdk.ui.bot.test;

import java.util.HashMap;
import java.util.Map;

import org.jboss.tools.cdk.ui.bot.test.utils.CDKTestUtils;

public abstract class CDKAbstractTest {

	public static final String SERVER_HOST = "localhost"; //$NON-NLS-1$
	
	public static final String SERVER_TYPE_GROUP = "Red Hat JBoss Middleware"; //$NON-NLS-1$
	
	public static final String CREDENTIALS_DOMAIN = "access.redhat.com"; //$NON-NLS-1$
	
	public static final String CDK_SERVER_NAME = "Red Hat Container Development Kit 2.x"; //$NON-NLS-1$

	public static final String CDK3_SERVER_NAME = "Red Hat Container Development Kit 3"; //$NON-NLS-1$
	
	public static final String SERVER_ADAPTER = "Container Development Environment"; //$NON-NLS-1$
	
	public static final String USERNAME;
	
	public static final String PASSWORD;
	
	public static final String VAGRANTFILE_PATH;
	
	public static final String MINISHIFT_HYPERVISOR;
	
	public static final String MINISHIFT_PATH;
	
	static {
		USERNAME = CDKTestUtils.getSystemProperty("developers.username"); //$NON-NLS-1$
		PASSWORD = CDKTestUtils.getSystemProperty("developers.password"); //$NON-NLS-1$
		VAGRANTFILE_PATH = CDKTestUtils.getSystemProperty("vagrantfile.path"); //$NON-NLS-1$
		MINISHIFT_PATH = CDKTestUtils.getSystemProperty("minishift.path"); //$NON-NLS-1$
		MINISHIFT_HYPERVISOR = CDKTestUtils.getSystemProperty("minishift.hypervisor"); //$NON-NLS-1$
	}
	
	public static void checkMinishiftParameters() {
		Map<String, String> dict = new HashMap<>();
		dict.put("Minishift path", MINISHIFT_PATH);
		dict.put("Minishift hypervisor", MINISHIFT_HYPERVISOR == null ? "" : MINISHIFT_HYPERVISOR);
		CDKTestUtils.checkParameterNotNull(dict);
	}
	
	public static void checkDevelopersParameters() {
		Map<String, String> dict = new HashMap<>();
		dict.put("Username", USERNAME);
		dict.put("Password", PASSWORD);
		CDKTestUtils.checkParameterNotNull(dict);
	}
	
	public static void checkVagrantfileParameters() {
		Map<String, String> dict = new HashMap<>();
		dict.put("Vagrantfile path", VAGRANTFILE_PATH);
		CDKTestUtils.checkParameterNotNull(dict);		
	}
}
