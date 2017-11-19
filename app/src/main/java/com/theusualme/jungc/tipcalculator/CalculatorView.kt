package com.theusualme.jungc.tipcalculator

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.calculator.*

class CalculatorView : Fragment(), Calculator.View {

    lateinit var presenter: Calculator.Presenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CalculatorPresenter()
        presenter.init()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.calculator, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editFields: List<EditText?> = listOf(price_field, tax_percent_field, tax_dollar_field, tip_percent_field, tip_dollar_field, split_n_field)
        for (editField in editFields) {
            editField?.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    when (editField?.id) {
                        R.id.price_field -> { presenter.onPriceChange(s.toString()) }
                        R.id.tax_percent_field -> { presenter.onTaxPercentChange(s.toString()) }
                        R.id.tax_dollar_field -> { presenter.onTaxDollarChange(s.toString()) }
                        R.id.tip_percent_field -> { presenter.onTipPercentChange(s.toString()) }
                        R.id.tip_dollar_field -> { presenter.onTipDollarChange(s.toString()) }
                        R.id.split_n_field -> { presenter.onSplitNChange(s.toString()) }
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.onAttach(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.onDetach()
    }

    override fun updatePriceDisplay(value: Double) {
        price_display?.setText(getString(R.string.price_text, value))
    }

    override fun updateTaxDollarDisplay(value: Double) {
        tax_dollar_display?.setText(getString(R.string.tax_dollar_text, value))
    }

    override fun updateTaxPercentDisplay(value: Double) {
        tax_percent_display?.setText(getString(R.string.tax_percent_text, value))
    }

    override fun updateTipDollarDisplay(value: Double) {
        tip_dollar_display?.setText(getString(R.string.tip_dollar_text, value))
    }

    override fun updateTipPercentDisplay(value: Double) {
        tip_percent_display?.setText(getString(R.string.tip_percent_text, value))
    }

    override fun updateTotalPriceDisplay(value: Double) {
        total_price_display?.setText(getString(R.string.total_price_text, value))
    }

    override fun updateSplitNDisplay(value: Double) {
        split_n_display?.setText(getString(R.string.split_n_text, value))
    }

    override fun updateSplitValueDisplay(value: Double) {
        split_value_display?.setText(getString(R.string.split_value_text, value))
    }
}