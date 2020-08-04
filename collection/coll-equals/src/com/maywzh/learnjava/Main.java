package com.maywzh.learnjava;

import java.util.*;

/**
 * Learn Java from https://www.maywzh.com/
 * 
 * @author maywzh
 */
public class Main {
	public static void main(String[] args) {
		List<Person> list = List.of(new Person("Xiao", "Ming", 18), new Person("Xiao", "Hong", 25),
				new Person("Bob", "Smith", 20));
		boolean exist = list.contains(new Person("Bob", "Smith", 20));
		System.out.println(exist ? "测试成功!" : "测试失败!");
	}
}

class Person {
	String firstName;
	String lastName;
	int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	 * TODO: 覆写equals方法
	 */
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o;
			return this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName) && this.age == p.age;
		}
		return false;
	}
}
