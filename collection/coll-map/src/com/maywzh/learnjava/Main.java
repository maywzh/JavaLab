package com.maywzh.learnjava;

import java.util.*;

/**
 * Learn Java from https://www.maywzh.com/
 * 
 * @author maywzh
 */
public class Main {
	public static void main(String[] args) {
		List<Student> list = List.of(new Student("Bob", 78), new Student("Alice", 85), new Student("Brush", 66),
				new Student("Newton", 99));
		var holder = new Students(list);
		System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
		System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
		System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
		holder.printCache();
	}
}

class Students {
	List<Student> list;
	Map<String, Integer> cache;

	Students(List<Student> list) {
		this.list = list;
		cache = new HashMap<>();
	}

	int getScore(String name) {
		// 先在Map中查找:
		Integer score = this.cache.get(name);
		if (score == null) {
			score = findInList(name);
			if (score != null) {
				this.cache.put(name, score);
			}
		}
		return score == null ? -1 : score.intValue();

	}

	Integer findInList(String name) {
		for (var ss : this.list) {
			if (ss.name.equals(name)) {
				return ss.score;
			}
		}
		return null;
	}

	void printCache() {
		for (var k : this.cache.keySet()) {
			var v = this.cache.get(k);
			System.out.println(k + " " + v);
		}
	}
}

class Student {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
