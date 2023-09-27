/**
 * Returns an instance of a bird based on a parameter.
 */
package com.amc.gof.creational.abstractfactory.examples.animals.factory;

import com.amc.gof.creational.abstractfactory.examples.animals.abstractfactory.AnimalFactory;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.Animal;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.birds.Albatross;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.birds.Bird;
import com.amc.gof.creational.abstractfactory.examples.animals.animals.birds.Pegion;

/**
 * @author 109365
 *
 */
public class BirdFactory extends AnimalFactory{
	public static final BirdFactory factory=new BirdFactory();
	/**
	 * cannot be constructed.
	 */
	private BirdFactory()
	{
		
	}
	
	/**
	 * Returns an instance of a Bird based on a parameter.
	 * Returns null for an invalid parameter.
	 * @param type
	 * @return
	 */
	public static Bird getBird(String type)
	{
		Bird Bird=null;
		if (type.equals(Bird.ALBATROSS)) {
			Bird = new Albatross();
		}
		if (type.equals(Bird.PEGION)) {
			Bird = new Pegion();
		}
	return Bird;
	}
	
	public static BirdFactory getFactory()
	{
		return factory;
	}

	public Animal getAnimal(String animalType) {
		// TODO Auto-generated method stub
		return getBird(animalType);
	}
}
