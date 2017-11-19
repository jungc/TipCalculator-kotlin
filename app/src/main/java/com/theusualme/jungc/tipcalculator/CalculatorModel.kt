package com.theusualme.jungc.tipcalculator

/**
 * Created by jachoi on 11/18/17.
 */

class CalculatorModel: Calculator.Model {
    lateinit var data: CalculatorData
    lateinit var presenter: Calculator.Presenter

    override fun init(presenter: Calculator.Presenter) {
        this.presenter = presenter
        data = CalculatorData()
    }

    override fun onPriceAvailable(value: Double) {
        data.price = value
        data.taxDollar = data.price * data.taxPercent
        data.tipDollar = data.price * data.tipPercent
        data.total = data.price + data.taxDollar + data.tipDollar
        if (data.splitN != 0.0) {
            data.splitValue = data.total/data.splitN
        }
        presenter.onResultAvailble(data)
    }

    override fun onTaxPercentAvailable(value: Double) {
        data.taxPercent = value/100.0
        onPriceAvailable(data.price)
    }

    override fun onTaxDollarAvailable(value: Double) {
        if (data.price != 0.0) {
            data.taxPercent = data.taxDollar / data.price
        } else {
            data.taxPercent = 0.0
        }
        onPriceAvailable(data.price)
    }

    override fun onTipPercentAvailable(value: Double) {
        data.tipPercent = value/100.0
        onPriceAvailable(data.price)
    }

    override fun onTipDollarAvailable(value: Double) {
        if (data.price != 0.0) {
            data.tipPercent = data.tipDollar / data.price
        } else {
            data.tipPercent = 0.0
        }
        onPriceAvailable(data.price)
        data.tipDollar = value
    }

    override fun onSplitNAvailble(value: Double) {
        data.splitN = value
        onPriceAvailable(data.price)
    }
}