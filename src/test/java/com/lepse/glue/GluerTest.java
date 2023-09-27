package com.lepse.glue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import com.lepse.glue.symbols.Symbol;
import com.lepse.glue.symbols.Symbols;

public class GluerTest {

	@Test
	public void gluingListOfIntegersTest() {
		
		IGluer gluer = new Gluer();
		
		List<Integer> list = Arrays.asList(1,2,3);
		
		String result = gluer.glue(list, null);

		//System.out.println(result);
		Assert.assertEquals(result, "123");
		
		result = gluer.glue(list, Symbols.COMMA);
		//System.out.println(result);
		Assert.assertEquals(result, "1,2,3");
		
		result = ((Gluer)gluer).glue(list);
		//System.out.println(result);
		Assert.assertEquals(result, "123");
		
		list = Arrays.asList(1,null,3);
		
		result = gluer.glue(list, Symbols.COMMA);
		//System.out.println(result);
		Assert.assertEquals(result, "1,null,3");
	}
	
	@Test
	public void gluingWithСustomSeparatorTest() {
		
		IGluer gluer = new Gluer();
		
		List<String> list = Arrays.asList("aaa", "bbb", null, "ddd");
		
		String result = gluer.glue(list, new Symbol(" | "));

		//System.out.println(result);
		Assert.assertEquals(result, "aaa | bbb | null | ddd");
	}
	
	@Test
	public void iterableToStringTest() {
		
		IterableMapper mapper = new IterableToString();
		
		Set<String> set = new HashSet<String>(Arrays.asList("aaa", "bbb", "bbb", "ddd"));
		
		String result = mapper.map(set, new Symbol(" | "), new Symbol("<"), new Symbol(">"));

		//System.out.println(result);
		Assert.assertEquals(result, "<aaa | bbb | ddd>");
		
		result = mapper.map(set, null, null, null);
		//System.out.println(result);
		Assert.assertEquals(result, "aaabbbddd");
		
		result = mapper.map(set, new Symbol(" | "), null, null);
		//System.out.println(result);
		Assert.assertEquals(result, "aaa | bbb | ddd");
	}
	
	@Test
	public void gluingVarargsTest() {
		IGluer gluer = new Gluer();
		
		String result = gluer.glue(new Symbol(" | "), 1, 2, 3, 4);

		System.out.println(result);
		Assert.assertEquals(result, "1 | 2 | 3 | 4");
		
		result = gluer.glue(new Symbol(" * "), true, false, false);

		System.out.println(result);
		Assert.assertEquals(result, "true * false * false");
	}
}
