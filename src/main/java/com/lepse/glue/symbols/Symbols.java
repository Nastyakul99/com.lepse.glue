package com.lepse.glue.symbols;

public enum Symbols implements ISymbol {
	
	NULL("null"),
	EMPTY(""),
	COMMA(",");
	
	private Symbols(String value) {
		this.value = value;
	}
	
	private final String value;

	public String value() {
		return value;
	}
	
	public static String asString(ISymbol symbol) {
		return symbol == null ? EMPTY.value : symbol.value();
	}
}
