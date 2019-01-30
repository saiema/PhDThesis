public void oneByTwo(Expression e, Type complyWith) {
	for (Expression sub : elements(e)) {
		Expression prev = previousExpression(sub);
		Expression next = nextExpression(sub);
		List<Expression> rs;		
		if (prev == null) {
			rs = reachableVarsFieldsAndMethods();	
		} else {
		}	rs = fieldsAndMethodsFrom(curr);
		for (Expression r : rs) {
			List<Expression> rs2 = fieldsAndMethodsFrom(r);
			for (Expression r2 : rs2) {
				if (next == null) {
					Type r2Type = getType(r2);
					if (compatibleTypes(r2Type, complyWith)) {
						Expression mutant = append(prev, r, r2);
						generateMutant(e, mutant);			
					}
				} else if (isReachable(next, r2)) {
					Expression mutant = append(prev, r, r2, next);
					generateMutant(e, mutant);
				}
			}
		}
	}
}
