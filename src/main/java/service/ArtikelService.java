package service;


import model.Artikel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArtikelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikelService {
    @Autowired
    private ArtikelRepository artikelRepository;



    public Artikel add(Artikel artikel) {
if (artikelRepository.existsById(artikel.getId())) {
    return null;
}
return artikelRepository.save(artikel);

    }

    public Artikel update(Artikel artikel) {
      if (!artikelRepository.existsById(artikel.getId())) {
          return null;
      }
      return artikelRepository.save(artikel);
    }

    public void delete(long id){
      if (artikelRepository.existsById(id)) {
          artikelRepository.deleteById(id);
      }
    }

    public Artikel read(long id) {
        Optional<Artikel> artikel = artikelRepository.findById(id);
        if (artikel.isEmpty()) {
            return null;
        }
        return artikel.get();
    }

    public List<Artikel> readAll() {
        return artikelRepository.findAll();
    }
}
