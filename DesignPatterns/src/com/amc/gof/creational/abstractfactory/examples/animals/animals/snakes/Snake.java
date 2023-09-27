/**
 * 
 */
package com.amc.gof.creational.abstractfactory.examples.animals.animals.snakes;

import com.amc.gof.creational.abstractfactory.examples.animals.animals.Animal;

/**
 * @author 109365
 *
 */
public interface Snake extends Animal{

	public static final String TYPE_VENOUMOUS="V";
	public static final String TYPE_NONVENOUMOUS="N";
	public static final String VIPER="Viper";
	public static final String PYTHON="Python";
	public boolean hasVenom();
}
