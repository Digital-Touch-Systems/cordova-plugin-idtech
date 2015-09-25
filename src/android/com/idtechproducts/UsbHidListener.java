package com.idtechproducts;

import com.idtechproducts.usbhid.sdk.*;

import java.nio.charset.StandardCharsets;

public class UsbHidListener implements IDTechUsbHidMsg {
    private UsbHidCardInfoProvider _provider;

    public UsbHidListener(UsbHidCardInfoProvider provider) {
        _provider = provider;
    }

    public void onReceiveMsgCardData(byte[] bytes)
    {
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgCardData: " + bytes.length);

        _provider.cardReadResult(content);
    }

    public void onReceiveMsgCommandResult(int p0, byte[] bytes)
    {
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgCommandResult: " + p0 + " - " + content);
    }

    public void onReceiveMsgCommandTimeout()
    {
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgCommandTimeout");
    }

    public void onReceiveMsgConnected()
    {
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgConnected");
        
        _provider.startSwipeCard();
    }

    public void onReceiveMsgDisconnected()
    {
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgDisconnected");
    }

    public void onReceiveMsgFailureInfo(int p0)
    {
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgFailureInfo: " + p0);
    }

    public void onReceiveMsgSwipeTimeout()
    {
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgSwipeTimeout");

        _provider.cardReadError(CardReadErrorCause.ConnectTimeout);
    }

    public void onReceiveMsgToSwipeCard()
    {
        System.out.println("UsbHidCardInfoProvider: OnReceiveMsgToSwipeCard");
    }
}
