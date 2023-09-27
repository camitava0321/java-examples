/**
 * Depicts the usage of several creational design patterns
 */
package com.amc.gof.creational.abstractfactory.examples.animals.usage;

import com.amc.gof.creational.abstractfactory.examples.animals.abstractfactory.AnimalFactory;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.Animal;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.birds.Bird;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes.Snake;

/**
 * @author 109365
 *
 */
public class Main {

	public static AnimalFactory showAbstractFactoryPatternUsage(String factoryType)
	{
		//Gives me a factory but I do not know the name of the underlying factory class
		return AnimalFactory.getAnimalFactory(factoryType);
	}
	
	public static Animal showFactoryPatternUsage(AnimalFactory factory,
			String animalType)
	{
		Animal animal=null;
		if (factory.getFactoryType().equals(AnimalFactory.BIRD)) {
			animal = (Bird)factory.getAnimal(animalType);
		}
		if (factory.getFactoryType().equals(AnimalFactory.SNAKE)) {
			animal = (Snake)factory.getAnimal(Snake.TYPE_VENOUMOUS);
		}
	return animal;
	}
	
	public static void main(String[] args) 
	{
		//Display how an abstractfactory pattern is used - I want an albatross
		AnimalFactory factory = showAbstractFactoryPatternUsage(AnimalFactory.BIRD);
		//Although I do not know the underlying factory class, I know that it will give me an albatross
		Animal animal = showFactoryPatternUsage(factory, Bird.ALBATROSS);
		//Lets see - if it is really an albatross
		System.out.println("Asked for an albatross, and I got : "+animal.name());
		
		//Exactly same codepiece with different parameters - Now I want a venomous snake
		factory = showAbstractFactoryPatternUsage(AnimalFactory.SNAKE);
		//Although I do not know the underlying factory class, I know that it will give me a venomous snake
		animal = showFactoryPatternUsage(factory, Snake.TYPE_VENOUMOUS);
		//Lets see - if it is really a venomous snake
		System.out.println("Asked for a venomous snake, and I got : "+animal.name());
	}
}
