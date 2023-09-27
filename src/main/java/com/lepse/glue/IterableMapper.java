package com.lepse.glue;

import com.lepse.glue.symbols.ISymbol;

public interface IterableMapper {

	public <T> String map(Iterable<T> elements, ISymbol separator, ISymbol prefix, ISymbol suffix);
}
