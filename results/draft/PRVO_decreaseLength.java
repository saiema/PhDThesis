public void decreaseLength(Expression e, Type complyWith) {
	if (sizeOf(e) < 1) return;
	for (Expression sub : elements(e)) {
		Expression prev = previousExpression(sub);
		Expression next = nextExpression(sub);
		if (next == null) {
			Type prevType = getType(prev);
			if (compatibleType(prevType, complyWith)) {
				generateMutant(e, prev);
			}		
		} else if (isReachableFrom(prev, next)) {
			Expression mutant = append(prev, next);
			generateMutant(e, mutant);
		}
	}
}
