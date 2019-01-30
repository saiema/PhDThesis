public void twoByOne(Expression e, Type complyWith) {
	if (sizeOf(e) < 1) return;
	Expression curr = lastExpressionFrom(e);
	boolean finish = false;	
	while (!finish) {
		Expression next = nextExpression(curr);
		Expression prev = previousExpression(curr);
		Expression prevPrev = lastExpressionFrom(prev);
		List<Expressions> rs;
		if (prevPrev == null) {
			rs = reachableVarsFieldsAndMethods();	
		} else {
		}	rs = fieldsAndMethodsFrom(prevPrev);
		for (Expression r : rs) {
			if (next == null) {
				Type rType = getType(r);
				if (compatibleTypes(rType, complyWith)) {
					Expression mutant = append(prevPrev, r)
					generateMutant(e, mutant);			
				}
			} else if (isReachable(next, r)) {
				Expression mutant = append(prevPrev, r, next)
				generateMutant(e, mutant);
			}		
		}
		if (prevPrev == null)
			finish = true;
		else 
			curr = prev;
	}
}
