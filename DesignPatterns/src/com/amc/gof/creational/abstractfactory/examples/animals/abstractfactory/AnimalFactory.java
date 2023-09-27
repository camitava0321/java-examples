/**
 * 
 */
package com.amc.gof.creational.abstractfactory.examples.animals.abstractfactory;

import com.amc.gof.creational.abstractfactory.examples.animals.animals.Animal;
import com.amc.gof.creational.abstractfactory.examples.animals.factory.BirdFactory;
import com.amc.gof.creational.abstractfactory.examples.animals.factory.SnakeFactory;

/**
 * Abstract class - cannot be instantiated but can be extended further to enhance the abstractfactory.
 * 
 * @author 109365
 *
 */
public abstract class AnimalFactory {
	public static final String BIRD="Bird";
	public static final String SNAKE="Snake";
	private static String factoryType;
	
	public static AnimalFactory getAnimalFactory(String factoryType)
	{
		AnimalFactory animalFactory = null;
		setFactoryType(factoryType);
		
		if (factoryType.equals(AnimalFactory.BIRD)) {
			animalFactory= BirdFactory.getFactory();
		}
		if (factoryType.equals(AnimalFactory.SNAKE)) {
			animalFactory= SnakeFactory.getFactory();
		}
		return animalFactory;
	}
	
	public static String getFactoryType()
	{
	return factoryType; 	
	}
	public static void setFactoryType(String factoryType) {
		AnimalFactory.factoryType = factoryType;
	}
	
	public abstract  Animal getAnimal(String animalType);
}
