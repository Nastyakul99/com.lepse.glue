package com.lepse.glue;

import java.util.Iterator;
import com.lepse.glue.symbols.ISymbol;
import com.lepse.glue.symbols.Symbols;

public class Gluer implements IGluer {
	
	private ISymbol emptyElement = Symbols.NULL;
	
	public <T> String glue(Iterable<T> elements) {
		return glue(elements, Symbols.EMPTY);
	}

	public <T> String glue(Iterable<T> elements, ISymbol separator) {
		if(elements == null) throw new NullPointerException();
		if(separator == null) return glue(elements);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(Iterator<T> iterator = elements.iterator(); iterator.hasNext(); ) {
			T element = iterator.next();
			stringBuilder.append(asString(element));
			if(iterator.hasNext()) stringBuilder.append(separator.value());
		}
		return stringBuilder.toString();
	}
	
	public void setEmptyElement(ISymbol emptyElement) {
		this.emptyElement = emptyElement;
	}

	private String asString(Object e) {
		return e == null ? emptyElement.value() : e.toString();
	}
}
