/**
 * Reemplaza todos los valores que son iguales a
 * un valor especificado con otro valor
 * especificado y retorna cuantos valores fueron
 * reemplazados.
 * 
 * @param array donde se realizan los reemplazos
 * @param what el valor a buscar
 * @param with el valor con el cual reemplazar
 * @return la cantidad de reemplazados realizados
 * ----------------------------------------------
 * Pre:
 * 	array != null
 * Post:	
 * 	foreach v in 0..(array.length-1) |
 * 		old(array[v]) == what => array[v] == with)
 * 	count v in 0..(array.length-1) |
 * 		old(array[idx]) == what)
 */
public static int replace(int[] array, int what, int with) {
	int idx = 0;
	int changes = 0;
	while (idx < array.length) {
		if (array[idx] == what) {
			array[idx] = with;
			changes++;
		}
		idx++;
	}
	return changes;
}
