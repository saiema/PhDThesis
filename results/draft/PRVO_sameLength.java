public void sameLength(Expression e, Type complyWith) {
	if (e.size() == 0) {
		List<Expression> rs = reachableVarsFieldsAndMethods();
		for (Expression r : rs) {
			Type rType = getType(r);
			if (compatibleTypes(rType, complyWith) {
				generateMutant(e, r);			
			}
		}
		return;
	}
	for (Expression sub : elements(e)) {
		Expression previous = previousExpression(sub);
		Expression next = nextExpression(sub);
		List<Expression> rs;
		if (previous == null) {
			rs = reachableVarsFieldsAndMethods();	
		} else {
		}	rs = fieldsAndMethodsFrom(previous);
		for (Expression r : rs) {
			if (next == null) {
				Type rType = getType(r);
				if (compatibleTypes(rType, complyWith)) {
					generateMutant(e, e.replace(sub, r);
				}
			} else if (isReachableFrom(next, r)) {
				generateMutant(e, e.replace(sub, r));	
			}
		}	
	}
}
