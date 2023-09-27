/**
 * 
 */
package com.amc.generics;

/**
 * @author Amitava Chakraborty 2010
 *
 */
public class OrderedPair<K,V> implements Pair<K,V>{

	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key=key;
		this.value=value;
	}
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> pair1 = new OrderedPair<String, Integer>("Age", 40);
		Pair<String, String> pair2 = new OrderedPair<String, String>("Name", "Amitava Chakraborty");
	}

}
