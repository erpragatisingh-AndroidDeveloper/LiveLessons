LOCAL_PATH := $(call my-dir)
 
include $(CLEAR_VARS)
 
# Here we give our module name and source file(s)
LOCAL_MODULE    := sqlndk
LOCAL_SRC_FILES := sqlndk.c
 
include $(BUILD_SHARED_LIBRARY)