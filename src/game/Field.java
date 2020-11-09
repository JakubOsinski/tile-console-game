package game;

import java.util.ArrayList;

import mapelements.Element;
import mapelements.Letter;

public class Field 
{
	private int index;
    private int y;
    private int x;
	private Letter letter; // enum
	private Element element; // enum
	private int[] elementDetails;
//	public Field(int index, Letter letter, Element element) {
//		this.index = index;
//		this.letter = letter;
//		this.element = element;
//	}
	public Field() {
		
	}
	public Field(int y, int x, Letter letter, Element element) {
		this.y = y;
		this.x = x;
		this.letter = letter;
		this.element = element;
	}
	public Field(int y, int x, Letter letter, Element element, int[] elementDetails) {
		this.y = y;
		this.x = x;
		this.letter = letter;
		this.element = element;
		this.elementDetails = elementDetails;
	}
	public Field(int[] elementDetails) {
		this.elementDetails = elementDetails;
	}
	public void setElementDetails(int[] elementDetails) {
		this.elementDetails = elementDetails;
	}
	public int[] getElementDetails() {
		return this.elementDetails;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	public Letter getLetter() {
		return letter;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	
	public Element getElement() {
		return element;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	public void fieldInteraction(int id) // Player play, Element element
	{
		//return result // true if action successful
	}
}
