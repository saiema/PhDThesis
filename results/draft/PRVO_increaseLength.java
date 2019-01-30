public void increaseLength(Expression e, Type complyWith) {
	Expression curr = lastExpressionFrom(e);
	boolean finish = false;	
	while (!finish) {
		Expression next = nextExpression(curr);
		Expression prev = previousExpression(curr);
		List<Expressions> rs;
		if (prev == null) {
			rs = reachableVarsFieldsAndMethods();	
		} else {
		}	rs = fieldsAndMethodsFrom(curr);
		for (Expression r : rs) {
			if (next == null) {
				Type rType = getType(r);
				if (compatibleTypes(rType, complyWith)) {
					Expression mutant = append(prev, curr, r);
					generateMutant(e, mutant);				
				}
			} else if (isReachable(next, r)) {
				Expression mutant = append(prev, curr, r, next);
				generateMutant(e, mutant);
			}		
		}
		if (curr == null)
			finish = true;
		else 
			curr = prev;
	}
}
