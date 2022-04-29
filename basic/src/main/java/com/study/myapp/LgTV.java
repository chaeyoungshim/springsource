package com.study.myapp;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV Volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV Volume Down");
	}
}
