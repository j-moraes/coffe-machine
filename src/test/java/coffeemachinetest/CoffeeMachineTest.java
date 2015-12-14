package coffeemachinetest;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineTest extends TestCase {
ICoffeeMachine coffeeMachine;

@Mock
IContainer coffeeContainer;
@Mock
IContainer waterContainer;

@Before
public void setUp() {
	coffeeMachine = new CoffeeMachine(coffeContainer, waterContainer);
}

@After
public void tearDown() {
	coffeContainer = null;
	WaterContainer = null;
	coffeMachine = null;
}

@Test
public void testMakeCoffe() throws NothEnoughException {
	when(coffeeContainer.getPortion(Portion.LARGE)).thenReturn(true);
	when(waterContainer.getPortion(Portion.LARGE)).thenReturn(true);
	assertTrue(coffeeMachine.makeCoffee(Portion.LARGE));
}

@Test
public void testNotEnoughException() throws NotEnoughException {
	when(coffeeContainer.getPortion(Portion.SMALL)).thenReturn(false);
	when(waterContainer.getPortion(Portion.SMALL)).thenReturn(false);
	assertfalse(coffeeMachine.makeCoffee(Portion.SMALL));
}
}
