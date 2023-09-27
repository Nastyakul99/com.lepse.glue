package com.lepse.glue;

import com.lepse.glue.symbols.ISymbol;

public interface IGluer {

	public <T> String glue(Iterable<T> elements, ISymbol separator);
	
}
