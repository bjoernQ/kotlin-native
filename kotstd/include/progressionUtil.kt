// a mod b (in arithmetical sense)
private fun mod(a: Int, b: Int): Int {
    val mod = a % b
    return if (mod >= 0) mod else mod + b
}

private fun mod(a: Long, b: Long): Long {
    val mod = a % b
    return if (mod >= 0) mod else mod + b
}

// (a - b) mod c
private fun differenceModulo(a: Int, b: Int, c: Int): Int {
    return mod(mod(a, c) - mod(b, c), c)
}

private fun differenceModulo(a: Long, b: Long, c: Long): Long {
    return mod(mod(a, c) - mod(b, c), c)
}

/**
 * Calculates the final element of a bounded arithmetic progression, i.e. the last element of the progression which is in the range
 * from [start] to [end] in case of a positive [step], or from [end] to [start] in case of a negative
 * [step].
 *
 * No validation on passed parameters is performed. The given parameters should satisfy the condition: either
 * `step > 0` and `start >= end`, or `step < 0` and`start >= end`.
 * @param start first element of the progression
 * @param end ending bound for the progression
 * @param step increment, or difference of successive elements in the progression
 * @return the final element of the progression
 * @suppress
 */
fun getProgressionLastElement(start: Int, end: Int, step: Int): Int {
    if (step > 0) {
        return end - differenceModulo(end, start, step)
    } else if (step < 0) {
        return end + differenceModulo(start, end, -step)
    } else {
        println("Step is zero.")
        assert(false)
        return -1
    }
}

/**
 * Calculates the final element of a bounded arithmetic progression, i.e. the last element of the progression which is in the range
 * from [start] to [end] in case of a positive [step], or from [end] to [start] in case of a negative
 * [step].
 *
 * No validation on passed parameters is performed. The given parameters should satisfy the condition: either
 * `step > 0` and `start >= end`, or `step < 0` and`start >= end`.
 * @param start first element of the progression
 * @param end ending bound for the progression
 * @param step increment, or difference of successive elements in the progression
 * @return the final element of the progression
 * @suppress
 */
internal fun getProgressionLastElement(start: Long, end: Long, step: Long): Long {
    if (step > 0) {
        return end - differenceModulo(end, start, step)
    } else if (step < 0) {
        return end + differenceModulo(start, end, -step)
    } else {
        println("Step is zero.")
        assert(false)
        return -1L
    }
}
