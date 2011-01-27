package org.diylc.swing.plugins.toolbox;

import java.util.EnumSet;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import org.diylc.common.BadPositionException;
import org.diylc.common.EventType;
import org.diylc.common.IPlugIn;
import org.diylc.common.IPlugInPort;
import org.diylc.swing.ISwingUI;
import org.diylc.swing.plugins.statusbar.StatusBar;


public class ToolBox implements IPlugIn {
	
	private static final Logger LOG = Logger.getLogger(StatusBar.class);
	
	private ISwingUI swingUI;

	public ToolBox(ISwingUI swingUI) {
		this.swingUI = swingUI;
	}

	@Override
	public void connect(IPlugInPort plugInPort) {
		try {
			swingUI.injectGUIComponent(new ComponentTabbedPane(plugInPort), SwingConstants.TOP);
		} catch (BadPositionException e) {
			LOG.error("Could not install the toolbox", e);
		}
	}

	@Override
	public EnumSet<EventType> getSubscribedEventTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processMessage(EventType eventType, Object... params) {
		// TODO Auto-generated method stub

	}
}
