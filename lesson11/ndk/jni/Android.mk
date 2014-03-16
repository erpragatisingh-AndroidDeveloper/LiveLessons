LOCAL_PATH := $(call my-dir)
 
include $(CLEAR_VARS)
 
# Here we give our module name and source file(s)
LOCAL_MODULE    := ndk
LOCAL_SRC_FILES := ndk.c
 
include $(BUILD_SHARED_LIBRARY)