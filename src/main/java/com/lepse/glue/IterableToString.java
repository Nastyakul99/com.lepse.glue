package com.lepse.glue;

import com.lepse.glue.symbols.ISymbol;
import com.lepse.glue.symbols.Symbols;

public class IterableToString implements IterableMapper {
	
	private final Gluer gluer = new Gluer();

	public <T> String map(Iterable<T> elements, ISymbol separator, ISymbol prefix, ISymbol suffix) {
		 return  Symbols.asString(prefix) 
				 + gluer.glue(elements, separator)
				 +  Symbols.asString(suffix);
	}
}
