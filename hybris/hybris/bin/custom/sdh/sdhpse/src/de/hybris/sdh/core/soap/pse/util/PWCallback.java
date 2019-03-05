package de.hybris.sdh.core.soap.pse.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.log4j.Logger;
import org.apache.ws.security.WSPasswordCallback;

public class PWCallback implements CallbackHandler {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(PWCallback.class);

	public void handle(final Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				final WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
				LOG.info("JKS Alias Certified [" + pc.getIdentifer() + "]");
				pc.setPassword("sdh2019*");
			} else {
				throw new UnsupportedCallbackException(callbacks[i],
						"Unrecognized Callback");
			}
		}
	}
}