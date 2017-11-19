package com.theusualme.jungc.tipcalculator

/**
 * Created by jachoi on 10/10/17.
 */
class CalculatorPresenter : Calculator.Presenter {

    var view: Calculator.View? = null
    lateinit var calculator: Calculator.Model
    var currentData: CalculatorData? = null

    override fun init() {
        calculator = CalculatorModel()
        calculator.init(this)
    }

    override fun onAttach(view: Calculator.View) {
        this.view = view;
        if (currentData != null) {
            onResultAvailble(currentData!!)
        } else {
            onResultAvailble(CalculatorData())
        }
    }

    override fun onDetach() {
        view = null
    }

    override fun resetDisplay() {
    }

    override fun onPriceChange(msg: String) {
        try {
            calculator.onPriceAvailable(msg.toDouble())
        } catch (e: Exception) {
            calculator.onPriceAvailable(0.0)
        }
    }

    override fun onTaxPercentChange(msg: String) {
        try {
            calculator.onTaxPercentAvailable(msg.toDouble())
        } catch (e: Exception) {
            calculator.onTaxPercentAvailable(0.0)
        }
    }

    override fun onTaxDollarChange(msg: String) {
        try {
            calculator.onTaxDollarAvailable(msg.toDouble())
        } catch (e: Exception) {
            calculator.onTaxDollarAvailable(0.0)
        }
    }

    override fun onTipPercentChange(msg: String) {
        try {
            calculator.onTipPercentAvailable(msg.toDouble())
        } catch (e: Exception) {
            calculator.onTipPercentAvailable(0.0)
        }
    }

    override fun onTipDollarChange(msg: String) {
        try {
            calculator.onTipDollarAvailable(msg.toDouble())
        } catch (e: Exception) {
            calculator.onTipDollarAvailable(0.0)
        }
    }

    override fun onSplitNChange(msg: String) {
        try {
            calculator.onSplitNAvailble(msg.toDouble())
        } catch (e: Exception) {
            calculator.onSplitNAvailble(0.0)
        }
    }

    override fun onResultAvailble(data: CalculatorData) {
        currentData = data
        view?.updatePriceDisplay(data.price)
        view?.updateTaxPercentDisplay(data.taxPercent)
        view?.updateTaxDollarDisplay(data.taxDollar)
        view?.updateTipPercentDisplay(data.tipPercent)
        view?.updateTipDollarDisplay(data.tipDollar)
        view?.updateTotalPriceDisplay(data.total)
        view?.updateSplitNDisplay(data.splitN)
        view?.updateSplitValueDisplay(data.splitValue)
    }
}