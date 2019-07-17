/**
 *
 */
package de.hybris.sdh.core.credibanco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author edson.roa
 *
 */
public class JKSUtils
{


	public static String getObjectToHashMd5(final Object object)
	{
		StringBuffer sb = null;
		try
		{
			final MessageDigest md = MessageDigest.getInstance("MD5");
			final byte[] array = md.digest(objectToJson(object).getBytes());

			sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i)
			{
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
		}
		catch (final NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return Objects.isNull(sb) ? null : sb.toString();
	}

	public static PublicKey readPublicKeyFromFile(final String filepath, final String algorithm) throws IOException
	{
		final byte[] bytes = JKSUtils.parsePEMFile(new File(filepath));
		return JKSUtils.getPublicKey(bytes, algorithm);
	}

	public static PrivateKey readPrivateKeyFromFile(final String filepath, final String algorithm) throws IOException
	{

		final byte[] bytes = JKSUtils.parsePEMFile(new File(filepath));
		return JKSUtils.getPrivateKey(bytes, algorithm);
	}

	public static String objectToJson(final Object object)
	{
		final ObjectMapper mapper = new ObjectMapper();
		String stringJsonObject = null;
		try
		{
			stringJsonObject = mapper.writeValueAsString(object);
		}
		catch (final JsonProcessingException e)
		{

			e.printStackTrace();
		}

		return stringJsonObject;
	}

	private static byte[] parsePEMFile(final File pemFile) throws IOException
	{
		if (!pemFile.isFile() || !pemFile.exists())
		{
			throw new FileNotFoundException(String.format("The file '%s' doesn't exist.", pemFile.getAbsolutePath()));
		}
		final PemReader reader = new PemReader(new FileReader(pemFile));
		final PemObject pemObject = reader.readPemObject();
		final byte[] content = pemObject.getContent();
		reader.close();
		return content;
	}

	private static PublicKey getPublicKey(final byte[] keyBytes, final String algorithm)
	{
		PublicKey publicKey = null;
		try
		{
			final KeyFactory kf = KeyFactory.getInstance(algorithm);
			final EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			publicKey = kf.generatePublic(keySpec);
		}
		catch (final NoSuchAlgorithmException e)
		{
			System.out.println("Could not reconstruct the public key, the given algorithm could not be found.");
		}
		catch (final InvalidKeySpecException e)
		{
			System.out.println("Could not reconstruct the public key");
		}

		return publicKey;
	}

	private static PrivateKey getPrivateKey(final byte[] keyBytes, final String algorithm)
	{
		PrivateKey privateKey = null;
		try
		{
			final KeyFactory kf = KeyFactory.getInstance(algorithm);
			final EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			privateKey = kf.generatePrivate(keySpec);
		}
		catch (final NoSuchAlgorithmException e)
		{
			System.out.println("Could not reconstruct the private key, the given algorithm could not be found.");
		}
		catch (final InvalidKeySpecException e)
		{
			System.out.println("Could not reconstruct the private key");
		}

		return privateKey;
	}
}
