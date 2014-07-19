package com.valerino.infinityjb;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * implements xposed on-load hooks
 * Created by valerino on 19/07/14.
 */
public class InfinityJb implements IXposedHookLoadPackage {
    private boolean _enableJb = false;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equalsIgnoreCase("it.mediaset.infinitytv")) {
            return;
        }

        // infinity is running!
        XposedBridge.log("InfinityTV is running");

        // patch rooted device check
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.utils.Utils", loadPackageParam.classLoader, "isRooted", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("isRooted() called, returning false");
                return false;
            }
        });

        // patch number of devices
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.net.DeviceListResponse", loadPackageParam.classLoader, "getMaxAllowedDevice", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getMaxAllowedDevice() called, return 99999");
                return 99999;
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.net.DeviceListResponse", loadPackageParam.classLoader, "getTotalDevice", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getTotalDevice() called, return 1");
                return 1;
            }
        });

        // patch authorization to view/download on everything
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getDWNPCTablet3G", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getDWNPCTablet3G() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getDWNPCTabletWIFI", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getDWNPCTabletWIFI() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getDWNSmartphone3G", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getDWNSmartPhone3G() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getDWNSmartphoneWIFI", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getDWNSmartPhoneWIFI() called, return '1'");
                return "1";
            }
        });

        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getSTRPCTablet3G", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getSTRPCTablet3G() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getSTRPCTabletWIFI", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getSTRPCTabletWIFI() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getSTRSmartphone3G", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getSTRSmartPhone3G() called, return '1'");
                return "s";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getSTRSmartphoneWIFI", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getSTRSmartPhoneWIFI() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getSTRTV", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getSTRTV() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.AreaContratto", loadPackageParam.classLoader, "getSTRTVHD", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getSTRTVHD() called, return '1'");
                return "1";
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.VariantsContentRights", loadPackageParam.classLoader, "getDwnNumber", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getDwnNumber() called, return 99999");
                return 99999;
            }
        });
        XposedHelpers.findAndHookMethod("it.mediaset.infinity.data.model.VariantsContentRights", loadPackageParam.classLoader, "getCanWatch", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                XposedBridge.log("getCanWatch() called, return 'Y'");
                return "Y";
            }
        });
    }
}
