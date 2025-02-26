package controller;

import model.Artikel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ArtikelRepository;
import service.ArtikelService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/myappdata/articles")
public class ArtikelController {

    private ArtikelService artikelService;

    public ArtikelController() {
        artikelService = new ArtikelService();
    }
    @GetMapping
    public ResponseEntity<List<Artikel>> getArtikels() {
        List<Artikel> artikelList = artikelService.readAll();
        return  new ResponseEntity<>(artikelList, HttpStatus.OK);
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<Artikel> getArtikel(@PathVariable long id) {
        Artikel artikel = artikelService.read(id);
        return  new ResponseEntity<>(artikel, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Artikel> delete(@PathVariable long id) {
        artikelService.delete(id);
        return  new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Artikel> add(@RequestBody Artikel request) {
        Artikel artikel = artikelService.add(request);
        return  new ResponseEntity<>(artikel, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Artikel request) {
        artikelService.update(request);
        return  new ResponseEntity(HttpStatus.OK);
    }
}
