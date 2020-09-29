package de.hybris.sdh.core.pojos.requests;

public class ReteicaObligacionesRequest {
	private String bp;

	/**
	 * @return the bp
	 */
	public String getBp()
	{
		return bp;
	}

	/**
	 * @param bp
	 *           the bp to set
	 */
	public void setBp(final String bp)
	{
		this.bp = bp;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("{");
		stringBuilder.append("\"bp\":\"" + this.getBp() + "\"");
		stringBuilder.append("}");
		// XXX Auto-generated method stub
		return stringBuilder.toString();
	}

}
