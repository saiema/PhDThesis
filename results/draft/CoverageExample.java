public static int countMultsOf(int[] values) {
    int count = 0;
    int idx = 0;
    while (idx < values.length) {
        if (values[idx] % 2 == 0)
           count++;
        idx++;
    }
    return count;
}
