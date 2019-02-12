/*@
  @ requires true;
  @
  @ ensures (\exists BinTreeNode n;
  @		\old(\reach(root, BinTreeNode, left + right)).has(n) == true;
  @  	n.key == k) ==> size == \old(size);
  @
  @	ensures (\forall BinTreeNode n;
  @		\old(\reach(root, BinTreeNode, left + right)).has(n) == true;
  @  	n.key != k) ==> size == \old(size) + 1;
  @
  @ ensures (\exists BinTreeNode n;
  @     \reach(root, BinTreeNode, left + right).has(n) == true;
  @		n.key == k);
  @
  @ signals (RuntimeException e) false;
@*/
public boolean insert( int k ) {
	BinTreeNode y = null;
	BinTreeNode x = root;
	//@decreasing \reach(x, BinTreeNode, left+right).int_size();
	while (x != null) {
	    y = x;
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
	x.key = k;
	if (y == null) {
	    root = x;
	} else {
	    if (k < y.key) {
		y.left = x;
	    } else {
		y.right = x;
	    }
	}
	x.parent = y;
	size += 1;
	return true;
}
