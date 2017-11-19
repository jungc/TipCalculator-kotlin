package com.theusualme.jungc.tipcalculator

/**
 * Created by jachoi on 11/18/17.
 */
data class CalculatorData(var price: Double = 0.0,
                          var taxPercent: Double = 0.0,
                          var taxDollar: Double = 0.0,
                          var tipPercent: Double = 0.0,
                          var tipDollar: Double = 0.0,
                          var total: Double = 0.0,
                          var splitN: Double = 0.0,
                          var splitValue: Double = 0.0)