package academy.devdojo.springboot2.controller;

import java.util.Optional;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;

import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping
    public List<Anime> getAnimes(){
        return animeRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Anime> getAnimeById(@PathVariable Long id) {
        return animeRepository.findById(id);
    }

    @PostMapping
    public Anime createAnime(@RequestBody Anime anime) {
        return animeRepository.save(anime);
    }

    @PutMapping("/{id}")
    public Anime updateAnime(@PathVariable("id") Long id, @RequestBody Anime anime) {
        return animeRepository.save(anime);
    }

    @DeleteMapping("/{id}")
    public void deleteAnime(@PathVariable Long id) {
        animeRepository.delete(animeRepository.findById(id).get());
    }


}
