package com.tje;

public class Main {

	public static void main(String[] args) {
		MemberRequest request = new MemberRequest();
		
		System.out.println(request.getMember().getName());
		System.out.println(request.getMember().getAge());
	}

}
