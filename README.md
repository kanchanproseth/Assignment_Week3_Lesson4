# Assignment_Week3_Lesson4

Course: Mobile Device Application CS473

Assignment Name: Assignment Week 3 Lesson 4




### App Flow

#### App started with no input any value
![alt text](https://github.com/kanchanproseth/Assignment_Week3_Lesson4/blob/main/screenshot/no_input.png?raw=true)

#### When user input data and click add button
![alt text](https://github.com/kanchanproseth/Assignment_Week3_Lesson4/blob/main/screenshot/input_value.png?raw=true)

#### After click add, dismiss keyboard and clear text
![alt text](https://github.com/kanchanproseth/Assignment_Week3_Lesson4/blob/main/screenshot/dismiss.png?raw=true)


#### view declaration 

```kotlin
    private var tableLayout: TableLayout? = null
    private var versionEditText: EditText? = null
    private var codeNameEditText: EditText? = null
```

#### onCreate Setup View

```kotlin
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
```


#### onClick add row, clear edit text and dismiss. if no input data, show toast message.

```kotlin
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
```

#### dismissKeyboard Function

```kotlin
   private fun dismissKeyboard() {
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
```

#### createTableRow Function

```kotlin
  private fun createTableRow(title: String, description: String): TableRow {
        val tableRow = TableRow(this)
        val layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,10,10, 10)
        tableRow.layoutParams = layoutParams
        tableRow.addView(createTextViewItem(title), 0)
        tableRow.addView(createTextViewItem(description), 1)
        return tableRow
    }
```


#### createTextViewItem Function

```kotlin
    private fun createTextViewItem(text: String): TextView {
        val textViewLayoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
        val textView = TextView(this);
        textView.setTextColor(Color.Black.hashCode())
        textView.layoutParams = textViewLayoutParams
        textView.text = text
        textView.setBackgroundResource(R.drawable.text_view_background_shape)

        return textView
    }
```



