/*@ requires true;
  @ ensures \old(Nodes) != null ==> 
		\old(\reach(Nodes, BinomialHeapNode, child + sibling)).has(\result);
  @ ensures (\forall BinomialHeapNode n;
		\reach(Nodes, BinomialHeapNode, child + sibling).has(n);
		\result.key <= n.key
		);
  @ ensures (\forall BinomialHeapNode n;
		\reach(Nodes, BinomialHeapNode, child + sibling).has(n);
		\old(n.key) == n.key
		);
@*/
public /* @ nullable @ */BinomialHeapNode extractMin() {
	if (Nodes == null) {
	    return null;
	}
	BinomialHeapNode temp = Nodes;
	BinomialHeapNode prevTemp = null;
	BinomialHeapNode minNode = null;
	minNode = Nodes.findMinNode();
	//@decreasing \reach(temp, BinomialHeapNode, sibling).int_size();
	while (temp.key != minNode.key) {
	    prevTemp = temp;
	    temp = temp.sibling;
	}
	if (prevTemp == null) {
	    Nodes = temp.sibling;
	} else {
	    prevTemp.sibling = temp.sibling;
	}
	temp = temp.child;
	BinomialHeapNode fakeNode = temp;
	//@decreasing \reach(temp, BinomialHeapNode, sibling).int_size();
	while (temp != null) {
	    temp.parent = null;
	    temp = temp.sibling;
	}
	if (Nodes == null && fakeNode == null) {
	    size = 0;
	} else {
	    if (Nodes == null && fakeNode != null) {
		Nodes = fakeNode.reverse( null );
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
	return minNode;
}
