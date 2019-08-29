package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		//Given - setup
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		//When - actual method call
		
		
		//Then - asserts
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
	}
	
	
	@Test
	public void letsMockListGet() {
		//Argument Matcher
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", listMock.get(0));
		//assertEquals(null, listMock.get(1));
		assertEquals("in28Minutes", listMock.get(1));
	}
	
	
	@Test
	public void letsMockListGet_usingBDD() {
		//Given
		List listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("in28Minutes");
		
		//When
		String firstElement = (String) listMock.get(0);
		
		//Then
		assertThat(firstElement, is("in28Minutes"));	
	}
	
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_throwAnException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		listMock.get(0);
	}
	
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_miingUp() {
		List listMock = mock(List.class);
		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
		listMock.get(0);
	}

}
