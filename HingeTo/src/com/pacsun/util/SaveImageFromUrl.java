package com.pacsun.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.log4j.Logger;

public class SaveImageFromUrl {

	private static String hostName;

	private static final Logger log = Logger.getLogger(SaveImageFromUrl.class);

	static {
		// for localhost testing only
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {

			public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
				if (hostname.equals(hostName)) {
					return true;
				}
				return false;
			}
		});
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {

		log.debug("imageUrl=" + imageUrl);

		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

	public static String getHostName() {
		return hostName;
	}

	public static void setHostName(String hostName) {
		SaveImageFromUrl.hostName = hostName;
	}

}