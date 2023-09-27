package com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes;

public class NonVenomousSnake implements Snake{

	public boolean hasVenom() {
		// TODO Auto-generated method stub
		return false;
	}

	public String name() {
		// TODO Auto-generated method stub
		return Snake.PYTHON;
	}

}
