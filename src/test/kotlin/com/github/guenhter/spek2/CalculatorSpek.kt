package com.github.guenhter.spek2

import com.github.guenhter.CalculatorImpl
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


class CalculatorSpek : Spek({
    describe("a calculator") {
        val calculator = CalculatorImpl()

        context("adding two numbers") {
            it("should be a positive sum when summing two positive numbers") {
                calculator.add(1, 2) `should be equal to` 3
            }
            it("should be a negative number when one number is negative and absolute-bigger than the other") {
                calculator.add(1, -2) `should be equal to` -1
            }
            it("should be a positive number when one number is negative and absolute-smaller than the other") {
                calculator.add(2, -1) `should be equal to` 1
            }
            it("should be zero when one number is negative and absolute-equal to the positive one") {
                calculator.add(2, -2) `should be equal to` 0
            }
        }

        context("subtracting two numbers") {
            it("should be a positive sum when subtracting a negative number from a positive number") {
                calculator.subtract(2, -2) `should be equal to` 4
            }
            it("should be a positive number when subtracting a positive number from a negative number") {
                calculator.subtract(-2, 2) `should be equal to` -4
            }
        }
    }
})

// B - Assertions

class AssertionsSpek : Spek({
    describe("a calculator") {
        val calculator = CalculatorImpl()

        it("check some assertions") {
            assertEquals(3, calculator.add(1, 2))

            calculator.add(1, 2) `should be equal to` 3

        }
    }
})


//// C multiple values
//
// TODO not yet defined: https://spekframework.org/migration/#table-driven
//
//object CalculatorDataFixture {
//    val additionData = arrayOf(
//            data(4, 2, expected = 6),
//            data(1, 3, expected = 4),
//            data(5, 7, expected = 12),
//            data(-3, 3, expected = 0)
//    )
//    val subtractData = arrayOf(
//            data(4, 2, expected = 2),
//            data(1, 3, expected = -2),
//            data(5, 7, expected = -2),
//            data(-3, 3, expected = -6)
//    )
//    val divideData = arrayOf(
//            data(4, 2, expected = 2)
//    )
//}
//
//
//class CalculatorSpekDataTable : Spek({
//    describe("a calculator") {
//        val calculator = CalculatorImpl()
//
//        on_data("addition %s and %s", with = *additionData) { num1, num2, expected ->
//            it("returns $expected") {
//                calculator.add(num1, num2) `should be equal to` expected
//            }
//        }
//
//        on_data("subtract %s and %s", with = *subtractData) { num1, num2, expected ->
//            it("returns $expected") {
//                calculator.subtract(num1, num2) `should be equal to` expected
//            }
//        }
//
//        on_data("divide %s and %s", with = *divideData) { num1, num2, expected ->
//            it("returns $expected") {
//                calculator.subtract(num1, num2) `should be equal to` expected
//            }
//        }
//    }
//})
