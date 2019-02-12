/*@
  @ requires true;
  @ ensures \result == true <==> (
		\exists LinkedListNode n;
			\reach(header, LinkedListNode, next).has(n)
			&&
			n != header;
			n.value == arg
		);
  @ ensures (\forall LinkedListNode n;
		\old(\reach(header, LinkedListNode, next)).has(n);
		\reach(header, LinkedListNode, next).has(n)
		);
  @ ensures (\forall LinkedListNode n;
		\reach(header, LinkedListNode, next).has(n);
		\old(\reach(header, LinkedListNode, next)).has(n)
		);
  @ signals (Exception e) false;
@*/
public boolean contains( Object arg ) {
	LinkedListNode node = header.next;
        int counter = 0;
        //@decreasing size - counter;
        while (node != header && node.value != arg) {
            node = node.next;
            counter++;
        }
        if (node != header && node.value == arg) {
            return true;
        }
        return false;
}
