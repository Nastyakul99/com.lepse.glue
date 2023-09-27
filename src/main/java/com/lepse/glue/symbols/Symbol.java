package com.lepse.glue.symbols;

public class Symbol implements ISymbol {

	private final String value;
	
	public Symbol(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
