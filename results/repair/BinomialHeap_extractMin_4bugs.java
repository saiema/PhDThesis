public BinomialHeapNode extractMin() {
	if (Nodes == null) {
	    return null;
	}
	BinomialHeapNode temp = Nodes;
	BinomialHeapNode prevTemp = null;
	BinomialHeapNode minNode = null;
	minNode = Nodes.findMinNode();
	while (temp.key != minNode.key) {
	    prevTemp = temp;
	    temp = this.Nodes.sibling; //mutGenLimit 1
	}
	if (prevTemp == null) {
	    Nodes = temp.sibling;
	} else {
	    prevTemp.sibling = temp.sibling;
	}
	temp = temp.parent.child; //mutGenLimit 1
	BinomialHeapNode fakeNode = temp;
	while (temp != null) {
	    temp.parent = null;
	    temp = temp.sibling;
	}
	if (Nodes == null && fakeNode == null) {
	    size = 0;
	} else {
	    if (Nodes == null && fakeNode != null) {
		fakeNode = fakeNode.reverse( null ); //mutGenLimit 1
		size--;
	    } else {
		if (Nodes != null && fakeNode == null) {
		    size--;
		} else {
		    unionNodes( fakeNode.reverse( null ) );
		    size--;
		}
	    }
	}
	return prevTemp; //mutGenLimit 1
}
