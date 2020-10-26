package com.licly.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/26
 */
public class NioPractice {

	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		ReadableByteChannel ic = Channels.newChannel(new FileInputStream("C:\\develop\\JDK.zip"));
		WritableByteChannel oc = Channels.newChannel(new FileOutputStream("C:\\develop\\JDK\\b"));

		ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 16);

		while (ic.read(buffer) != -1) {
			buffer.flip();
			oc.write(buffer);
			buffer.clear();
		}

		ic.close();
		oc.close();

		System.out.println(System.currentTimeMillis() - begin);
	}

}
