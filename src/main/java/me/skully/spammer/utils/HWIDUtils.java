package me.skully.spammer.utils;

import net.minecraft.client.Minecraft;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.security.MessageDigest;

public class HWIDUtils {

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "SPAMMER: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void check() {
        try {
            String key;
            HttpsURLConnection urlConnection = (HttpsURLConnection) new URL("https://pastebin.com/raw/e68cYDPK").openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            while ((key = buffer.readLine()) != null) {
                if (key.equals(getHWID())) {
                    infoBox("HWID Protection accepted \nYour HWID in database", "HWID Protection");
                    return;
                }
            }
                infoBox(getHWID() + "\nfor try hack my app, to get banned",getHWID());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(getHWID()), null);
            Desktop desktop = Desktop.getDesktop();
                 if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("https://t.me/SkullYS0"));
                }
                Minecraft.getMinecraft().shutdown();
            buffer.close();
        } catch (Exception e) {
            infoBox(getHWID() + "\nThis is your HWID\nAPP have error, please send this to the developer (TG - SkullYS0)","HWID ERROR");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(getHWID()), null);
        }
    }

    public static String getHWID() {
        try{
            String toEncrypt =  System.getenv("COMPUTERNAME") + System.getProperty("user.name") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_LEVEL");
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toEncrypt.getBytes());
            StringBuffer hexString = new StringBuffer();

            byte byteData[] = md.digest();

            for (byte aByteData : byteData) {
                String hex = Integer.toHexString(0xff & aByteData);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

}
