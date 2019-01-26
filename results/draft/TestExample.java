@Test(timeout = 2000)
public void test1() {
	NCLL list = new NCLL();
	list.add(1);
	assertTrue(list.contains(1));
}

public void test2() {
	NCLL list = new NCLL();
	list.add(1);
	list.remove(1);
	assertFalse(list.contains(1));
}
