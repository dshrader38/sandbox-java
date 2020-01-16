package com.shrader.namescore.computation.algorithms

import spock.lang.Shared
import spock.lang.Specification


class DefaultParserSpec extends Specification {

    @Shared
    def emptyNameList = new ArrayList<String>()

    @Shared
    def singleNameList = ["DAVID"]

    @Shared
    def multipleNameList = ["JIMMY",
                            "MICHAEL",
                            "DAVID",
                            "TIMMY",
                            "SARA",
                            "AMANDA",
                            "KYLE",
                            "MJ",
                            "LUCY",
                            "HENRY"]

    @Shared
    def multipleBadNameList = ["JIMMY",
                               "MICHAEL\"",
                               "\"DAVID\"",
                               "TI\"MMY",
                               "S\"A\"RA",
                               "AMANDA ",
                               "",
                               " ",
                               "\"",
                               "\"\"",
                               " KYLE",
                               "M J",
                               "\"LUCY "]
}
