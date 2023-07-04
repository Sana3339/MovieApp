package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MovieController {

  @Autowired
  private BestMovieService bestMovieService;

  @Autowired
  private SessionFactory sessionFactory;

  @RequestMapping("/")
  public String getIndexPage() {
    return "index";
  }

  @RequestMapping("/bestMovie")
  public String getBestMoviePage(Model model) {
    model.addAttribute("bestMovie", bestMovieService.getBestMovie().getTitle());
      return "bestMovie";
      }

  @RequestMapping("/voteForBestMovieForm")
  public String voteForBestMovieFormPage() {
        return "voteForBestMovie";
    }

  @RequestMapping("/voteForBestMovie")
  public String voteForBestMovie(HttpServletRequest request, Model model) {

    String movieId = request.getParameter("movieId");
    String userName = request.getParameter("voterName");

    return "voteForBestMovie";
  }

  @RequestMapping("/addMovieForm")
  public String addMovieForm() {

    return "addMovie";
  }

   @RequestMapping("/addMovie")
   public String addMovie(HttpServletRequest request)  {

     String movieTitle = request.getParameter("movieTitle");
     String maturityRating = request.getParameter("maturityRating");
     String genre = request.getParameter("genre");

     MovieEntity movieEntity = new MovieEntity();
     movieEntity.setTitle(movieTitle);
     movieEntity.setMaturityRating(maturityRating);
     movieEntity.setGenre(genre);

     Session session = sessionFactory.getCurrentSession();

     session.beginTransaction();

     session.save(movieEntity);

     session.getTransaction().commit();

     return "addMovie";
  }
}
