# 1. 자바 경로 확인
import os
print(f"현재 JAVA_HOME: {os.environ.get('JAVA_HOME')}")

# 2. JPype 임포트 테스트 (여기서 멈추면 JPype 문제)
try:
    import jpype
    print(f"JPype 버전: {jpype.__version__}")
    print("JPype 임포트 성공!")
except ImportError as e:
    print(f"JPype 임포트 실패: {e}")

# 3. KoNLPy 임포트 테스트
try:
    import konlpy
    print("KoNLPy 임포트 성공!")
except Exception as e:
    print(f"KoNLPy 에러 발생: {e}")