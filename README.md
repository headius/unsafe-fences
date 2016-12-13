unsafe-fences
=============

This library is very simple: it just provides a shim around the Java 8 Unsafe
methods used for memory fencing. Because these methods do not exist in the
Java 6 and Java 7 Unsafe, this library allows compiling those calls with
a provided boolean guard.

This library must be built on Java 8 or a version of Java that has the three
fence methods: fullFence, storeFence, and loadFence.

Usage
-----

Simply use com.headius.unsafe.fences.UnsafeFences.SUPPORTS_FENCES and the
shim *Fence methods to call the fence API safely across Java versions.
