/*******************************************************************************
 * Copyright (c) 2012 SMB GmbH, Dresden - Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SMB GmbH - initial API and implementation
 *******************************************************************************/

package aspects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.editor.PDEFormPage;

import base org.eclipse.pde.internal.ui.editor.plugin.RequiresSection;

import base org.eclipse.pde.internal.ui.editor.plugin.DependenciesPage;

/**
 * @author Lars Martin <a href="mailto:lars.martin@softwarebuero.de">lars.martin@softwarebuero.de</a>
 * 
 */
@SuppressWarnings("restriction")
public team class PDECustomizationTeam {

	/**
	 *  
	 */
	protected class RequiresSectionRole playedBy RequiresSection {

		private static final int REMOVE_VERSIONS_INDEX = 5;

		void makeActions() {
			new Action("Remove versions") {
				public void run() {
					handleRemoveVersions();
				}
			};
		}

		abstract PDEFormPage getPage();

		abstract void updateButtons();

		private void handleRemoveVersions() {
			IPluginModelBase model = (IPluginModelBase) getPage().getModel();
			IPluginBase pluginBase = model.getPluginBase();
			IPluginImport[] imports = pluginBase.getImports();
			try {
				for (IPluginImport pluginImport : imports) {
					pluginImport.setVersion("");
				}
			} catch (CoreException e) {
				PDEPlugin.logException(e);
			}
			updateButtons();
		}
		
		private void buttonSelected(int index) {
			if (index ==  REMOVE_VERSIONS_INDEX) {
				handleRemoveVersions();
			}
		}
		
		getPage -> getPage;
		
		@SuppressWarnings("decapsulation")
		updateButtons -> updateButtons;
		
		makeActions <- after makeActions;
		
		buttonSelected <- after buttonSelected;
	}

	/**
	 *
	 */
	protected class DependenciesPageRole playedBy DependenciesPage {

		callin String[] getRequiredSectionLabels() {
			List<String> labels = Arrays.asList(base.getRequiredSectionLabels());
			List<String> newLabels = new ArrayList<String>(labels);
			newLabels.add("Remove versions");
			return (String[]) newLabels.toArray(new String[newLabels.size()]);
		}
		
		@SuppressWarnings("decapsulation")
		getRequiredSectionLabels <- replace getRequiredSectionLabels;
		
	}

}
