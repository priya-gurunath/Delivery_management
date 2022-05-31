package com.sample;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class Testclass {

	@Test
	public void test() {
		main mm=new main();
		try {
			String s1=mm.customer_registation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
