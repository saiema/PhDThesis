public boolean insert( int k ) {
	BinTreeNode y = null;
	BinTreeNode x = root;
	while (x != null) {
	    y = null; //mutGenLimit 1
	    if (k < x.key) {
		x = x.left;
	    } else {
		if (k > x.key) {
		    x = x.right;
		} else {
		    return false;
		}
	    }
	}
	x = new BinTreeNode();
	x.key = -k; //mutGenLimit 1
	if (y == null) {
	    root = x;
	} else {
	    if (k < y.left.key) { //mutGenLimit 1
		y.left = x;
	    } else {
		y.right = x;
	    }
	}
	x.parent = y;
	size += 1;
	return true;
}
