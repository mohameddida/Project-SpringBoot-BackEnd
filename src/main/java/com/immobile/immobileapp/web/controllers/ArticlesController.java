package com.immobile.immobileapp.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.services.ArticlesServices;
import com.immobile.immobileapp.web.models.requests.ArticleForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/articles")
public class ArticlesController {


  @Autowired
  ArticlesServices articlesServices;
  @GetMapping("/detail/{id}")
  public String showArticleDetail(@PathVariable("id") Long id, Model model) {
   Article article = articlesServices.getArticle(id);

      model.addAttribute("art", article);
    return "article_details";
  }
  @GetMapping
  public String showArticleList(Model model) {
    model.addAttribute("Articles", this.articlesServices.getAllArticles());
    return "Home";
  }
  @GetMapping("/gestion")
  public String adminarticle (Model model){
    model.addAttribute("articles", this.articlesServices.getAllArticles());
    return "gestion_articles";
  }





  // Create
  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("ArticleForm", new ArticleForm());
    return "create";
  }

  @PostMapping("/create")
  public String createArticle(@ModelAttribute("ArticleForm") @Valid ArticleForm articleForm,
      BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("article", articlesServices.getAllArticles());
      return "article/create";

    }


    Article article = new Article();
    article.setPrice(articleForm.getPrice());
    article.setEmplacement(articleForm.getEmplacement());
    article.setDescription(articleForm.getDescription());
    article.setImageMain(articleForm.getImageMain());
    article.setImageOne(articleForm.getImageOne());
    article.setImageTwo(articleForm.getImageTwo());
    article.setImageThree(articleForm.getImageThree());
    article.setNbrPiece(articleForm.getNbrPiece());
    article.setDisponible(articleForm.getDisponible());

    return "redirect:/articles";
  }

  // Read


  // Update
  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Article article = articlesServices.getArticle(id);
    model.addAttribute("article",article);


    return "editarticle";
  }

  @PostMapping("/{id}/edit")
  public String updateArticle(@PathVariable("id") Long id,
      @ModelAttribute("articleForm") @Valid ArticleForm articleForm,
      BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("disponible", articlesServices.getAllArticles());
      return "edit";

    }
    Article article = articlesServices.getArticle(id);

    if (article != null) {
      article.setPrice(articleForm.getPrice());
      article.setEmplacement(articleForm.getEmplacement());
      article.setDescription(articleForm.getDescription());
      article.setImageMain(articleForm.getImageMain());
      article.setImageOne(articleForm.getImageOne());
      article.setImageTwo(articleForm.getImageTwo());
      article.setImageThree(articleForm.getImageThree());
      article.setNbrPiece(articleForm.getNbrPiece());
      article.setDisponible(articleForm.getDisponible());
      articlesServices.updateArticle(article);
    } else {

    }

    return "redirect:/products";
  }


  @PostMapping("/delete/{id}")
  public String deleteArticle(@PathVariable Long id) {
    articlesServices.deleteArticle(id);
    return "redirect:/articles/gestion";
  }


}
