package dev.app.artist.api.config;

import dev.app.artist.api.entity.Artist;
import dev.app.artist.api.service.ArtistService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anish Panthi
 */
@Configuration
@Log4j2
public class DataLoader implements CommandLineRunner {

  private final ArtistService artistService;

  public DataLoader(ArtistService artistService) {
    this.artistService = artistService;
  }

  @Override
  public void run(String... args) throws Exception {
    if (artistService.findAll().isEmpty()) {
      log.info("Creating default artist data");
      artistService.create(new Artist(null, "The Beatles", "Rock", "Liverpool"));
    }
  }
}
