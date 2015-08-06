package com.idtechproducts;

import org.apache.cordova.*;
import org.json.*;

public class IDTechPlugin extends CordovaPlugin {
    private UsbHidCardInfoProvider _reader;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startCardReader")) {
            _reader = new UsbHidCardInfoProvider(this.webView.getContext(), callbackContext);
            return true;
        }
        else if (action.equals("stopCardReader")) {
            if (_reader != null) {
                _reader.dispose();
                _reader = null;
            }
            else {
              System.out.println("Missing UsbHidCardInfoProvider");
            }

            callbackContext.success();
            return true;

        } else {
            return false;
        }
    }
}
