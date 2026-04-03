import jpype
# 실제 jvm.dll 또는 libjvm.so 경로를 직접 입력
jpype.startJVM(r"C:\Program Files\Java\jdk-21.0.10\bin\server\jvm.dll", convertStrings=True)