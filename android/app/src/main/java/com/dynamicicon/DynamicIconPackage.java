package com.dynamicicon;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Exposes {@link DynamicIconModule} to JavaScript.
 * One {@link ReactPackage} can expose multiple {@link NativeModule}s.
 */
class DynamicIconPackage
        implements ReactPackage {
    @Override
    public List < NativeModule > createNativeModules(ReactApplicationContext reactContext) {
        List < NativeModule > modules = new ArrayList < > ();
        modules.add(new DynamicIconModule(reactContext));
        return modules;
    }
    @Override
    public List < ViewManager > createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}