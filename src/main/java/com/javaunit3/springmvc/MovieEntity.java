package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id")
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "maturity_rating")
  private String maturityRating;

  @Column(name = "genre")
  private String genre;

  private Integer getId() {
    return id;
  }

  private void setId(Integer id) {
    this.id = id;
  }

  private String getTitle() {
    return title;
  }

  private void setTitle() {
    this.title = title;
  }

  private String getMaturityRating() {
    return maturityRating;
  }

  private void setMaturityRating(String maturityRating) {
    this.maturityRating = maturityRating;
  }

  private String getGenre() {
    return genre;
  }

  private void setGenre() {
    this.genre = genre;
  }

}
