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

  static setDatePickerDateAction(day, month, year) {
    if (typeof day !== "number") throw new Error("day should be a number, but got " + (day + (" (" + (typeof day + ")"))));
    if (typeof month !== "number") throw new Error("month should be a number, but got " + (month + (" (" + (typeof month + ")"))));
    if (typeof year !== "number") throw new Error("year should be a number, but got " + (year + (" (" + (typeof year + ")"))));
    return {
      target: {
        type: "Class",
        value: "com.wix.detox.espresso.DetoxViewActions"
      },
      method: "setDatePickerDateAction",
      args: [{
        type: "Integer",
        value: day
      }, {
        type: "Integer",
        value: month
      }, {
        type: "Integer",
        value: year
      }]
    };
  }

}

module.exports = DetoxViewActions;