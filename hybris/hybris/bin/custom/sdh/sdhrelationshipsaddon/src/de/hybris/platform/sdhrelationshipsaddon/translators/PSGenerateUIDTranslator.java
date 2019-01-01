package de.hybris.platform.sdhrelationshipsaddon.translators;

import de.hybris.platform.impex.jalo.translators.SingleValueTranslator;
import de.hybris.platform.jalo.Item;

import java.util.UUID;


/**
 * Implementation class of {@link PSGenerateUIDTranslator} This is generate UID translator
 *
 */
public class PSGenerateUIDTranslator extends SingleValueTranslator
{
	@Override
	protected Object convertToJalo(final String input, final Item item)
	{
		if (input == null || input.isEmpty())
		{

			return UUID.randomUUID().toString();
		}
		return input;
	}

	@Override
	protected String convertToString(final Object o)
	{
		return null;
	}


}
