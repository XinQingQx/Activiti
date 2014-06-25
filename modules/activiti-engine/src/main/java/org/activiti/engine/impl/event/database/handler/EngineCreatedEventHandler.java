package org.activiti.engine.impl.event.database.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.EventLogEntryEntity;

/**
 * @author Joram Barrez
 */
public class EngineCreatedEventHandler extends AbstractDatabaseEventLoggerEventHandler {

	@Override
	public EventLogEntryEntity generateEventLogEntry() {
		Map<String, Object> data = new HashMap<String, Object>();
		try {
	    data.put("ip", InetAddress.getLocalHost().getHostAddress()); // Note that this might give the wrong ip address in case of multiple network interfaces - but it's better than nothing.
    } catch (UnknownHostException e) {
	    // Best effort
    }
		return createEventLogEntry(data);
	}

}
