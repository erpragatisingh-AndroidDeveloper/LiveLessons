#include <string.h>
#include <jni.h>

jstring Java_com_riis_ndk_MainActivity_invokeNativeFunction(JNIEnv* env, jobject javaThis) {

	return (*env)->NewStringUTF(env, "W12345");

}
