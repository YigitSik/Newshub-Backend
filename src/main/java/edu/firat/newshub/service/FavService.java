package edu.firat.newshub.service;

import edu.firat.newshub.model.Favourites;
import edu.firat.newshub.model.User;
import edu.firat.newshub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavService {

    @Autowired
    private UserRepository userRepo;


    public Favourites savefav(String username, Favourites f) {
        User user = userRepo.findByUsername(username);
        List<Favourites> articles=new ArrayList<Favourites>(user.getFavourites());
        articles.add(f);
        user.setFavourites(articles);
        userRepo.save(user);
        return f;
    }

    public Favourites deleteFav(String username,int id) {
        User user = userRepo.findByUsername(username);
        List<Favourites> articles=new ArrayList<Favourites>(user.getFavourites());
        Favourites fav=new Favourites();

        for(Favourites favs: articles) {
            if(favs.getFavoriteId()==id) {
                System.out.println(id);
                fav=favs;
                articles.remove(fav);
                user.setFavourites(articles);
                userRepo.save(user);
                break;
            }
        }


        return fav;
    }

    public void emptyFavourites(String username) {
        User user = userRepo.findByUsername(username);
        user.setFavourites(new ArrayList<Favourites>());
    }


    public List<Favourites> getAllFav(String username){
        User user = userRepo.findByUsername(username);
        return user.getFavourites();
    }

}
