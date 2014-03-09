package our.company.name.application.utils;

import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is just a "Diagnostics" class. It has no important relation to main
 * code.It is mostly intended to be used by developers of this application to
 * print out some messages to the log file / log console. Also they are further
 * expected to remove calls to this class when their development of any module
 * is complete.
 */
public class WrappedSessionDiagnostics {

	static Logger log = LoggerFactory
			.getLogger(WrappedSessionDiagnostics.class);

	@SuppressWarnings("hiding")
	public static <Object> void printSetInformation(Set<Object> objectSet) {

		log.info("--------------------------------------------------------------");

		Iterator<Object> objectsIterator = objectSet.iterator();

		while (objectsIterator.hasNext()) {

			log.info(objectsIterator.next().toString());

		}

		log.info("--------------------------------------------------------------");

	}
}
