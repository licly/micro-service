package com.licly.io.bio;

import java.io.*;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/26
 */
public class BioPractice {

	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("C:\\develop\\JDK.zip");
		FileOutputStream fos = new FileOutputStream("C:\\develop\\JDK\\a");
		byte[] bytes = new byte[1024 * 16];

		int len;
		while ((len = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, len);
		}

		fis.close();

		fos.close();

		System.out.println(System.currentTimeMillis() - begin);
	}

}
