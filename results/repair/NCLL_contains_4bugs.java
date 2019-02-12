public boolean contains( Object arg ) {
	LinkedListNode node = header; //mutGenLimit 1
	int counter = this.maximumCacheSize; //mutGenLimit 1
	while (node == header && node.value != arg) { //mutGenLimit 1
	    this.firstCachedNode = node.next; //mutGenLimit 1
	    counter = counter - 1; //mutGenLimit 1
	}
	if (node != header && node.value != arg) { //mutGenLimit 1
	    return true;
	}
	return false;
}
