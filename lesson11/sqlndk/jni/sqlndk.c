#include <string.h>
#include <jni.h>
#include <unistd.h>

jstring Java_com_riis_sqlndk_MainActivity_invokeNativeFunction(JNIEnv* env, jobject javaThis) {

	return (*env)->NewStringUTF(env, (char *)getlogin());

}
