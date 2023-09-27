/**
 * 
 */
package com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes;

/**
 * @author 109365
 *
 */
public class VenomousSnake implements Snake{

	public boolean hasVenom() {
		// TODO Auto-generated method stub
		return false;
	}

	public String name() {
		// TODO Auto-generated method stub
		return Snake.VIPER;
	}

}
