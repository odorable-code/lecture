package kr.hi.fastapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {

    private final WebClient webClient;

    @PostMapping("/image")
    public String image(
        @RequestParam("image") MultipartFile file
    ) {
        MultipartBodyBuilder bb = new MultipartBodyBuilder();
        // 보낼 데이터를 추가
        bb.part("msg","데이터 갔나요?");
        bb.part("file", file.getResource());
        System.out.println(file.getOriginalFilename());
        return webClient.post().uri("/image" )
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bb.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

    @PostMapping("/text")
    public String text(
            @RequestParam("msg") String msg
    ) {
        MultipartBodyBuilder bb = new MultipartBodyBuilder();
        // 보낼 데이터를 추가
        bb.part("msg",msg);
        return webClient.post().uri("/text")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bb.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

    @GetMapping("/movies")
    public String movies() {
        return webClient.get().uri("/movies")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @GetMapping("/movies/recommend")
    public String moviesRecommend(
            @RequestParam("title") String title,
            @RequestParam("type") String type
    ) {
        System.out.println(type);
        MultipartBodyBuilder bb = new MultipartBodyBuilder();
        bb.part("title", title);
        bb.part("type", type);
        return webClient.post().uri("/movies/recommend" )
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bb.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @PostMapping("/fashion/predict")
    public String fashionPredict(
            @RequestParam("file") MultipartFile file
    ) {
        MultipartBodyBuilder bb = new MultipartBodyBuilder();
        // 보낼 데이터를 추가
        bb.part("file", file.getResource());

        return webClient.post().uri("/fashion/predict" )
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(bb.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}