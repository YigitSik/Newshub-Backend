package edu.firat.newshub.controller;

import edu.firat.newshub.model.Favourites;
import edu.firat.newshub.security.JwtUtil;
import edu.firat.newshub.service.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/favourite")
public class FavController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public FavService service;

    @PostMapping("/add")
    public ResponseEntity<?> addToFavourite(@RequestBody Favourites article,
                                            @RequestHeader("Authorization") String authorizationHeader) {
        String username = getUsername(authorizationHeader);
        return new ResponseEntity<Favourites>(service.savefav(username, article), HttpStatus.OK);
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteFavourites(@PathVariable int id,
                                              @RequestHeader("Authorization") String authorizationHeader) {
        String username = getUsername(authorizationHeader);
        return new ResponseEntity<Favourites>(service.deleteFav(username, id), HttpStatus.OK);
    }


    @GetMapping("get/all")
    public ResponseEntity<?> getFavourites(@RequestHeader("Authorization") String authorizationHeader) {
        String username = getUsername(authorizationHeader);
        List<Favourites> articles = service.getAllFav(username);
        return new ResponseEntity<List<Favourites>>(articles, HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> emptyFav(@RequestHeader("Authorization") String authorizationHeader) {
        ResponseEntity<String> response;
        try {
            String username = getUsername(authorizationHeader);
            service.emptyFavourites(username);
            response = new ResponseEntity<String>("Favourites emptied successfully.", HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<String>("Error occured while emptying the Favourites", HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    public String getUsername(String authorizationHeader) {
        return jwtUtil.extractUsername(authorizationHeader.substring(7));
    }

}
