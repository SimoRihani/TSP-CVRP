package util;

class Link<T> {
	public T element;
	public Link<T> next = null;
	
	public Link(T element){
		this.element = element;
	}
	
}
