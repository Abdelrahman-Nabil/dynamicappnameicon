package com.dynamicicon;


import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Expose Java to JavaScript. Methods annotated with {@link ReactMethod} are
 * exposed.
 */
class DynamicIconModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactContext;
    DynamicIconModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    /**
     * @return the name of this module. This will be the name used to
     *         {@code require()} this module from JavaScript.
     */
    @Override
    public String getName() {
        return "dynamicicon";
    }

    @ReactMethod
    private void changeIcon(Integer id) {

        PackageManager manager= reactContext.getPackageManager();

        //disable all icons
        reactContext.getPackageManager().setComponentEnabledSetting(
                MainActivity.getActivity().getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        //enable targeted icon
        switch (id) {
            case 1:
                manager.setComponentEnabledSetting(new ComponentName(MainActivity.getActivity(),"com.dynamicicon.MainActivityAlias1")
                        ,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
            break;
            case 2:
                manager.setComponentEnabledSetting(new ComponentName(MainActivity.getActivity(),"com.dynamicicon.MainActivityAlias2")
                        ,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
            break;
            case 3:
                manager.setComponentEnabledSetting(new ComponentName(MainActivity.getActivity(),"com.dynamicicon.MainActivityAlias3")
                        ,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
            break;
            default:
                manager.setComponentEnabledSetting(new ComponentName(MainActivity.getActivity(),"com.dynamicicon.MainActivityAlias1")
                        ,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
        }
        Toast.makeText(MainActivity.getActivity(),"Icon changed" , Toast.LENGTH_LONG).show();
    }
    @ReactMethod
    private void newIcon() {

        // enable old icon
        PackageManager manager= reactContext.getPackageManager();
        manager.setComponentEnabledSetting(new ComponentName(MainActivity.getActivity(),"com.dynamicicon")
                ,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);

        // enable new icon
        manager.setComponentEnabledSetting(new ComponentName(MainActivity.getActivity(),"com.com.dynamicicon")
                ,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
        Toast.makeText(MainActivity.getActivity(),"Icon changed" ,Toast.LENGTH_LONG).show();
    }

}