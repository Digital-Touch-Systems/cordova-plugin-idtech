package com.idtechproducts;

import android.content.Context;

import com.idtechproducts.usbhid.sdk.*;

import org.apache.cordova.CallbackContext;

public class UsbHidCardInfoProvider {
    private CallbackContext _callbackContext;
    private IDTechUsbHid _reader;

    public UsbHidCardInfoProvider(Context context, CallbackContext callbackContext) {
        _callbackContext = callbackContext;

        _reader = new IDTechUsbHid(new UsbHidListener(this), context, IDTechUsbHid.ReaderType.SecureMag);
        _reader.registerListen();
        _reader.setSaveLogEnable(true);
    }

    public void dispose() {
        if (_reader.isReaderConnected())
          _reader.stopSwipeCard();

        _reader.unregisterListen();
        _reader = null;
    }

    public void startSwipeCard() {
      _reader.startSwipeCard();
    }

    public void cardReadResult(String data) {
        _callbackContext.success(data);
    }

    public void cardReadError(CardReadErrorCause cause) {
        _callbackContext.error(cause.toString());
    }
}
