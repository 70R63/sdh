package de.hybris.sdh.core.soap.pse.util;
<<<<<<< HEAD
=======

>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

<<<<<<< HEAD
import org.apache.ws.security.WSPasswordCallback;

public class PWCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
				System.out.println("JKS Alias Certified [" + pc.getIdentifer() + "]");
				pc.setPassword("sdh2019*");	
=======
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
>>>>>>> 3501aefa667527b4c0bb02ad0f617feb131dea73
			} else {
				throw new UnsupportedCallbackException(callbacks[i],
						"Unrecognized Callback");
			}
		}
	}
}