/**

	This code is generated.
	For more information see generation/README.md.
*/



class DetoxViewActions {
  static click() {
    return {
      target: {
        type: "Class",
        value: "com.wix.detox.espresso.DetoxViewActions"
      },
      method: "click",
      args: []
    };
  }

  static typeText(text) {
    if (typeof text !== "string") throw new Error("text should be a string, but got " + (text + (" (" + (typeof text + ")"))));
    return {
      target: {
        type: "Class",
        value: "com.wix.detox.espresso.DetoxViewActions"
      },
      method: "typeText",
      args: [text]
    };
  }

  static setPickerToValue(value) {
    if (typeof value !== "string") throw new Error("value should be a string, but got " + (value + (" (" + (typeof value + ")"))));
    return {
      target: {
        type: "Class",
        value: "com.wix.detox.espresso.DetoxViewActions"
      },
      method: "setPickerToValue",
      args: [value]
    };
  }

  static setDatePickerDateAction(date, format) {
    if (typeof date !== "string") throw new Error("date should be a string, but got " + (date + (" (" + (typeof date + ")"))));
    if (typeof format !== "string") throw new Error("format should be a string, but got " + (format + (" (" + (typeof format + ")"))));
    return {
      target: {
        type: "Class",
        value: "com.wix.detox.espresso.DetoxViewActions"
      },
      method: "setDatePickerDateAction",
      args: [date, format]
    };
  }

}

module.exports = DetoxViewActions;
