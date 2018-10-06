package org.kyojo.minion;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Map.Entry;

import org.kyojo.gson.Gson;
import org.kyojo.gson.GsonBuilder;
import org.kyojo.gson.reflect.TypeToken;
import org.kyojo.modeshape.common.text.Inflector;

/**
 * This is the main class for using minion. minion is an object data exchange helper.
 */
public final class My {

	public static String MYHS_SALT = "qgCYkPcrMl5WK2vK3VJF";

	protected static Gson gson;

	static {
		try {
			GsonBuilder builder = new GsonBuilder();
			Properties props = searchProperties();

			if(props != null) {
				for(Entry<Object, Object> entry : props.entrySet()){
					if(entry.getKey().toString().equals("MYHS_SALT")) {
						MYHS_SALT = entry.getValue().toString();
						continue;
					}

					System.out.println(entry.getKey().toString() + "=" + entry.getValue().toString());
					if(entry.getKey().toString().indexOf(",") < 0) {
						Class<?> ifcCls = My.class.getClassLoader().loadClass(entry.getKey().toString());
						Class<?> crtrCls = My.class.getClassLoader().loadClass(entry.getValue().toString());
						builder.registerTypeAdapter(ifcCls, crtrCls.newInstance());
					} else {
						String[] ifcClsNames = entry.getKey().toString().split(",");
						Class<?> ifcCls1 = My.class.getClassLoader().loadClass(ifcClsNames[0]);
						Class<?> ifcCls2 = My.class.getClassLoader().loadClass(ifcClsNames[1]);
						Type listType = TypeToken.getParameterized(ifcCls1, ifcCls2).getType();
						Class<?> crtrCls = My.class.getClassLoader().loadClass(entry.getValue().toString());
						builder.registerTypeAdapter(listType, crtrCls.newInstance());
					}
				}
			}

			gson = builder.setExclusionStrategies(new SuperclassExclusionStrategy())
				// .setExclusionStrategies(new OnlyPublicFieldInclusionStrategy())
				// .serializeNulls()
				.create();
		} catch(ClassNotFoundException cnfe) {
			throw new RuntimeException(cnfe);
		} catch(IllegalAccessException iae) {
			throw new RuntimeException(iae);
		} catch(InstantiationException ie) {
			throw new RuntimeException(ie);
		}
	}

	private static Properties searchProperties() {
		try {
			URL rscUrl = My.class.getResource("My.properties");
			if(rscUrl != null) {
				InputStream is = rscUrl.openStream();
				Properties props = new Properties();
				props.load(is);
				is.close();
				return props;
			}
		} catch(IOException ioe) {
			throw new RuntimeException(ioe);
		}

		return null;
	}

	/**
	 * Obtains the hash in hex string form.
	 *
	 * @param str a string (converted to bytes) to obtain its hash
	 * @return hash string
	 */
	public static String hs(String str) {
		if(str == null || str.equals("")) {
			return "";
		}

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update((MYHS_SALT + str).getBytes("ISO-8859-1"));
			return bin2HexStr(md.digest());
		} catch(NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
			throw new RuntimeException(nsae);
		} catch(UnsupportedEncodingException nee) {
			nee.printStackTrace();
			throw new RuntimeException(nee);
		}
	}

	/**
	 * Converts the given bytes to hex string form.
	 *
	 * @param bin bytes to convert
	 * @return hex string
	 */
	public static String bin2HexStr(byte[] bin) {
		StringBuilder sb = new StringBuilder();
		int len = bin.length;
		int val;
		for(int i = 0; i < len; i++) {
			val = bin[i] & 0xFF;
			if(val < 0x10) {
				sb.append("0");
			}
			sb.append(Integer.toHexString(val));
		}

		return sb.toString();
	}

	/**
	 * Serializes the given object to JSON. This method is the wrapper of {@link GSON#toJSON}.
	 * But it added the feature own keys sorted in ascii order.
	 *
	 * @param var object to serialize
	 * @return JSON string
	 */
	public static String minion(Object var) {
		return gson.toJson(var);
	}

	/**
	 * Deserializes the given JSON string to the object. This method is the wrapper of {@link GSON#fromJSON}.
	 * The deserializer classes defined in {@code org/kyojo/minion/My.properties} are registered automatically.
	 *
	 * @param str JSON string
	 * @param type the object type
	 * @return the deserialized object
	 */
	public static <T> T deminion(String str, Type type) {
		return gson.fromJson(str, type);
	}

	/**
	 * The tableize method. e.g. {@code creativeWork.author} → {@code creative_work__author}
	 *
	 * @param word A word to convert
	 * @return converted string
	 */
	public static String tableize(String word) {
		if(word == null) return null;
		Inflector inflector = Inflector.getInstance();
		return inflector.underscore(word.replaceAll("\\.", "__"));
	}

	/**
	 * The pascalize method. e.g. {@code creative_work__author} → {@code CreativeWork.Author}
	 *
	 * @param word A word to convert
	 * @return converted string
	 */
	public static String pascalize(String word) {
		if(word == null) return null;
		Inflector inflector = Inflector.getInstance();
		StringBuilder sb = new StringBuilder();
		for(String elem : word.split("__|\\.")) {
			if(sb.length() > 0) {
				sb.append(".");
			}
			sb.append(inflector.upperCamelCase(elem));
		}
		return sb.toString();
	}

	/**
	 * The camelize method. e.g. {@code creative_work__author} → {@code creativeWork.author}
	 *
	 * @param word A word to convert
	 * @return converted string
	 */
	public static String camelize(String word) {
		if(word == null) return null;
		Inflector inflector = Inflector.getInstance();
		StringBuilder sb = new StringBuilder();
		for(String elem : word.split("__|\\.")) {
			if(sb.length() > 0) {
				sb.append(".");
			}
			sb.append(inflector.lowerCamelCase(elem));
		}
		return sb.toString();
	}

	/**
	 * The constantize method. e.g. {@code creativeWork.author} → {@code CREATIVE_WORK__AUTHOR}
	 *
	 * @param word A word to convert
	 * @return converted string
	 */
	public static String constantize(String word) {
		if(word == null) return null;
		return tableize(word).toUpperCase();
	}

	/**
	 * The magicalize method. e.g. {@code creativeWork.author} → {@code __CREATIVE_WORK__AUTHOR__}
	 *
	 * @param word A word to convert
	 * @return converted string
	 */
	public static String magicalize(String word) {
		if(word == null) return null;
		return "__" + constantize(word) + "__";
	}

}
