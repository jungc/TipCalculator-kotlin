package com.theusualme.jungc.tipcalculator

/**
 * Created by jachoi on 10/10/17.
 */
interface Calculator {
    interface View {
        fun updatePriceDisplay(value: Double)
        fun updateTaxDollarDisplay(value: Double)
        fun updateTaxPercentDisplay(value: Double)
        fun updateTipDollarDisplay(value: Double)
        fun updateTipPercentDisplay(value: Double)
        fun updateTotalPriceDisplay(value: Double)
        fun updateSplitNDisplay(value: Double)
        fun updateSplitValueDisplay(value: Double)
    }

    interface Presenter {
        fun init()
        fun onAttach(view: View)
        fun onDetach()
        fun resetDisplay()
        fun onPriceChange(msg: String)
        fun onTaxPercentChange(msg: String)
        fun onTaxDollarChange(msg: String)
        fun onTipPercentChange(msg: String)
        fun onTipDollarChange(msg: String)
        fun onSplitNChange(msg: String)

        fun onResultAvailble(data: CalculatorData)
    }

    interface Model {
        fun init(presenter: Presenter)
        fun onPriceAvailable(value: Double)
        fun onTaxPercentAvailable(value: Double)
        fun onTaxDollarAvailable(value: Double)
        fun onTipPercentAvailable(value: Double)
        fun onTipDollarAvailable(value: Double)
        fun onSplitNAvailble(value: Double)
    }
}