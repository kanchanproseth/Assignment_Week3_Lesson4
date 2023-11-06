package com.cs473.mda.assignmentweek3lesson4.ui

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import com.cs473.mda.assignmentweek3lesson4.R


class MainActivity : AppCompatActivity() {

    private var tableLayout: TableLayout? = null
    private var versionEditText: EditText? = null
    private var codeNameEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

    }

    private fun setupView() {
        tableLayout = findViewById(R.id.table_layout)
        tableLayout!!.addView(createTableRow("Version", "Code Name"))
        versionEditText = findViewById(R.id.version_edit_text)
        codeNameEditText = findViewById(R.id.code_name_edit_text)
    }

    public fun onClick(view: View) {
        when(view.id) {
            R.id.add_button -> {
                if (!versionEditText!!.text.isEmpty() && !codeNameEditText!!.text.isEmpty()) {
                    tableLayout!!.addView(createTableRow(versionEditText!!.text.toString(), codeNameEditText!!.text.toString()))
                    versionEditText!!.text.clear()
                    codeNameEditText!!.text.clear()
                    dismissKeyboard()
                } else {
                    Toast.makeText(this, "Please enter value accordingly", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun dismissKeyboard() {
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }


    private fun createTableRow(title: String, description: String): TableRow {
        val tableRow = TableRow(this)
        val layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,10,10, 10)
        tableRow.layoutParams = layoutParams
        tableRow.addView(createTextViewItem(title), 0)
        tableRow.addView(createTextViewItem(description), 1)
        return tableRow
    }

    private fun createTextViewItem(text: String): TextView {
        val textViewLayoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        val textView = TextView(this);
        textView.setTextColor(Color.Black.hashCode())
        textView.layoutParams = textViewLayoutParams
        textView.text = text
        textView.setBackgroundResource(R.drawable.text_view_background_shape)

        return textView
    }
}