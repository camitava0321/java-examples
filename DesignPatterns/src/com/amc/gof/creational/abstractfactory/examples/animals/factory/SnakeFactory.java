/**
 * Returns an instance of a snake (venomous/NonVenomous) based on a parameter.
 */
package com.amc.gof.creational.abstractfactory.examples.animals.factory;

import com.amc.gof.creational.abstractfactory.examples.animals.abstractfactory.AnimalFactory;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.Animal;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes.NonVenomousSnake;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes.Snake;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes.VenomousSnake;

/**
 * @author 109365
 *
 */
public class SnakeFactory extends AnimalFactory{

	public static final SnakeFactory factory=new SnakeFactory();
	/**
	 * cannot be constructed.
	 */
	private SnakeFactory()
	{
		
	}
	
	/**
	 * Returns an instance of a snake (venomous/NonVenomous) based on a parameter.
	 * Returns null for an invalid parameter.
	 * @param type
	 * @return
	 */
	public static Snake getSnake(String type)
	{
		Snake snake=null;
		if (type.equals(Snake.TYPE_VENOUMOUS)) {
			snake = new VenomousSnake();
		}
		if (type.equals(Snake.TYPE_NONVENOUMOUS)) {
			snake = new NonVenomousSnake();
		}
	return snake;
	}
	
	public static SnakeFactory getFactory()
	{
		return factory;
	}

	public Animal getAnimal(String animalType) {
		// TODO Auto-generated method stub
		return getSnake(animalType);
	}
	
}
