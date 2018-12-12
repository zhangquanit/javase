package com.heima.stream.trans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流 字节流转换为字符流 InputStream 通过InputStreamReader转换为字符流Reader
 * OutputStream通过OutputStreamWriter转换为Writer
 */
public class TransStreamDemo {
	public static void main(String[] args) throws IOException {

		//InputStream 转换为Reader
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		//OutputStream转换为Writer
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("transdemo.txt")));
		String line = null;
		while ((line = input.readLine()) != null) {
			if("over".equals(line))
				break;
			
			bw.write(line);
			bw.newLine();
		}
		bw.close();
		input.close();

	}

}
