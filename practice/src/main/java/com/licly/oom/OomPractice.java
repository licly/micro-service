package com.licly.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 无限制队列导致OOM
 *
 * @author licly
 * @date 2020/10/9
 */

public class OomPractice {

    private static List list =	new ArrayList<Object>();


	public static void main(String[] args) {
		while (true) {
			list.add(new Object());
			System.out.println(list.size());
		}
	}
}
