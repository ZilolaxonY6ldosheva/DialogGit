# DialogGit
>Getting started
### Gradle Dependency
* Add the JitPack repository to your project's build.gradle file

    - For Gradle version 5.x.x or less
    ```
    allprojects {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
    ```
    - For Gradle version 6.x.x and above, in settings.gradle file inside `pluginManagement` block
    ```
      pluginManagement {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
    ```

* Add the dependency in your app's build.gradle file

```
dependencies {
	implementation 'com.github.ZilolaxonY6ldosheva:DialogGit:1.0.0'
}
```

### All Components
------------------------

| Component | Description |
| --- | --- | 
| `BasicDialog`| Simple alert dialog with: `Title, Main text, Negative and Positive Button` |  
| `CheckBoxDialog`| `CheckBox dialog with: `Title of checkbox value` |
| `DateAndTimeDialog`| Date and Time picker dialog |
| `WifiDIalog`| Wi-fi bottomsheetDialog with : `Wi-fi name, Signal, SSID, Security` |
| `Colorialog`| ColorPicker bottomSheetDialog |  
### Usage
------------------------
>Basic dialog
```
  private fun basicDialog() {
        val basicDialog = BasicDialog(this)
        basicDialog.createDialog(
            title = "Lorem ipsum?",
            mainTxt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            okBtnTxt = "Agree",
            cancelBtnTxt = "Disagree"
        )
        basicDialog.show(supportFragmentManager, "basic_dialog")
        basicDialog.setOnButtonClickListener(object : BasicDialog.BasicDialogListeners {
            override fun okButtonClicked() {
                Toast.makeText(this@MainActivity, "DISAGREE", Toast.LENGTH_SHORT).show()

            }

            override fun cancelButtonClicked() {
                Toast.makeText(this@MainActivity, "AGREE", Toast.LENGTH_SHORT).show()

            }

        })
    }
```
>CheckBox Dialog
```
 private fun openCheckBoxDialog() {
        val list = arrayListOf("Twitter", "Google", "Instagram", "Facebook")

        val checkBoxDialog = CheckBoxDialog(list, "Social medias")
        checkBoxDialog.setOnChooseClickListener(object : CheckBoxDialog.OnChooseClickListener {
            override fun chooseClick(chosenList: List<String>) {
                val stringBuilder = StringBuilder()
                for (i in list) {
                    stringBuilder.append("$i ")
                }
                Toast.makeText(this@MainActivity, stringBuilder.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        })
        checkBoxDialog.show(supportFragmentManager, "checkbox_dialog")
    }
```

>Date and Time Picker Dialog
```
 private fun dateDialog() {
        val dialog = DateAndTimeDialog()
        dialog.show(supportFragmentManager, "date_dialog")
        dialog.setOnOkButtonClicked(object : DateAndTimeDialog.OnButtonClicked {
            override fun OnOkButtonClicked(datePicker: DatePicker, timePicker: TimePicker) {
                val date = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}  " +
                        "${timePicker.hour}:${timePicker.minute}"
                Toast.makeText(this@MainActivity, date, Toast.LENGTH_SHORT).show()
            }


        })
    }
```

>Wi-fi BottomSheet Dialog
```
private fun wifiDialog() {
        val dialog = WifiDialog()
        dialog.show(supportFragmentManager, "wifi_dialog")
        dialog.createDialog("Google wifi", "Pixel 2 A", "i929uui4ui", "Wpa2")
        dialog.setonButtonsCLickedListener(object : WifiDialog.WiFiDialogListeners {
            override fun okButtonClicked(password: String) {
                Toast.makeText(this@MainActivity, "$password", Toast.LENGTH_SHORT).show()
            }
            override fun cancelButtonClicked() {}
        })
```

>Color picker bottomSheet Dialog
```
private fun colorDialog() {
        val dialog = ColorDialog()
        dialog.show(supportFragmentManager, "color_dialog")
        dialog.setOnColorSelectedListener(object : ColorDialog.OnColorSelectListener {
            override fun OnColorSelected(color: Int) {
                binding.colorsheetDialog.setBackgroundColor(color)
            }

        })
    }
```
