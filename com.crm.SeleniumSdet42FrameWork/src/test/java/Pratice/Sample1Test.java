package Pratice;

import org.testng.annotations.Test;

public class Sample1Test {

	@Test(invocationCount = 3)
	public void createCustomerTest()
	{
		System.out.println("Customer details Created");
			}
	@Test(dependsOnMethods ="createCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("customer details modified");
	}
	@Test(dependsOnMethods ="createCustomerTest")
	public void deleteCutomerTest()
	{
		System.out.println("customer details deleted");
	}
}
