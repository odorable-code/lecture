from fastapi import FastAPI, UploadFile, Form
import uvicorn
import cv2
import mnist_learning as ml
import text_mining as tm
import movie_learning as mo
import numpy as np
import pandas as pd
import fashion as fa

app = FastAPI()  
 
@app.get("/")
async def index():
    return {'msg': 'Hello, World!'}
                 
@app.post("/image")
async def text(file: UploadFile=Form(...)):
    #  파일을 바이너리데이터 로 읽어옴
    contents = await file.read()
    # 바이너리를 numpy  배열로 변환
    np_arr = np.frombuffer(contents, np.uint8)
    img = cv2.imdecode(np_arr, cv2.IMREAD_GRAYSCALE)
    res = ml.predict_from_upload_file(img, 28, 28)
    print(f'URL : /image')
    # 배열을 이미지로 디코딩
    return {"msg": res}


@app.post("/text")
async def text (msg: str=Form(...)):
    res = tm.predict(msg)
    return { 'msg' : '긍정' if res else '부정' }

@app.get("/movies")
async def movies():
    return mo.get_movies()

@app.post("/movies/recommend")
async def movies_recommend(title: str = Form(...), type: str = Form(...)):
    recommender = mo.MovieRecommender()
    # recommender.load_model(f'movie_model_{type}.pkl')
    # l = recommender.get_recommendations_movies(type, title)
    if type == 'content':
        recommender.load_model(f'movie_model_content.pkl')
        l = recommender.get_recommendations_movies('content', title)
    elif type == 'etc':
        recommender.load_model(f'movie_model_etc.pkl')
        l = recommender.get_recommendations_movies('etc', title)
    elif type == 'director':
        l = recommender.get_recommendations_movies('director', title)
        recommender.load_model('movie_model_director.pkl')
    # 영화 제목 리스트를 딕셔너리로 변환해서 전송하기 위해
    # 제목 리스트를 데이터프레임으로 변환
    df = pd.DataFrame({'title' : l})
    # 데이터 프레임을 제목만 딕셔너리로 변환
    return df[['title']].to_dict(orient='records')
    
@app.post('/fashion/predict')
async def fashion_predict(file: UploadFile = Form(...)):
    contents = await file.read()
    # 바이너리를 numpy  배열로 변환
    np_arr = np.frombuffer(contents, np.uint8)
    img = cv2.imdecode(np_arr, cv2.IMREAD_GRAYSCALE)
    res = fa.predict_from_upload_file(img)
    return {'msg': res}

if __name__ == "__main__":
    # reload=True 사용시 주의사항
    # 자동으로 변경 사항을 적용하면 시간이 오래걸리는 경우 안 쓰는 것이 좋음
    uvicorn.run('main:app', port=8000, reload=True)