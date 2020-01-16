package com.shrader.namescore.calculator


interface NameScoreAlgorithm {

    /**
     * @param names - list of name strings to parse
     * @return long - total score of all names in the list
     */
    fun score(names: List<String>): Long
}
