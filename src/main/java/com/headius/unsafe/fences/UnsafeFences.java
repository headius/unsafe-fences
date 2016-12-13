package com.headius.unsafe.fences;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UnsafeFences {
    public static final boolean SUPPORTS_FENCES = supportsFences();

    public static void fullFence() {
        U.fullFence();
    }

    public static void loadFence() {
        U.loadFence();
    }

    public static void storeFence() {
        U.storeFence();
    }

    private UnsafeFences(){}

    private static final sun.misc.Unsafe U = loadUnsafe();

    private static sun.misc.Unsafe loadUnsafe() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (sun.misc.Unsafe) f.get(null);
        } catch (Exception e) {
            return null;
        } catch (NoClassDefFoundError ncdfe) {
            // Google AppEngine raises NCDFE for Unsafe rather than CNFE
            return null;
        }
    }

    private static boolean supportsFences() {
        if(U == null)
            return false;
        try {
            Method m = U.getClass().getDeclaredMethod("fullFence");
            if(m != null)
                return true;
        } catch (Exception e) {
        }
        return false;
    }
}
